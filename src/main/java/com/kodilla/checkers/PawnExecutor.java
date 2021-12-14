package com.kodilla.checkers;

import javafx.geometry.Insets;

import java.util.ArrayList;
import java.util.List;

public class PawnExecutor {

    List<Pawn> blackPawnList = new ArrayList<>();
    List<Pawn> whitePawnList = new ArrayList<>();

    public List<Pawn> getBlackPawnList() {
        for (int y = 0; y < 3; y++) {
            if (y != 1) {
                for (int x = 1; x < 8; x = x + 2) {
                    PawnImage image = new PawnImage("file:src/main/resources/black_pawn.png");
                    Pawn blackPawn = new Pawn(image, x, y);
                    blackPawn.setGraphic(image);
                    blackPawn.setPadding(new Insets(2, 2, 2, 2));
                    blackPawnList.add(blackPawn);
                }
            } else {
                for (int x = 0; x < 7; x = x + 2) {
                    PawnImage image = new PawnImage("file:src/main/resources/black_pawn.png");
                    Pawn blackPawn = new Pawn(image, x, y);
                    blackPawn.setGraphic(image);
                    blackPawn.setPadding(new Insets(2, 2, 2, 2));
                    blackPawnList.add(blackPawn);
                }
            }
        } return blackPawnList;
    }

    public List<Pawn> getWhitePawnList() {
        for (int y = 7; y > 4; y--) {
            if (y != 6) {
                for (int x = 0; x < 8; x = x + 2) {
                    PawnImage image = new PawnImage("file:src/main/resources/white_pawn.png");
                    Pawn whitePawn = new Pawn(image, x, y);
                    whitePawn.setGraphic(image);
                    whitePawn.setPadding(new Insets(2, 2, 2, 2));
                    whitePawnList.add(whitePawn);
                }
            } else {
                for (int x = 1; x<8; x = x + 2) {
                    PawnImage image = new PawnImage("file:src/main/resources/white_pawn.png");
                    Pawn whitePawn = new Pawn(image, x, y);
                    whitePawn.setGraphic(image);
                    whitePawn.setPadding(new Insets(2, 2, 2, 2));
                    whitePawnList.add(whitePawn);
                }
            }
        } return whitePawnList;
    }
}