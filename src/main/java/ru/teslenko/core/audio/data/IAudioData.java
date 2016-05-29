package ru.teslenko.core.audio.data;

/** Интерфейс, представляющий область данных аудиофайла */
public interface IAudioData {

    /** Байты аудиофайла */
    public byte[] getData();

    /** Размер данных файла */
    public long getDataLength();

    /** Нормализованные сэмплы аудиофайла */
    public double[][] getSamples();

}
