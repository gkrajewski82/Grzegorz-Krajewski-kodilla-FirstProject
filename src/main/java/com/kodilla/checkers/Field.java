package com.kodilla.checkers;

import javafx.scene.control.Button;

public class Field extends Button {

    private Pawn pawn;
    private int x;
    private int y;

    public Field(Pawn pawn, int x, int y) {
        this.pawn = pawn;
        this.x = x;
        this.y = y;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
        this.setGraphic(pawn);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
