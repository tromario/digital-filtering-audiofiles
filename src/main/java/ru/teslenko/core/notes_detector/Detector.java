package ru.teslenko.core.notes_detector;

import ru.teslenko.core.notes_detector.notes.Note;

public class Detector implements IDetector {

    private double[] times;
    private double[] frequencyNotes;
    private Note[] letterNotes;

    @Override
    public double[] getTimes() {
        return times;
    }

    public void setTimes(double[] times) {
        this.times = times;
    }

    public double[] getFrequencyNotes() {
        return frequencyNotes;
    }

    public void setFrequencyNotes(double[] frequencyNotes) {
        this.frequencyNotes = frequencyNotes;
    }

    @Override
    public Note[] getLetterNotes() {
        return letterNotes;
    }

    public void setLetterNotes(Note[] letterNotes) {
        this.letterNotes = letterNotes;
    }

}
