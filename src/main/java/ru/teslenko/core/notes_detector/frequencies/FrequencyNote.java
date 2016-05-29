package ru.teslenko.core.notes_detector.frequencies;

import ru.teslenko.core.math_library.util.Matrix;
import ru.teslenko.core.math_library.util.MatrixOperations;

public class FrequencyNote {

    /** Получение частоты в результате сопоставления индекса максимального пика с индексом частоты в спекторграмме */
    public double[] receivingFrequency(double[][] amplitude, double[] frequencies) {
        int[] maxIndexAmplitude = determinationMaximumPeakAmplitude(amplitude);
        int rows = maxIndexAmplitude.length;

        double[] frequencyNotes = new double[rows];
        for (int row = 0; row < rows; row++) {
            int index = maxIndexAmplitude[row];
            frequencyNotes[row] = frequencies[index];
        }

        return frequencyNotes;
    }

    /** Определение максимального пика по амплитуде за моменты времени */
    private int[] determinationMaximumPeakAmplitude(double[][] amplitude) {
        Matrix matrix = new MatrixOperations().max(amplitude);

        return matrix.getMaxIndex();
    }

}
