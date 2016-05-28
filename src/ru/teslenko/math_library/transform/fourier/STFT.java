package ru.teslenko.math_library.transform.fourier;

import ru.teslenko.math_library.complex.Complex;
import ru.teslenko.math_library.util.MatrixOperations;
import java.util.ArrayList;
import java.util.List;

/** Кратко-временное преобразование Фурье */
public class STFT {

    // значения по умолчанию
    private static final int LENGTH_TRANSFORM = 1024;
    private static final int LENGTH_OVERLAP = 512;

    /** @param data аудио данные
     **/
    public Complex[][] transform(double[] data) {
        double[] window = null;

        return transform(data, window, LENGTH_TRANSFORM, LENGTH_OVERLAP);
    }

    /** @param data аудио данные
     *  @param window оконная функция
     *  @param lengthTransform длина преобразования
     *  @param lengthOverlap окно перекрытия
     **/
    public Complex[][] transform(double[] data, double[] window, int lengthTransform, int lengthOverlap) {
        int lengthData = data.length;

        // спектральная плотность мощности
        List<List<Complex>> spectrumDensityPower = new ArrayList<>();

        int position = 0;
        while (position + lengthTransform <= lengthData) {
            double[] frame = new double[lengthTransform];
            for (int pos = position, index = 0; pos < position + lengthTransform; pos++, index++) {
                frame[index] = data[pos];
            }

            position += (lengthTransform - lengthOverlap);
            // TODO: перед вычислением спектра умножить сигнал на окно
            Complex[] spectrum = new FFT().transform(frame, lengthTransform);

            List<Complex> tempSpectrum = new ArrayList<>();
            for (int i = 0; i < Math.round(lengthTransform / 2); i++) {
                tempSpectrum.add(spectrum[i]);
            }
            spectrumDensityPower.add(tempSpectrum);
        }

        return new MatrixOperations().transposition(Complex.parseComplex(spectrumDensityPower));
    }

    public int getDefaultLengthTransform() {
        return LENGTH_TRANSFORM;
    }

    public int getDefaultLengthOverlap() {
        return LENGTH_OVERLAP;
    }

}
