package ru.teslenko.audio.reader;

public abstract class Reader implements IReader {

    protected double[] getSamples(byte[] data, int sampleSize, long framesCount, int bitDepth, int channelsCount) {
        return null;
    }

}
