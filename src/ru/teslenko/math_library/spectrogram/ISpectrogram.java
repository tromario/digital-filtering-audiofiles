package ru.teslenko.math_library.spectrogram;

/** Интерфейс спектограммы */
public interface ISpectrogram {

    /** Значения амплитуд */
    public double[][] getAmplitude();

    /** Значения частот */
    public double[] getFrequencies();

    /** Интервалы времени */
    public double[] getTimes();

}
