package ru.teslenko.core.audio.header;

/** Интерфейс, представляющий область заголовка аудиофайла */
public interface IAudioHeader {

    /** Глубина звука: 8, 16, 32 */
    public int getBitDepth();

    /** Количество фреймов (кадров) */
    public long getFramesCount();

    /** Размер сэмпла в байтах: 1, 2, 4 */
    public int getSampleSize();

    /** Частота дискритизации: 44000, 48000 */
    public float getSampleRate();

    /** Количество каналов: 1 (моно), 2 (стерео) */
    public int getChannelsCount();

    /** Продолжительность сигнала */
    public double getDurationTime();

}
