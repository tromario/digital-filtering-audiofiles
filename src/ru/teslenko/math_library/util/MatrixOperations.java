package ru.teslenko.math_library.util;

import ru.teslenko.math_library.complex.Complex;

public class MatrixOperations {

    /** Транспонирование матрицы */
    public static Complex[][] transposition(Complex[][] data) {
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

}
