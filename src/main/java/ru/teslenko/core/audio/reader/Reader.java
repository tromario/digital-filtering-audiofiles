package ru.teslenko.core.audio.reader;

import ru.teslenko.core.audio.reader.util.BitConverter;

public abstract class Reader implements IReader {

    protected double[][] getSamples(byte[] data, int sampleSize, long framesCount, int bitDepth, int channelsCount) {
        double[][] samples = new double[channelsCount][(int)framesCount];

        // индекс канала
        int channelIndex = 0;
        // индекс сэмпла в канале
        int sampleIndexInChannel = 0;

        long samplesCount = framesCount * channelsCount;
        for (int sampleNumber = 0; sampleNumber < samplesCount; sampleNumber++) {
            // байты одного сэмпла
            byte[] sampleBytes = new byte[sampleSize];

            for(int i = 0; i < sampleSize; i++){
                sampleBytes[i] = data[sampleNumber * sampleSize + i];
            }

            // для моно канала считывание происходит последовательно
            // для стерео канала считывание происходит поэтапно: левый канал - правый канал
            samples[channelIndex++][sampleIndexInChannel] = getSample(sampleBytes, bitDepth);
            if (channelIndex == channelsCount) {
                channelIndex = 0;
                sampleIndexInChannel++;
            }
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
