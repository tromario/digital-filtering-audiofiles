package ru.teslenko.audio.reader;

import com.sun.media.sound.WaveFileReader;
import ru.teslenko.audio.Audio;
import ru.teslenko.audio.IAudio;
import ru.teslenko.audio.data.AudioData;
import ru.teslenko.audio.data.IAudioData;
import ru.teslenko.audio.header.AudioHeader;
import ru.teslenko.audio.header.IAudioHeader;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class WaveReader extends Reader {

    private int bitDepth;
    private long framesCount;
    private int sampleSize;
    private float sampleRate;
    private int channelsCount;
    private double durationTime;

    @Override
    public IAudio read(String path) throws IOException, UnsupportedAudioFileException {
        AudioInputStream audioInputStream = new WaveFileReader().getAudioInputStream(new File(path));

        Audio audio = new Audio();
        audio.setAudioHeader(readHeader(audioInputStream));
        audio.setAudioData(readData(audioInputStream));

        return audio;
    }

    private IAudioHeader readHeader(AudioInputStream audioInputStream) {
        this.bitDepth = audioInputStream.getFormat().getSampleSizeInBits();
        this.framesCount = audioInputStream.getFrameLength();
        this.sampleSize = this.bitDepth / 8;
        this.sampleRate = audioInputStream.getFormat().getSampleRate();
        this.channelsCount = audioInputStream.getFormat().getChannels();
        this.durationTime = this.framesCount / this.sampleRate;

        AudioHeader audioHeader = new AudioHeader();
        audioHeader.setBitDepth(this.bitDepth);
        audioHeader.setFramesCount(this.framesCount);
        audioHeader.setSampleSize(this.sampleSize);
        audioHeader.setSampleRate(this.sampleRate);
        audioHeader.setChannelsCount(this.channelsCount);
        audioHeader.setDurationTime(this.durationTime);

        return audioHeader;
    }

    private IAudioData readData(AudioInputStream audioInputStream) {
        long dataLength = this.framesCount * this.bitDepth * this.channelsCount / 8;

        byte[] data = new byte[(int)dataLength];
        try {
            audioInputStream.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        double[] samples = getSamples(data, this.sampleSize, this.framesCount, this.bitDepth, this.channelsCount);

        AudioData audioData = new AudioData();
        audioData.setDataLength(dataLength);
        audioData.setData(data);
        audioData.setSamples(samples);

        return audioData;
    }

}
