package com.kodilla.checkers;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Pawn extends Circle {

    double radius;

    public Pawn(double radius, Paint fill) {
        super(radius, fill);
    }
}