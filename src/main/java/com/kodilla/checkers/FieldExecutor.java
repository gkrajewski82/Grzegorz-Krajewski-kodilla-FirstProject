package com.kodilla.checkers;

public class FieldExecutor {

    Field[][] fieldTable = new Field[8][8];

    public Field[][] generateFieldTable() {
        for (int x = 0; x < fieldTable.length; x++) {
            for (int y = 0; y < fieldTable[x].length; y++) {
                Field field = new Field(null, x, y);
                field.setPrefSize(77, 77);
                field.setStyle("-fx-background-color: transparent");
                fieldTable[x][y] = field;
            }
        }
        return fieldTable;
    }
}
