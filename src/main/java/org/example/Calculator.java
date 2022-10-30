package org.example;

public class Calculator {

    public int sum(int x, int y) {
        return Math.addExact(x, y);
    }

    public int subtract(int x, int y) {
        return Math.subtractExact(x, y);
    }

    public int multiple(int x, int y) {
        return Math.multiplyExact(x, y);
    }

    public double divide(int x, int y) {
        return Math.floorDiv(x, y);
    }

}
