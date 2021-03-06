package ru.teslenko.core.notes_detector;

import ru.teslenko.core.notes_detector.notes.Note;

/** Интерфейс гармонической картины аудиофайла */
public interface IDetector {

    /** Время звучания нот */
    public double[] getTimes();

    /** Частота нот */
    public double[] getFrequencyNotes();

    /** Ноты в буквенном обозначении */
    public Note[] getLetterNotes();

}
