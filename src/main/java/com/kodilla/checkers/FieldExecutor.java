package com.kodilla.checkers;

import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class FieldExecutor {

    Field fieldTable[][] = new Field[8][8];

    public Field[][] generateFieldTable() {
        for (int x = 0; x < fieldTable.length; x++) {
            for (int y = 0; y < fieldTable[x].length; y++) {
                Field field = new Field(null, x, y);
                field.setPrefSize(77, 77);
                field.setStyle("-fx-background-color: transparent");
                //field.setPadding(new Insets(2, 2, 2, 2));
                fieldTable[x][y] = field;
            }
        }
        return fieldTable;
    }

}
