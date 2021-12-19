package com.kodilla.checkers;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class FieldExecutor {

    Field fieldTable[][] = new Field[8][8];

    public Field[][] generateFieldTable() {
        for (int x = 0; x < fieldTable.length; x++) {
            for (int y = 0; y < fieldTable[x].length; y++) {
                Field field = new Field(null, x, y);
                field.setPrefSize(73, 73);
                field.setStyle("-fx-background-color: transparent");
                field.setPadding(new Insets(2, 2, 2, 2));
                fieldTable[x][y] = field;

                field.addEventHandler(MouseEvent.MOUSE_ENTERED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent e) {
                                field.setEffect(new DropShadow(33, Color.YELLOW));
                            }
                        });

                field.addEventHandler(MouseEvent.MOUSE_EXITED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent e) {
                                field.setEffect(null);
                            }
                        });
            }
        }
        return fieldTable;
    }

}
