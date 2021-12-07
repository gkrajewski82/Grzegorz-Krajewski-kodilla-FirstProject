package com.kodilla.checkers;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Checkers extends Application {

    private Image imageback = new Image("file:src/main/resources/table.jpg");
    private Figure figure = new Figure();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true,
                true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(92, 92, 92, 92));
        grid.setBackground(background);

        grid.setGridLinesVisible(false);
        final int numCols = 8;
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

        grid.add(new ImageView(figure.getBlackFigure()), 1, 0);
        grid.add(new ImageView(figure.getBlackFigure()), 3, 0);
        grid.add(new ImageView(figure.getBlackFigure()), 5, 0);
        grid.add(new ImageView(figure.getBlackFigure()), 7, 0);
        grid.add(new ImageView(figure.getBlackFigure()), 0, 1);
        grid.add(new ImageView(figure.getBlackFigure()), 2, 1);
        grid.add(new ImageView(figure.getBlackFigure()), 4, 1);
        grid.add(new ImageView(figure.getBlackFigure()), 6, 1);
        grid.add(new ImageView(figure.getBlackFigure()), 1, 2);
        grid.add(new ImageView(figure.getBlackFigure()), 3, 2);
        grid.add(new ImageView(figure.getBlackFigure()), 5, 2);
        grid.add(new ImageView(figure.getBlackFigure()), 7, 2);

        grid.add(new ImageView(figure.getWhiteFigure()), 0, 7);
        grid.add(new ImageView(figure.getWhiteFigure()), 2, 7);
        grid.add(new ImageView(figure.getWhiteFigure()), 4, 7);
        grid.add(new ImageView(figure.getWhiteFigure()), 6, 7);
        grid.add(new ImageView(figure.getWhiteFigure()), 1, 6);
        grid.add(new ImageView(figure.getWhiteFigure()), 3, 6);
        grid.add(new ImageView(figure.getWhiteFigure()), 5, 6);
        grid.add(new ImageView(figure.getWhiteFigure()), 7, 6);
        grid.add(new ImageView(figure.getWhiteFigure()), 0, 5);
        grid.add(new ImageView(figure.getWhiteFigure()), 2, 5);
        grid.add(new ImageView(figure.getWhiteFigure()), 4, 5);
        grid.add(new ImageView(figure.getWhiteFigure()), 6, 5);

        Scene scene = new Scene(grid, 800, 800, Color.BLACK);

        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}