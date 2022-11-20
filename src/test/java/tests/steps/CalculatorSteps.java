package tests.steps;

import io.qameta.allure.Step;
import org.example.Calculator;

public class CalculatorSteps {

    private Calculator calculator;

    public CalculatorSteps() {
        calculator = new Calculator();
    }

    @Step("Sum step")
    public int sum(int x, int y) {
        return calculator.sum(x, y);
    }

    @Step("Subtract step")
    public int subtract(int x, int y) {
        return calculator.subtract(x, y);
    }

    @Step("Multiple step")
    public int multiple(int x, int y) {
        return calculator.multiple(x, y);
    }

    @Step("Divide step")
    public double divideWithFloor(int x, int y) {
        return calculator.divideWithFloor(x, y);
    }

    public boolean isOdd(int x) {
        return calculator.isOdd(x);
    }

}
