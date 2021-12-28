package com.kodilla.checkers;

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

        /*for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                fieldTable[x][y].setOnAction(event -> {
                    Field actualField = (Field) event.getSource();
                    Pawn actualPawn = actualField.getPawn();
                    if (actualPawn == null) { //PUSTE POLE
                        System.out.println("na polu brak pionka");
                    } else if (actualPawn.getFill() == BLACK) { //CZARNY PIONEK
                        System.out.println("na polu jest pionek");
                        Pawn pawn = actualPawn;
                        System.out.println("pionek został pobrany");
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                fieldTable[i][j].setOnAction(event2 -> {
                                    Field actualField2 = (Field) event2.getSource();
                                    int oldX = actualField.getX();
                                    int oldY = actualField.getY();
                                    int newX = actualField2.getX();
                                    int newY = actualField2.getY();
                                    if (actualField2.getPawn() == null && newY == oldY + 1 && (newX == oldX - 1 ||
                                            newX == oldX + 1)) {
                                        System.out.println("stawiam pionek");
                                        actualField.setPawn(null);
                                        //actualField.setGraphic(actualPawn);
                                        actualField2.setPawn(pawn);
                                        //actualField2.setGraphic(actualField2.getPawn());
                                    } else {
                                        System.out.println("niewłaściwy ruch");
                                    }
                                });
                            }
                        }
                    } else { //BIALY PIONEK
                        System.out.println("na polu jest pionek");
                        Pawn pawn = actualPawn;
                        System.out.println("pionek został pobrany");
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                fieldTable[i][j].setOnAction(event2 -> {
                                    Field actualField2 = (Field) event2.getSource();
                                    int oldX = actualField.getX();
                                    int oldY = actualField.getY();
                                    int newX = actualField2.getX();
                                    int newY = actualField2.getY();
                                    if (actualField2.getPawn() == null && newY == oldY - 1 && (newX == oldX - 1 ||
                                            newX == oldX + 1)) {
                                        System.out.println("stawiam pionek");
                                        actualField.setPawn(null);
                                        //actualField.setGraphic(actualPawn);
                                        actualField2.setPawn(pawn);
                                        //actualField2.setGraphic(actualField2.getPawn());
                                    } else {
                                        System.out.println("niewłaściwy ruch");
                                    }
                                });
                            }
                        }
                    }
                });
            }
        }*/

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                fieldTable[x][y].setOnAction(event -> {
                    Field clickedField = (Field) event.getSource();

                    boolean isPawnSelected = GameState.actualPawn != null;
                    if (isPawnSelected) {
                        movePawn(clickedField, fieldTable);
                    } else {
                        if (clickedField.getPawn() == null) {
                            System.out.println("Wybierz pole z pionkiem!");
                        }
                        selectPawn(clickedField);
                    }
                });
            }
        }
        return fieldTable;
    }

    private void movePawn(Field destinationField, Field fieldTable[][]) {
        int destinationFieldX = destinationField.getX();
        int destinationFieldY = destinationField.getY();

        //Czy ja moge ruszyc tym pionkiem

        Pawn pawnToMove = GameState.actualPawn.getPawn();
        destinationField.setPawn(pawnToMove);
        GameState.actualPawn.setPawn(null);
        GameState.actualPawn = null;
    }

    private void selectPawn(Field fieldToSelect) {
        GameState.actualPawn = fieldToSelect;
    }
}
