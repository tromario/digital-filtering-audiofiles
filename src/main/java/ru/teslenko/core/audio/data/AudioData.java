package ru.teslenko.core.audio.data;

public class AudioData implements IAudioData {

    private byte[] data;
    private long dataLength;
    private double[][] samples;

    @Override
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public long getDataLength() {
        return dataLength;
    }

    public void setDataLength(long dataLength) {
        this.dataLength = dataLength;
    }

    @Override
    public double[][] getSamples() {
        return samples;
    }

    public void setSamples(double[][] samples) {
        this.samples = samples;
    }

}
