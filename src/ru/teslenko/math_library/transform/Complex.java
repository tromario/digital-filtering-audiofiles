package ru.teslenko.math_library.transform;

/** Комплексное число */
// сделать видимость в пределах пакета
public class Complex {

    // действительная часть
    private double real;
    // мнимая часть
    private double imaginary;

    public Complex() {

    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    /** Скалярная сумма действительной части */
    public double addReal(double real) {
        this.real += real;
        return this.real;
    }

    /** Скалярная разность мнимой части */
    public double differenceImaginary(double imaginary) {
        this.imaginary -= imaginary;
        return this.imaginary;
    }

    /** Комплексная сумма */
    public Complex add(Complex b) {
        Complex a = this;
        double real = a.real + b.real;
        double imaginary = a.imaginary + b.imaginary;

        return new Complex(real, imaginary);
    }

    /** Комплексная сумма */
    public Complex add(Complex a, Complex b) {
        double real = a.real + b.real;
        double imaginary = a.imaginary + b.imaginary;

        return new Complex(real, imaginary);
    }

    /** Комплексная разность (this - b) */
    public Complex difference(Complex b) {
        Complex a = this;
        double real = a.real - b.real;
        double imaginary = a.imaginary - b.imaginary;

        return new Complex(real, imaginary);
    }

    /** Комплексное произведение (this * b) */
    public Complex multiply(Complex b) {
        Complex a = this;
        double real = a.real * b.real - a.imaginary * b.imaginary;
        double imaginary = a.real * b.imaginary + a.imaginary * b.real;

        return new Complex(real, imaginary);
    }

}
