package ru.teslenko.math_library.spectrogram;

public class Spectrogram implements ISpectrogram {

    private double[][] amplitude;
    private double[] frequencies;
    private double[] times;

    @Override
    public double[][] getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(double[][] amplitude) {
        this.amplitude = amplitude;
    }

    @Override
    public double[] getFrequencies() {
        return frequencies;
    }

    public void setFrequencies(double[] frequencies) {
        this.frequencies = frequencies;
    }

    @Override
    public double[] getTimes() {
        return times;
    }

    public void setTimes(double[] times) {
        this.times = times;
    }
}
