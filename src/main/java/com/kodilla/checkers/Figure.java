package com.kodilla.checkers;

import javafx.scene.image.Image;

public class Figure {

    private Image whiteFigure = new Image("file:src/main/resources/white.png");
    private Image blackFigure = new Image("file:src/main/resources/black.png");

    public Image getWhiteFigure() {
        return whiteFigure;
    }

    public Image getBlackFigure() {
        return blackFigure;
    }
}