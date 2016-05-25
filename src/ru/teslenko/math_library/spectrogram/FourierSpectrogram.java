package ru.teslenko.math_library.spectrogram;

import ru.teslenko.math_library.complex.Complex;
import ru.teslenko.math_library.transform.fourier.STFT;
import java.util.ArrayList;
import java.util.List;

/** Спекторграмма методом Фурье */
public class FourierSpectrogram {

    // значение по умолчанию
    private static final float SAMPLE_RATE = 44100f;

    /** @param data аудио данные
     **/
    public ISpectrogram calculation(double[] data) {
        STFT shortTimeFourierTransform = new STFT();

        // спектральная плотность мощности
        Complex[][] spectrumDensityPower = shortTimeFourierTransform.transform(data);
        // длина преобразования
        int lengthTransform = shortTimeFourierTransform.getDefaultLengthTransform();
        // окно перекрытия
        int lengthOverlap = shortTimeFourierTransform.getDefaultLengthOverlap();

        double[][] amplitude = getAmplitude(spectrumDensityPower);
        double[] frequencies = getFrequencies(lengthTransform, SAMPLE_RATE);
        double[] times = getTimes(lengthTransform, lengthOverlap, SAMPLE_RATE, data.length);

        Spectrogram spectrogram = new Spectrogram();
        spectrogram.setAmplitude(amplitude);
        spectrogram.setFrequencies(frequencies);
        spectrogram.setTimes(times);

        return spectrogram;
    }

    /** @param data аудио данные
     *  @param window оконная функция
     *  @param lengthTransform длина преобразования
     *  @param lengthOverlap окно перекрытия
     **/
    public ISpectrogram calculation(double[] data, double[] window, int lengthTransform, int lengthOverlap, float sampleRate) {
        // спектральная плотность мощности
        Complex[][] spectrumDensityPower = new STFT().transform(data, window, lengthTransform, lengthOverlap);

        double[][] amplitude = getAmplitude(spectrumDensityPower);
        double[] frequencies = getFrequencies(lengthTransform, sampleRate);
        double[] times = getTimes(lengthTransform, lengthOverlap, sampleRate, data.length);

        Spectrogram spectrogram = new Spectrogram();
        spectrogram.setAmplitude(amplitude);
        spectrogram.setFrequencies(frequencies);
        spectrogram.setTimes(times);

        return spectrogram;
    }

    /** Расчет значений амплитуд */
    private double[][] getAmplitude(Complex[][] S) {
        int rows = S.length;
        int columns = S[0].length;

        double[][] amplitude = new double[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                double abs = S[row][column].abs();
                amplitude[row][column] = 20 * Math.log10(abs);
            }
        }

        return amplitude;
    }

    /** Расчет значений частот */
    private double[] getFrequencies(int lengthTransform, float sampleRate) {
        int rows = Math.round(lengthTransform / 2);

        double[] frequencies = new double[rows];
        for (int i = 0; i < rows; i++) {
            frequencies[i] = (float)i / (float)lengthTransform * sampleRate;
        }

        return frequencies;
    }

    /** Расчет интервалов времени */
    private double[] getTimes(int lengthTransform, int lengthOverlap, float sampleRate, int lengthData) {
        double begin = Math.round(lengthTransform / 2) / sampleRate;
        double end = (lengthData - Math.round(lengthTransform / 2)) / sampleRate;
        double increment = (lengthTransform - lengthOverlap) / sampleRate;

        List<Double> timeList = new ArrayList<>();

        while (begin < end) {
            timeList.add(begin);
            begin += increment;
        }

        int rows = timeList.size();
        double[] times = new double[rows];
        for (int i = 0; i < rows; i++) {
            times[i] = timeList.get(i);
        }

        return times;
    }

}
