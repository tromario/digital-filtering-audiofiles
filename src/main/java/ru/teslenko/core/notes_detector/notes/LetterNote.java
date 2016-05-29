package ru.teslenko.core.notes_detector.notes;

public class LetterNote {

    // частота ноты До
    private float frequencyNoteC;

    /** Сопоставление частоты ноты с буквой */
    public Note comparisonFrequencyNotesWithLetter(double frequencyNote) {
        Note note = null;

        // частота ноты До определенной октавы
        this.frequencyNoteC = detectOctave(frequencyNote);

        if ((frequencyNote >= nextValueFrequency(Note.C.ordinal())) && (frequencyNote < nextValueFrequency((Note.CSharp.ordinal())))) {
            note = Note.C;
        }
        else if ((frequencyNote > nextValueFrequency(Note.CSharp.ordinal())) && (frequencyNote < nextValueFrequency(Note.D.ordinal()))) {
            note = Note.CSharp;
        }
        else if ((frequencyNote > nextValueFrequency(Note.D.ordinal())) && (frequencyNote < nextValueFrequency(Note.DSharp.ordinal()))) {
            note = Note.D;
        }
        else if ((frequencyNote > nextValueFrequency(Note.DSharp.ordinal())) && (frequencyNote < nextValueFrequency(Note.E.ordinal()))) {
            note = Note.DSharp;
        }
        else if ((frequencyNote > nextValueFrequency(Note.E.ordinal())) && (frequencyNote < nextValueFrequency(Note.F.ordinal()))) {
            note = Note.E;
        }
        else if ((frequencyNote > nextValueFrequency(Note.F.ordinal())) && (frequencyNote < nextValueFrequency(Note.FSharp.ordinal()))) {
            note = Note.F;
        }
        else if ((frequencyNote > nextValueFrequency(Note.FSharp.ordinal())) && (frequencyNote < nextValueFrequency(Note.G.ordinal()))) {
            note = Note.FSharp;
        }
        else if ((frequencyNote > nextValueFrequency(Note.G.ordinal())) && (frequencyNote < nextValueFrequency(Note.GSharp.ordinal()))) {
            note = Note.G;
        }
        else if ((frequencyNote > nextValueFrequency(Note.GSharp.ordinal())) && (frequencyNote < nextValueFrequency(Note.A.ordinal()))) {
            note = Note.GSharp;
        }
        else if ((frequencyNote > nextValueFrequency(Note.A.ordinal())) && (frequencyNote < nextValueFrequency(Note.ASharp.ordinal()))) {
            note = Note.A;
        }
        else if ((frequencyNote > nextValueFrequency(Note.ASharp.ordinal())) && (frequencyNote < nextValueFrequency(Note.H.ordinal()))) {
            note = Note.ASharp;
        }
        else if ((frequencyNote > nextValueFrequency(Note.H.ordinal())) && (frequencyNote < nextValueFrequency(12))) {
            note = Note.H;
        }

        return note;
    }

    /** Определение октавы
     * Возврат частоты ноты До найденной октавы */
    private float detectOctave(double frequencyNote) {
        if ((frequencyNote >= 16.352) && (frequencyNote < 32.703)) {
            // субконтр октава
            return 16.352f;
        }
        else if ((frequencyNote >= 32.703) && (frequencyNote < 65.406)) {
            // контр октава
            return 32.703f;
        }
        else if ((frequencyNote >= 65.406) && (frequencyNote < 130.81)) {
            // большая октава
            return 65.406f;
        }
        else if ((frequencyNote >= 130.81) && (frequencyNote < 261.63)) {
            // малая октава
            return 130.81f;
        }
        else if ((frequencyNote >= 261.63) && (frequencyNote < 523.25)) {
            // 1 октава
            return 261.63f;
        }
        else if ((frequencyNote >= 523.25) && (frequencyNote < 1046.5)) {
            // 2 октава
            return 523.25f;
        }
        else if ((frequencyNote >= 1046.5) && (frequencyNote < 2093.0)) {
            // 3 октава
            return 1046.5f;
        }
        else if ((frequencyNote >= 2093.0) && (frequencyNote < 4186.0)) {
            // 4 октава
            return 2093.0f;
        }
        else if ((frequencyNote >= 4186.0) && (frequencyNote < 8372.0)) {
            // 5 октава
            return 4186.0f;
        }
        else if ((frequencyNote >= 8372.0) && (frequencyNote < 16744.0)) {
            // 6 октава
            return 8372.0f;
        }
        else if ((frequencyNote >= 16744.0) && (frequencyNote < 31608.5)) {
            // 7 октава
            return 16744.0f;
        }

        return 0;
    }

    /** Значение следующей частоты от ноты C */
    private float nextValueFrequency(int n) {
        float increment = 1.0594631f;

        if (n == 0) {
            return this.frequencyNoteC;
        }

        return this.frequencyNoteC * (float)Math.pow(increment, n);
    }

}
