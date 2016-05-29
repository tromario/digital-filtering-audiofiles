package ru.teslenko.core.audio;

import ru.teslenko.core.audio.data.IAudioData;
import ru.teslenko.core.audio.header.IAudioHeader;

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
