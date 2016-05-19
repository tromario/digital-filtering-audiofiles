package ru.teslenko.audio;

import ru.teslenko.audio.data.IAudioData;
import ru.teslenko.audio.header.IAudioHeader;

public class Audio implements IAudio {

    private IAudioHeader audioHeader;
    private IAudioData audioData;

    @Override
    public IAudioHeader getAudioHeader() {
        return audioHeader;
    }

    public void setAudioHeader(IAudioHeader audioHeader) {
        this.audioHeader = audioHeader;
    }

    @Override
    public IAudioData getAudioData() {
        return audioData;
    }

    public void setAudioData(IAudioData audioData) {
        this.audioData = audioData;
    }

}
