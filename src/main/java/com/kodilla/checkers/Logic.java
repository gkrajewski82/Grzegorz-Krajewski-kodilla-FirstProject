package com.kodilla.checkers;

public class Logic {

    public Field[][] logicImplementation(Field fieldTable[][]) {

        for (int x = 0; x < fieldTable.length; x++) {
            for (int y = 0; y < fieldTable[x].length; y++) {
                fieldTable[x][y].setOnAction(event -> {
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

        /*for (int x = 0; x < fieldTable.length; x++) {
            for (int y = 0; y < fieldTable[x].length; y++) {
                fieldTable[x][y].setOnAction(move -> {
                    Field clieckedField = ClickedField.getField();
                    if (clieckedField.getGraphic() == null) {
                        System.out.println("tutaj jest pionek");
                    } else {
                        System.out.println("tutaj nie ma pionka");
                    }

                });
            }
        }*/

        return fieldTable;
    }
}
