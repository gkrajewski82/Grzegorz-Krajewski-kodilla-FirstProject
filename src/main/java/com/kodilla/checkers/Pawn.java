package com.kodilla.checkers;

import javafx.scene.control.Button;

public class Pawn extends Button {

    PawnImage pawnImage;
    private int x;
    private int y;

    public Pawn(PawnImage pawnImage, int x, int y) {
        this.pawnImage = pawnImage;
        this.x = x;
        this.y = y;
    }

    public PawnImage getPawnImage() {
        return pawnImage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}