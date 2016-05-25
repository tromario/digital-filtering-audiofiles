package ru.teslenko.math_library.transform.fourier;

import ru.teslenko.math_library.complex.Complex;
import ru.teslenko.math_library.transform.ITransform;

/** Быстрое преобразование Фурье */
public class FFT implements ITransform {
    @Override
    public Complex[] transform(double[] data) {
        return transform(data, data.length);
    }

    @Override
    public Complex[] transform(double[] data, int lengthTransform) {
        Complex[] complexData = Complex.parseComplex(data);
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

        // если длина массива не является степенью 2
        if (!isNumPow2(lengthTransform)) {
            System.out.println("Длина массива не является степенью 2");

            // получить новую длину, которая является степенью 2
            lengthTransform = nextNumPow2(lengthTransform);
        }

        // если длина массива меньше окна, то дополнить массив нулями
        if (complexData.length < lengthTransform) {
            Complex[] newComplexData = new Complex[lengthTransform];

            for (int i = 0; i < complexData.length; i++) {
                newComplexData[i] = complexData[i];
            }
            for (int i = complexData.length; i < lengthTransform; i++) {
                newComplexData[i] = new Complex(0, 0);
            }

            complexData = newComplexData;
        }
        // если длина массива больше окна, то обрезать массив
        else if (complexData.length > lengthTransform) {
            Complex[] newComplexData = new Complex[lengthTransform];

            for (int i = 0; i < lengthTransform; i++) {
                newComplexData[i] = complexData[i];
            }

            complexData = newComplexData;
        }

        return fft(complexData);
    }

    @Override
    public Complex[] inverseTransform() {
        return new Complex[0];
    }


    /** Является ли число степенью 2 */
    private boolean isNumPow2(int value) {
        return ((value & (value - 1)) == 0);
    }

    /** Следующее число степени 2 */
    private int nextNumPow2(int value) {
        // степень длины массива c округлением в большую сторону
        double power = Math.round(Math.log(value)/Math.log(2));
        // вычисляем новую длину
        double newValue = Math.pow(2, power);

        // если исходная длина все равно больше расчитанной, то
        if (value > newValue) {
            // вычисляем новую длину на степень больше
            newValue = Math.pow(2, power + 1);
        }

        return (int)newValue;
    }


    private Complex[] fft(Complex[] data) {
        int lengthData = data.length;

        // оставить базовый вариант
        if (lengthData == 1) {
            return new Complex[] { data[0] };
        }

        // Cooley-Tukey
        if (lengthData % 2 != 0) {
            throw new RuntimeException("Длина массива не является степенью 2");
        }

        // четная половина
        Complex[] even = new Complex[lengthData / 2];
        for (int k = 0; k < lengthData / 2; k++) {
            even[k] = data[2 * k];
        }
        Complex[] q = fft(even);

        // нечетная половина
        Complex[] odd = even;
        for (int k = 0; k < lengthData / 2; k++) {
            odd[k] = data[2 * k + 1];
        }
        Complex[] r = fft(odd);

        // скомбинировать
        double arg = -2 * Math.PI / lengthData;
        Complex[] complexData = new Complex[lengthData];
        for (int k = 0; k < lengthData / 2; k++) {
            Complex wk = new Complex(Math.cos(arg * k), Math.sin(arg * k));
            complexData[k] = q[k].add(wk.multiply(r[k]));
            complexData[k + lengthData / 2] = q[k].difference(wk.multiply(r[k]));
        }

        return complexData;
    }
}
