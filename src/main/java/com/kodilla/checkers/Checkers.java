package com.kodilla.checkers;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.BLACK;

public class Checkers extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private final Image imageback = new Image("file:src/main/resources/table.png");

    @Override
    public void start(Stage primaryStage) throws Exception {

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true,
                true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(92, 38, 92, 92));
        grid.setBackground(background);

        grid.setGridLinesVisible(true);
        final int numCols = 10;
        final int numRows = 8;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            colConst.setHalignment(HPos.CENTER);
            grid.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            rowConst.setValignment(VPos.CENTER);
            grid.getRowConstraints().add(rowConst);
        }

        FieldExecutor fieldExecutor = new FieldExecutor();
        Field[][] fieldTable = fieldExecutor.generateFieldTable();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Field field = fieldTable[x][y];
                grid.add(field, field.getX(), field.getY());
            }
        }

        Button startButton = new Button();
        startButton.setText("new\ngame");
        startButton.setStyle("-fx-font: 12 arial; -fx-base: #8d3a3a");
        grid.add(startButton, 9, 0);

        startButton.setOnAction(newGame -> {
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    fieldTable[x][y].setPawn(null);
                    fieldTable[x][y].setGraphic(fieldTable[x][y].getPawn());
                }
            }
            PawnExecutor pawnExecutor = new PawnExecutor();
            pawnExecutor.addBlackPawnToField(fieldTable);
            pawnExecutor.addWhitePawnToField(fieldTable);
        });

        PawnLogic logic = new PawnLogic();
        logic.logicImplementation(fieldTable);

        Scene scene = new Scene(grid, 900, 800, BLACK);

        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
