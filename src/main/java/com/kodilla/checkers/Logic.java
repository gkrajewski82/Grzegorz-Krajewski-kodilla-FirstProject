package com.kodilla.checkers;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;

public class Logic {

    public Field[][] logicImplementation(Field fieldTable[][]) {

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                fieldTable[x][y].setOnAction(event -> {
                    Field clickedField = (Field) event.getSource();
                    Pawn pawnOnField = clickedField.getPawn();

                    boolean isFieldSelected = GameState.actualField != null;
                    if (isFieldSelected && pawnOnField == null) {
                        System.out.println("Przenoszę");
                        movePawn(clickedField, fieldTable);
                    } else {
                        if (clickedField.getPawn() == null) {
                            System.out.println("Wybierz pole z pionkiem!");
                        }
                        selectPawn(clickedField);
                        System.out.println("Pole zostało zaznaczone!");
                    }
                });
            }
        }
        return fieldTable;
    }

    private void movePawn(Field destinationField, Field fieldTable[][]) {
        int oldX = GameState.actualField.getX();
        int oldY = GameState.actualField.getY();
        int destinationFieldX = destinationField.getX();
        int destinationFieldY = destinationField.getY();
        Pawn pawnToMove = GameState.actualField.getPawn();

        if (pawnToMove.getFill() == BLACK && (destinationFieldY == oldY + 1 &&
                (destinationFieldX == oldX + 1 || destinationFieldX == oldX - 1))) {
            System.out.println("pionek czarny przeniesiony");
            destinationField.setPawn(pawnToMove);
            GameState.actualField.setPawn(null);
            GameState.actualField = null;
        } else if (pawnToMove.getFill() == WHITE && (destinationFieldY == oldY - 1 &&
                (destinationFieldX == oldX + 1 || destinationFieldX == oldX - 1))) {
            System.out.println("pionek biały przeniesiony");
            destinationField.setPawn(pawnToMove);
            GameState.actualField.setPawn(null);
            GameState.actualField = null;
        } else {
            System.out.println("ruch niedozwolony!");
        }
    }

    private void selectPawn(Field fieldToSelect) {
        GameState.actualField = fieldToSelect;
    }
}
