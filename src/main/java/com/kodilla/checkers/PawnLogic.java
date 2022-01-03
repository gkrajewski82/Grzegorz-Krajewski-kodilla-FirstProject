package com.kodilla.checkers;

import javafx.event.EventHandler;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;

public class PawnLogic {

    private PawnLogic pawnLogic;

    public Field[][] logicImplementation(Field fieldTable[][]) {

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                fieldTable[x][y].setOnAction(event -> {
                    Field clickedField = (Field) event.getSource();
                    Pawn pawnOnField = clickedField.getPawn();

                    boolean isFieldSelected = GameState.actualField != null;
                    if (isFieldSelected) {
                        if (pawnOnField == null && clickedField.getX() == GameState.actualField.getX() + 2) {
                            System.out.println("Biję!");
                            beatPlusTwoX(clickedField, fieldTable);
                            //unmarkPawn(clickedField.getPawn());
                        } else if (pawnOnField == null && clickedField.getX() == GameState.actualField.getX() - 2) {
                            System.out.println("Biję!");
                            beatMinusTwoX(clickedField, fieldTable);
                            //unmarkPawn(clickedField.getPawn());
                        } else if (pawnOnField == null) {
                            System.out.println("Przenoszę!");
                            movePawn(clickedField);
                            //unmarkPawn(clickedField.getPawn());
                        } else if (pawnOnField != null) {
                            System.out.println("ruch niedozwolony - na polu jest pionek!");
                        } else if (clickedField.equals(GameState.actualField)) {
                            System.out.println("dupa");
                        }
                    } else if (clickedField.getPawn() == null) {
                        System.out.println("Wybierz pole z pionkiem!");
                    }
                    else {
                        markPawn(clickedField.getPawn());
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
        Paint pawnColour = pawnToMove.getFill();

        if (pawnColour == BLACK && (destinationFieldY == oldY + 1 &&
                (destinationFieldX == oldX + 1 || destinationFieldX == oldX - 1))) {
            destinationField.setPawn(pawnToMove);
            GameState.actualField.setPawn(null);
            GameState.actualField = null;
        } else if (pawnColour == WHITE && (destinationFieldY == oldY - 1 &&
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
        Paint pawnColour = pawnToMove.getFill();

        if (destinationFieldY == oldY + 2) {
            if (pawnColour == BLACK && fieldTable[oldX + 1][oldY + 1].getPawn().getFill() == WHITE) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX + 1][oldY + 1].setPawn(null);
                GameState.actualField.setPawn(null);
                GameState.actualField = null;
            } else if (pawnColour == WHITE && fieldTable[oldX + 1][oldY + 1].getPawn().getFill() == BLACK) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX + 1][oldY + 1].setPawn(null);
                GameState.actualField.setPawn(null);
                GameState.actualField = null;
            }
        } else if ( destinationFieldY == oldY - 2) {
            if (pawnColour == BLACK && fieldTable[oldX + 1][oldY - 1].getPawn().getFill() == WHITE) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX + 1][oldY - 1].setPawn(null);
                GameState.actualField.setPawn(null);
                GameState.actualField = null;
            } else if (pawnColour == WHITE && fieldTable[oldX + 1][oldY - 1].getPawn().getFill() == BLACK) {
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
        Paint pawnColour = pawnToMove.getFill();

        if (destinationFieldY == oldY + 2) {
            if (pawnColour == BLACK && fieldTable[oldX - 1][oldY + 1].getPawn().getFill() == WHITE) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX - 1][oldY + 1].setPawn(null);
                GameState.actualField.setPawn(null);
                GameState.actualField = null;
            } else if (pawnColour == WHITE && fieldTable[oldX - 1][oldY + 1].getPawn().getFill() == BLACK) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX - 1][oldY + 1].setPawn(null);
                GameState.actualField.setPawn(null);
                GameState.actualField = null;
            }
        } else if (destinationFieldY == oldY - 2) {
            if (pawnColour == BLACK && fieldTable[oldX - 1][oldY - 1].getPawn().getFill() == WHITE) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX - 1][oldY - 1].setPawn(null);
                GameState.actualField.setPawn(null);
                GameState.actualField = null;
            } else if (pawnColour == WHITE && fieldTable[oldX - 1][oldY - 1].getPawn().getFill() == BLACK ) {
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

    public static void markPawn(Pawn markedPawn) {
        markedPawn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                markedPawn.setEffect(new BoxBlur(10, 10, 50));
            }
        });
    }

    public static void unmarkPawn(Pawn unmarkedPawn) {
        unmarkedPawn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                unmarkedPawn.setEffect(null);
            }
        });
    }
}
