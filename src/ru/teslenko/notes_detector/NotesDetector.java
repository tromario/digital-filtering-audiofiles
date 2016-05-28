package ru.teslenko.notes_detector;

import ru.teslenko.math_library.spectrogram.ISpectrogram;
import ru.teslenko.notes_detector.frequencies.FrequencyNote;
import ru.teslenko.notes_detector.notes.LetterNote;
import ru.teslenko.notes_detector.notes.Note;

public class NotesDetector {

    public IDetector detect(ISpectrogram spectrogram) {
        double[] times = spectrogram.getTimes();
        double[][] amplitude = spectrogram.getAmplitude();
        double[] frequencies = spectrogram.getFrequencies();

        double[] frequencyNotes = formationFrequencySpectrumInFrequencyNotes(amplitude, frequencies);
        Note[] letterNotes = formationFrequenciesInLetter(frequencyNotes);

        Detector detector = new Detector();
        detector.setTimes(times);
        detector.setFrequencyNotes(frequencyNotes);
        detector.setLetterNotes(letterNotes);

        return detector;
    }

    /** Формирование частот спектра в частоты нот */
    private double[] formationFrequencySpectrumInFrequencyNotes(double[][] amplitude, double[] frequencies) {
        return new FrequencyNote().receivingFrequency(amplitude, frequencies);
    }

    /** Формирование частот нот в буквенное обозначение */
    private Note[] formationFrequenciesInLetter(double[] frequencyNotes) {
        int rows = frequencyNotes.length;
        Note[] notes = new Note[rows];

        for (int row = 0; row < rows; row++) {
            notes[row] = new LetterNote().comparisonFrequencyNotesWithLetter(frequencyNotes[row]);
        }

        return notes;
    }

}
