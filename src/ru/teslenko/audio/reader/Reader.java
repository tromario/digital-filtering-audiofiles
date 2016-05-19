package ru.teslenko.audio.reader;

import ru.teslenko.audio.reader.util.BitConverter;

public abstract class Reader implements IReader {

    protected double[] getSamples(byte[] data, int sampleSize, long framesCount, int bitDepth, int channelsCount) {
        long samplesCount = framesCount * channelsCount;
        double[] samples = new double[(int)samplesCount];

        for (int sampleNumber = 0; sampleNumber < samplesCount; sampleNumber++) {
            byte[] sampleBytes = new byte[sampleSize];

            for(int i = 0; i < sampleSize; i++){
                sampleBytes[i] = data[sampleNumber * sampleSize + i];
            }

            samples[sampleNumber] = getSample(sampleBytes, bitDepth);
        }

        return samples;
    }

    private double getSample(byte[] sampleBytes, int bitDepth) {
        double normalization = Math.pow(2, bitDepth - 1);

        int converterBytes = 0;

        switch(bitDepth) {
            case 8:
                converterBytes = BitConverter.toInt8(sampleBytes);
                break;
            case 16:
                converterBytes = BitConverter.toInt16(sampleBytes);
                break;
            case 24:
                break;
            case 32:
                converterBytes = BitConverter.toInt32(sampleBytes);
                break;
        }

        return converterBytes / normalization;
    }

}
