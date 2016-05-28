package ru.teslenko.math_library.util;

import ru.teslenko.math_library.complex.Complex;

public class MatrixOperations extends Matrix {

    /** Транспонирование матрицы */
    public Complex[][] transposition(Complex[][] data) {
        int rows = data.length;
        int columns = data[0].length;

        Complex[][] transposedData = new Complex[columns][rows];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                transposedData[column][row] = data[row][column];
            }
        }

        return transposedData;
    }

    /** Поиск максимума в каждом столбце */
    public Matrix max(double[][] data) {
        int rows = data.length;
        int columns = data[0].length;

        this.maxValue = new double[columns];
        this.maxIndex = new int[columns];

        for (int column = 0; column < columns; column++) {
            this.maxIndex[column] = 0;
            this.maxValue[column] = data[0][column];
            for (int row = 0; row < rows; row++) {
                if (data[row][column] > this.maxValue[column]) {
                    this.maxValue[column] = data[row][column];
                    this.maxIndex[column] = row;
                }
            }
        }

        return this;
    }

}
