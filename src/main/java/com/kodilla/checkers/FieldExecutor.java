package com.kodilla.checkers;

import javafx.geometry.Insets;

public class FieldExecutor {

    public Field[][] generateFieldTable() {

        Field fieldTable[][] = new Field[8][8];

        for (int x = 0; x < 8; x++) {
            if (x % 2 == 0) {
                for (int y = 0; y < 8; y = y + 2) {
                    FieldImage yellowImage = new FieldImage("file:src/main/resources/yellow_field.png");
                    Field yellowField = new Field(yellowImage, x, y);
                    yellowField.setGraphic(yellowImage);
                    yellowField.setPadding(new Insets(2, 2, 2, 2));
                    fieldTable[x][y] = yellowField;
                }
            } else {
                for (int y = 1; y < 8; y = y + 2) {
                    FieldImage yellowImage = new FieldImage("file:src/main/resources/yellow_field.png");
                    Field yellowField = new Field(yellowImage, x, y);
                    yellowField.setGraphic(yellowImage);
                    yellowField.setPadding(new Insets(2, 2, 2, 2));
                    fieldTable[x][y] = yellowField;
                }
            }
        }

        for (int x = 0; x < 8; x++) {
            if (x % 2 != 0) {
                for (int y = 0; y < 8; y = y + 2) {
                    FieldImage yellowImage = new FieldImage("file:src/main/resources/brown_field.png");
                    Field yellowField = new Field(yellowImage, x, y);
                    yellowField.setGraphic(yellowImage);
                    yellowField.setPadding(new Insets(2, 2, 2, 2));
                    fieldTable[x][y] = yellowField;
                }
            } else {
                for (int y = 1; y < 8; y = y + 2) {
                    FieldImage yellowImage = new FieldImage("file:src/main/resources/brown_field.png");
                    Field yellowField = new Field(yellowImage, x, y);
                    yellowField.setGraphic(yellowImage);
                    yellowField.setPadding(new Insets(2, 2, 2, 2));
                    fieldTable[x][y] = yellowField;
                }
            }
        }

        for (int i = 0; i < fieldTable.length; i++) {
            for (int j = 0; j < fieldTable[i].length; j++) {
                fieldTable[i][j].setOnAction((event) -> {
                    Field clieckedField = ClickedField.getField();
                    if (clieckedField == null) {
                        System.out.println("Przycisk nie jest zaznaczony");
                        ClickedField.setField((Field) event.getSource());
                    } else {
                        System.out.println("Ostatnio zaznaczony przycisk to " + clieckedField.getX() + " : " + clieckedField.getY());
                        System.out.println("Wykonuje jakas akcje albo i nie");
                        ClickedField.setField(null);
                    }
                });
            }
        }
        return fieldTable;
    }
}