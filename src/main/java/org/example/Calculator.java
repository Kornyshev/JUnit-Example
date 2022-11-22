package org.example;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Calculator implements CalculatorService {

    @Step("Sum step")
    @Override
    public int sum(int x, int y) {
        sleepRandomTime();
        return Math.addExact(x, y);
    }

    @Step("Subtract step")
    @Override
    public int subtract(int x, int y) {
        sleepRandomTime();
        return Math.subtractExact(x, y);
    }

    @Step("Multiple step")
    @Override
    public int multiple(int x, int y) {
        return Math.multiplyExact(x, y);
    }

    @Step("Divide step")
    @Override
    public double divideWithFloor(int x, int y) {
        sleepRandomTime();
        return Math.floorDiv(x, y);
    }

    @Step("IsOdd step")
    @Override
    public boolean isOdd(int x) {
        sleepRandomTime();
        return  x % 2 != 0;
    }

    private void sleepRandomTime() {
        try {
            final long millis = new Random().nextLong(25_000) + 5_000;
            log.info("Sleeping in calculation for [{}] seconds", millis / 1000);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
