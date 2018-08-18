package ru.teslenko.core.audio;

import ru.teslenko.core.audio.data.IAudioData;
import ru.teslenko.core.audio.header.IAudioHeader;

/** Интерфейс, представляющий область заголовка и данных аудиофайла */
public interface IAudio {

    /** Область заголовка */
    public IAudioHeader getAudioHeader();

    /** Область данных */
    public IAudioData getAudioData();

}
