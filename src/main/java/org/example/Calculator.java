package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Calculator {

    public int sum(int x, int y) {
        sleepRandomTime();
        return Math.addExact(x, y);
    }

    public int subtract(int x, int y) {
        sleepRandomTime();
        return Math.subtractExact(x, y);
    }

    public int multiple(int x, int y) {
        return Math.multiplyExact(x, y);
    }

    public double divideWithFloor(int x, int y) {
        sleepRandomTime();
        return Math.floorDiv(x, y);
    }

    public boolean isOdd(int x) {
        sleepRandomTime();
        return  x % 2 != 0;
    }

    public void sleepRandomTime() {
        try {
            final long millis = new Random().nextLong(25_000) + 5_000;
            log.info("Sleeping in calculation for [{}] seconds", millis / 1000);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
