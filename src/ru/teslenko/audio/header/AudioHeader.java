package ru.teslenko.audio.header;

public class AudioHeader implements IAudioHeader {

    private int bitDepth;
    private long framesCount;
    private int sampleSize;
    private float sampleRate;
    private int channelsCount;
    private double durationTime;

    @Override
    public int getBitDepth() {
        return bitDepth;
    }

    public void setBitDepth(int bitDepth) {
        this.bitDepth = bitDepth;
    }

    @Override
    public long getFramesCount() {
        return framesCount;
    }

    public void setFramesCount(long framesCount) {
        this.framesCount = framesCount;
    }

    @Override
    public int getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(int sampleSize) {
        this.sampleSize = sampleSize;
    }

    @Override
    public float getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(float sampleRate) {
        this.sampleRate = sampleRate;
    }

    @Override
    public int getChannelsCount() {
        return channelsCount;
    }

    public void setChannelsCount(int channelsCount) {
        this.channelsCount = channelsCount;
    }

    @Override
    public double getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(double durationTime) {
        this.durationTime = durationTime;
    }

}
