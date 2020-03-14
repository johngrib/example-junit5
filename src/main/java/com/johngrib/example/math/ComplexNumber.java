package com.johngrib.example.math;

import java.util.Objects;

/**
 * 복소수를 정의한다
 */
public class ComplexNumber {
    private double real;
    private double imagine;

    private ComplexNumber() {
    }

    private ComplexNumber(double real, double imagine) {
        this.real = real;
        this.imagine = imagine;
    }

    public static ComplexNumber of(double real, double imagine) {
        return new ComplexNumber(real, imagine);
    }

    public static ComplexNumber of(double real) {
        return new ComplexNumber(real, 0);
    }

    /**
     * 두 복소수의 덧셈을 연산한다
     *
     * @param a 첫 번째 복소수
     * @param b 두 번째 복소수
     * @return 두 복소수의 합
     */
    public static ComplexNumber sum(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.real + b.real, a.imagine + b.imagine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ComplexNumber complex = (ComplexNumber) o;
        return Double.compare(complex.real, real) == 0 &&
                Double.compare(complex.imagine, imagine) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imagine);
    }

    @Override
    public String toString() {
        if (imagine == 0D) {
            return String.format("%f", real);
        }
        return String.format("%f+%fi", real, imagine);
    }

    public double getReal() {
        return real;
    }

    public double getImagine() {
        return imagine;
    }
}
