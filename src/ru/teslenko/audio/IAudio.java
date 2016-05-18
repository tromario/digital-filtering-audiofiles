package ru.teslenko.audio;

import ru.teslenko.audio.data.IAudioData;
import ru.teslenko.audio.header.IAudioHeader;

/** Интерфейс, представляющий область заголовка и данных аудиофайла */
public interface IAudio {

    /** Область заголовка */
    public IAudioHeader getAudioHeader();

    /** Область данных */
    public IAudioData getAudioData();

}
