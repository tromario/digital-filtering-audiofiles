package ru.teslenko.math_library.transform;

/** Дискретное преобразование Фурье */
public class DFT {

    /** Прямое дискретное преобразование Фурье */
    public static Complex[] directDiscreteFourierTransform(double[] data) {
        return directDiscreteFourierTransform(data, data.length);
    }

    /** Прямое дискретное преобразование Фурье */
    public static Complex[] directDiscreteFourierTransform(double[] data, int lengthDFT) {
        Complex[] complexData = new Complex[lengthDFT];

        for (int k = 0; k < lengthDFT; k++) {

            complexData[k] = new Complex();
            for (int n = 0; n < lengthDFT; n++) {
                // можно оптимизировать
                double arg = 2 * Math.PI * k * n / lengthDFT;

                complexData[k].addReal(data[n] * Math.cos(arg));
                complexData[k].differenceImaginary(data[n] * Math.sin(arg));
            }

        }

        return complexData;
    }

}
