package com.example.appoperations;

public class Operation {
    private double num1;
    private double num2;


    public Double getResult(String operation, double num1, double num2) throws Exception {
        switch (operation) {
            case "+":
                return this.sum(num1, num2);
            case "-":
                return this.subtraction(num1, num2);
            case "*":
                return this.multiplication(num1, num2);

            case "/":
                if (num2 == 0)
                    throw new Exception("El divisor no puede ser 0");
                return this.division(num1, num2);
            case "lcm":
                return this.leastCommonMultiple((int) num1, (int) num2);
            case "gcd":
                return this.greatestCommonDivisor((int) num1, (int) num2);
        }
        return null;
    }

    private double sum(double num1, double num2) {
        return num1 + num2;
    }

    private double subtraction(double num1, double num2) {
        return num1 - num2;
    }

    private double multiplication(double num1, double num2) {
        return num1 * num2;
    }

    private double division(double num1, double num2) {
        return num1 / num2;
    }

    private double greatestCommonDivisor(int num1, int num2) {
        int gcd = 0;
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        do {
            gcd = b;
            b = a % b;
            a = gcd;
        } while (b != 0);

        return (double) gcd;
    }

    private double leastCommonMultiple(int num1, int num2) {
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        return (double)((a / greatestCommonDivisor(a, b)) * b);
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }
}
