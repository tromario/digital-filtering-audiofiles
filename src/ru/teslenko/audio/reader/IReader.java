package ru.teslenko.audio.reader;

import ru.teslenko.audio.IAudio;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/** Интерфейс получения данных с аудиофайла */
public interface IReader {

    /** Чтение аудиофайла */
    public IAudio read(String path) throws IOException, UnsupportedAudioFileException;

}
