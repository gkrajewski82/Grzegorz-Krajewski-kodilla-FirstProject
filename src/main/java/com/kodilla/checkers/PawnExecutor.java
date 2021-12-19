package com.kodilla.checkers;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;

public class PawnExecutor {


   public void addBlackPawnToField(Field fieldTable[][]) {
        for (int y = 0; y < 3; y++) {
            if (y != 1) {
                for (int x = 1; x < 8; x = x + 2) {
                    Pawn blackPawn = new Pawn(30, BLACK);
                    fieldTable[x][y].setPawn(blackPawn);
                    fieldTable[x][y].setGraphic(fieldTable[x][y].getPawn());
                }
            } else {
                for (int x = 0; x < 7; x = x + 2) {
                    Pawn blackPawn = new Pawn(30, BLACK);
                    fieldTable[x][y].setPawn(blackPawn);
                    fieldTable[x][y].setGraphic(fieldTable[x][y].getPawn());
                }
            }
        }
    }

   public void addWhitePawnToField(Field fieldTable[][]) {
        for (int y = 7; y > 4; y--) {
            if (y != 6) {
                for (int x = 0; x < 8; x = x + 2) {
                    Pawn whitePawn = new Pawn(30, WHITE);
                    fieldTable[x][y].setPawn(whitePawn);
                    fieldTable[x][y].setGraphic(fieldTable[x][y].getPawn());
                }
            } else {
                for (int x = 1; x<8; x = x + 2) {
                    Pawn whitePawn = new Pawn(30, WHITE);
                    fieldTable[x][y].setPawn(whitePawn);
                    fieldTable[x][y].setGraphic(fieldTable[x][y].getPawn());
                }
            }
        }
    }
}