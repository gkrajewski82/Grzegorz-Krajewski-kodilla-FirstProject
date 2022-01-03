package com.kodilla.checkers;

import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;

public class PawnLogic {

    public Field[][] logicImplementation(Field fieldTable[][]) {

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                fieldTable[x][y].setOnAction(event -> {
                    Field clickedField = (Field) event.getSource();
                    Pawn pawnOnField = clickedField.getPawn();

                    boolean isFieldSelected = GameState.actualField != null;
                    if (isFieldSelected && pawnOnField == null && clickedField.getX() == GameState.actualField.getX() + 2) {
                        System.out.println("Biję pionka w prawo!");
                        beatPlusTwoX(clickedField, fieldTable);
                        unmarkPawn(clickedField);
                    } else if (isFieldSelected && pawnOnField == null && clickedField.getX() == GameState.actualField.getX() - 2) {
                        System.out.println("Biję pionka w lewo!");
                        beatMinusTwoX(clickedField, fieldTable);
                        unmarkPawn(clickedField);
                    } else if (isFieldSelected && pawnOnField == null) {
                        System.out.println("Przenoszę");
                        movePawn(clickedField);
                        unmarkPawn(clickedField);
                    } else {
                        if (clickedField.getPawn() == null) {
                            System.out.println("Wybierz pole z pionkiem!");
                        }
                        markPawn(clickedField);
                        selectPawn(clickedField);
                        System.out.println("Pole zostało zaznaczone!");
                    }
                });
            }
        }
        return fieldTable;
    }

    private void movePawn(Field destinationField) {
        int oldX = GameState.actualField.getX();
        int oldY = GameState.actualField.getY();
        int destinationFieldX = destinationField.getX();
        int destinationFieldY = destinationField.getY();
        Pawn pawnToMove = GameState.actualField.getPawn();

        if (pawnToMove.getFill() == BLACK && (destinationFieldY == oldY + 1 &&
                (destinationFieldX == oldX + 1 || destinationFieldX == oldX - 1))) {
            destinationField.setPawn(pawnToMove);
            GameState.actualField.setPawn(null);
            GameState.actualField = null;
        } else if (pawnToMove.getFill() == WHITE && (destinationFieldY == oldY - 1 &&
                (destinationFieldX == oldX + 1 || destinationFieldX == oldX - 1))) {
            destinationField.setPawn(pawnToMove);
            GameState.actualField.setPawn(null);
            GameState.actualField = null;
        } else {
            System.out.println("ruch niedozwolony!");
        }
    }

    private void beatPlusTwoX(Field destinationField, Field fieldTable[][]) {
        int oldX = GameState.actualField.getX();
        int oldY = GameState.actualField.getY();
        int destinationFieldY = destinationField.getY();
        Pawn pawnToMove = GameState.actualField.getPawn();

        if (destinationFieldY == oldY + 2) {
            if (pawnToMove.getFill() == BLACK && fieldTable[oldX + 1][oldY + 1].getPawn().getFill() == WHITE) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX + 1][oldY + 1].setPawn(null);
                GameState.actualField.setPawn(null);
                GameState.actualField = null;
            } else if (pawnToMove.getFill() == WHITE && fieldTable[oldX + 1][oldY + 1].getPawn().getFill() == BLACK) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX + 1][oldY + 1].setPawn(null);
                GameState.actualField.setPawn(null);
                GameState.actualField = null;
            }
        } else if ( destinationFieldY == oldY - 2) {
            if (pawnToMove.getFill() == BLACK && fieldTable[oldX + 1][oldY - 1].getPawn().getFill() == WHITE) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX + 1][oldY - 1].setPawn(null);
                GameState.actualField.setPawn(null);
                GameState.actualField = null;
            } else if (pawnToMove.getFill() == WHITE && fieldTable[oldX + 1][oldY - 1].getPawn().getFill() == BLACK) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX + 1][oldY - 1].setPawn(null);
                GameState.actualField.setPawn(null);
                GameState.actualField = null;
            }
        } else {
            System.out.println("próba bicia - ruch niedozwolony!");
        }
    }

    private void beatMinusTwoX(Field destinationField, Field fieldTable[][]) {
        int oldX = GameState.actualField.getX();
        int oldY = GameState.actualField.getY();
        int destinationFieldY = destinationField.getY();
        Pawn pawnToMove = GameState.actualField.getPawn();

        if (destinationFieldY == oldY + 2) {
            if (pawnToMove.getFill() == BLACK && fieldTable[oldX - 1][oldY + 1].getPawn().getFill() == WHITE) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX - 1][oldY + 1].setPawn(null);
                GameState.actualField.setPawn(null);
                GameState.actualField = null;
            } else if (pawnToMove.getFill() == WHITE && fieldTable[oldX - 1][oldY + 1].getPawn().getFill() == BLACK) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX - 1][oldY + 1].setPawn(null);
                GameState.actualField.setPawn(null);
                GameState.actualField = null;
            }
        } else if (destinationFieldY == oldY - 2) {
            if (pawnToMove.getFill() == BLACK && fieldTable[oldX - 1][oldY - 1].getPawn().getFill() == WHITE) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX - 1][oldY - 1].setPawn(null);
                GameState.actualField.setPawn(null);
                GameState.actualField = null;
            } else if (pawnToMove.getFill() == WHITE && fieldTable[oldX - 1][oldY - 1].getPawn().getFill() == BLACK ) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX - 1][oldY - 1].setPawn(null);
                GameState.actualField.setPawn(null);
                GameState.actualField = null;
            }
        } else {
            System.out.println("próba bicia - ruch niedozwolony!");
        }
    }

    private void selectPawn(Field fieldToSelect) {
        GameState.actualField = fieldToSelect;
    }

    private void markPawn(Field clickedField) {
        clickedField.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                clickedField.setEffect(new DropShadow(33, Color.YELLOW));
            }
        });
    }

    private void unmarkPawn(Field clickedField) {
        clickedField.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                clickedField.setEffect(null);
            }
        });
    }
}
