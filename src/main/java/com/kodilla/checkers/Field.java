package com.kodilla.checkers;

import javafx.scene.control.Button;

public class Field extends Button {

    private FieldImage fieldImage;
    private int x;
    private int y;

    public Field(FieldImage fieldImage, int x, int y) {
        this.fieldImage = fieldImage;
        this.x = x;
        this.y = y;
    }

    public FieldImage getFieldImage() {
        return fieldImage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}