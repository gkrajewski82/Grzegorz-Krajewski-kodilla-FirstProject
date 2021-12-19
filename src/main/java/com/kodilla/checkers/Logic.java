package com.kodilla.checkers;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;

public class Logic {

    public Field[][] logicImplementation(Field fieldTable[][]) {

        /*for (int x = 0; x < fieldTable.length; x++) {
            for (int y = 0; y < fieldTable[x].length; y++) {
                fieldTable[x][y].setOnAction(event -> {
                    Field clickedField = ClickedField.getField();
                    if (clickedField == null) {
                        System.out.println("Przycisk nie jest zaznaczony");
                        ClickedField.setField((Field) event.getSource());
                    } else {
                        System.out.println("Ostatnio zaznaczony przycisk to " + clickedField.getX() + " : " + clickedField.getY());
                        System.out.println("Wykonuje jakas akcje albo i nie");
                        ClickedField.setField(null);
                    }
                });
            }
        }*/

        for (int x=0; x<8; x++) {
            for (int y=0; y<8; y++) {
                fieldTable[x][y].setOnAction(event -> {
                    Field actualField = (Field) event.getSource();
                    if (actualField.getPawn().getFill() == BLACK) {
                        System.out.println("na polu jest pionek");
                        Pawn pawn = actualField.getPawn();
                        System.out.println("pionek został pobrany");
                        for (int i=0; i<8; i++) {
                            for (int j=0; j<8; j++) {
                                fieldTable[i][j].setOnAction(event2 -> {
                                    Field actualField2 = (Field) event2.getSource();
                                    int oldX = actualField.getX();
                                    int oldY = actualField.getY();
                                    int newX = actualField2.getX();
                                    int newY = actualField2.getY();
                                    if (actualField2.getPawn() == null && newY == oldY + 1 && (newX == oldX - 1 || newX == oldX + 1)) {
                                        System.out.println("wstawiam pionek");
                                        actualField.setPawn(null); //czy to pole jest niepotrzebne?
                                        actualField.setGraphic(actualField.getPawn()); //czy to pole jest niepotrzebne?
                                        actualField2.setPawn(pawn);
                                        actualField2.setGraphic(actualField2.getPawn());
                                    } else {
                                        System.out.println("niewłaściwy ruch");
                                    }
                                });
                            }
                        }
                    } else {
                        System.out.println("na polu brak pionka");
                    }
                });
            }
        }

        return fieldTable;
    }
}
