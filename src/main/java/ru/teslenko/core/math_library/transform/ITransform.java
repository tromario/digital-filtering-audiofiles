package ru.teslenko.core.math_library.transform;

import ru.teslenko.core.math_library.complex.Complex;

public interface ITransform {

    Complex[] transform(double[] data);
    Complex[] transform(double[] data, int lengthTransform);

    Complex[] inverseTransform();

}