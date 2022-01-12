package com.kodilla.checkers;

import javafx.scene.effect.BoxBlur;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;

public class PawnLogic {

    public void logicImplementation(Field[][] fieldTable) {

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                fieldTable[x][y].setOnAction(event -> {
                    Field clickedField = (Field) event.getSource();
                    Pawn pawnOnField = clickedField.getPawn();
                    boolean isFieldSelected = GameState.actualField != null;
                    boolean isPawnOnField = pawnOnField != null;

                    if (isFieldSelected) {
                        if (!isPawnOnField && clickedField.getX() == GameState.actualField.getX() + 2) {
                            System.out.println("Biję!");
                            beatDiagonalToTheRight(clickedField, fieldTable);
                            unmarkPawn(clickedField.getPawn());
                        } else if (!isPawnOnField && clickedField.getX() == GameState.actualField.getX() - 2) {
                            System.out.println("Biję!");
                            beatDiagonalToTheLeft(clickedField, fieldTable);
                            unmarkPawn(clickedField.getPawn());
                        } else if (!isPawnOnField) {
                            System.out.println("Przenoszę!");
                            movePawn(clickedField);
                            unmarkPawn(clickedField.getPawn());
                        } else if (clickedField.getX() == GameState.actualField.getX() &&
                                clickedField.getY() == GameState.actualField.getY()) {
                            unmarkPawn(clickedField.getPawn());
                            GameState.actualField = null;
                        } else {
                            System.out.println("ruch niedozwolony - na polu jest pionek!");
                        }
                    } else if (clickedField.getPawn() == null) {
                        System.out.println("Wybierz pole z pionkiem!");
                    } else {
                        markPawn(clickedField.getPawn());
                        selectPawn(clickedField);
                        System.out.println("Pole zostało zaznaczone!");
                    }
                });
            }
        }
    }

    private void movePawn(Field destinationField) {
        int oldX = GameState.actualField.getX();
        int oldY = GameState.actualField.getY();
        int destinationFieldX = destinationField.getX();
        int destinationFieldY = destinationField.getY();
        Pawn pawnToMove = GameState.actualField.getPawn();
        boolean blackPawn = pawnToMove.getFill() == BLACK;


        if (blackPawn && (destinationFieldY == oldY + 1 && (destinationFieldX == oldX + 1 ||
                destinationFieldX == oldX - 1))) {
            destinationField.setPawn(pawnToMove);
            setPawnNull();
        } else if (!blackPawn && (destinationFieldY == oldY - 1 && (destinationFieldX == oldX + 1 ||
                destinationFieldX == oldX - 1))) {
            destinationField.setPawn(pawnToMove);
            setPawnNull();
        } else {
            System.out.println("ruch niedozwolony!");
        }
    }

    private void beatDiagonalToTheRight(Field destinationField, Field[][] fieldTable) {
        int oldX = GameState.actualField.getX();
        int oldY = GameState.actualField.getY();
        int destinationFieldY = destinationField.getY();
        Pawn pawnToMove = GameState.actualField.getPawn();
        boolean blackPawn = pawnToMove.getFill() == BLACK;

        if (destinationFieldY == oldY + 2) {
            if (blackPawn && fieldTable[oldX + 1][oldY + 1].getPawn().getFill() == WHITE) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX + 1][oldY + 1].setPawn(null);
                setPawnNull();
            } else if (!blackPawn && fieldTable[oldX + 1][oldY + 1].getPawn().getFill() == BLACK) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX + 1][oldY + 1].setPawn(null);
                setPawnNull();
            }
        } else if (destinationFieldY == oldY - 2) {
            if (blackPawn && fieldTable[oldX + 1][oldY - 1].getPawn().getFill() == WHITE) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX + 1][oldY - 1].setPawn(null);
                setPawnNull();
            } else if (!blackPawn && fieldTable[oldX + 1][oldY - 1].getPawn().getFill() == BLACK) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX + 1][oldY - 1].setPawn(null);
                setPawnNull();
            }
        } else {
            System.out.println("próba bicia - ruch niedozwolony!");
        }
    }

    private void beatDiagonalToTheLeft(Field destinationField, Field[][] fieldTable) {
        int oldX = GameState.actualField.getX();
        int oldY = GameState.actualField.getY();
        int destinationFieldY = destinationField.getY();
        Pawn pawnToMove = GameState.actualField.getPawn();
        boolean blackPawn = pawnToMove.getFill() == BLACK;

        if (destinationFieldY == oldY + 2) {
            if (blackPawn && fieldTable[oldX - 1][oldY + 1].getPawn().getFill() == WHITE) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX - 1][oldY + 1].setPawn(null);
                setPawnNull();
            } else if (!blackPawn && fieldTable[oldX - 1][oldY + 1].getPawn().getFill() == BLACK) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX - 1][oldY + 1].setPawn(null);
                setPawnNull();
            }
        } else if (destinationFieldY == oldY - 2) {
            if (blackPawn && fieldTable[oldX - 1][oldY - 1].getPawn().getFill() == WHITE) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX - 1][oldY - 1].setPawn(null);
                setPawnNull();
            } else if (!blackPawn && fieldTable[oldX - 1][oldY - 1].getPawn().getFill() == BLACK) {
                destinationField.setPawn(pawnToMove);
                fieldTable[oldX - 1][oldY - 1].setPawn(null);
                setPawnNull();
            }
        } else {
            System.out.println("próba bicia - ruch niedozwolony!");
        }
    }

    private void setPawnNull() {
        GameState.actualField.setPawn(null);
        GameState.actualField = null;
    }

    private void selectPawn(Field fieldToSelect) {
        GameState.actualField = fieldToSelect;
    }

    public static void markPawn(Pawn pawnToMark) {
        pawnToMark.setEffect(new BoxBlur(10, 10, 50));
    }

    public static void unmarkPawn(Pawn pawnToUnmark) {
        if (pawnToUnmark != null) {
            pawnToUnmark.setEffect(null);
        }
    }
}