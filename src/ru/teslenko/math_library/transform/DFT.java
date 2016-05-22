package ru.teslenko.math_library.transform;

import ru.teslenko.math_library.complex.Complex;

/** Дискретное преобразование Фурье */
public class DFT implements ITransform {

    @Override
    public Complex[] transform(double[] data) {
        return transform(data, data.length);
    }

    @Override
    public Complex[] transform(double[] data, int lengthTransform) {
        // data = 1024;
        // lengthTransform = 1024;
        // +

        // data = 1024;
        // lengthTransform = 2048;
        // +

        // data = 1024;
        // lengthTransform = 512;
        // +

        // data = 1024;
        // lengthTransform = 333;
        // +

        // data = 1024;
        // lengthTransform = 2088;
        // +

        if (lengthTransform <= 0) {
            System.out.println("Длина окна <= 0");
            return new Complex[0];
        }

        // если длина массива меньше окна, то дополнить массив нулями
        if (data.length < lengthTransform) {
            double[] newComplexData = new double[lengthTransform];

            for (int i = 0; i < data.length; i++) {
                newComplexData[i] = data[i];
            }
            for (int i = data.length; i < lengthTransform; i++) {
                newComplexData[i] = 0;
            }

            data = newComplexData;
        }
        // если длина массива больше окна, то обрезать массив
        else if (data.length > lengthTransform) {
            double[] newComplexData = new double[lengthTransform];

            for (int i = 0; i < lengthTransform; i++) {
                newComplexData[i] = data[i];
            }

            data = newComplexData;
        }

        return dft(data);
    }

    @Override
    public Complex[] inverseTransform() {
        return new Complex[0];
    }

    private Complex[] dft(double[] data) {
        int lengthData = data.length;

        Complex[] complexData = new Complex[lengthData];

        for (int k = 0; k < lengthData; k++) {

            complexData[k] = new Complex();
            for (int n = 0; n < lengthData; n++) {
                // можно оптимизировать
                double arg = 2 * Math.PI * k * n / lengthData;

                complexData[k].addReal(data[n] * Math.cos(arg));
                complexData[k].differenceImaginary(data[n] * Math.sin(arg));
            }

        }

        return complexData;
    }
}
