package sample.app;

import javafx.scene.layout.Pane;
import sample.app.figure.Figure;
import sample.app.figure.impl.Circle;
import sample.app.figure.impl.Square;
import sample.app.figure.impl.Star;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    private Pane actionArea;

    private List<Figure> figures;

    private double width;

    private double height;

    public Scene(Pane actionArea) {
        this.actionArea = actionArea;
        width = actionArea.getPrefWidth();
        height = actionArea.getPrefHeight();
        figures = new ArrayList<>();
    }

    public void addFigure(String figureID) throws Exception {
        if (!figures.isEmpty()) {
            this.startAll();
        }
        Figure figure;
        switch (figureID) {
            case "circle":
                figure = new Circle(width, height);
                break;
            case "star":
                figure = new Star(width, height);
                break;
            case "square":
                figure = new Square(width, height);
                break;
            default:
                throw new Exception("Некорректная фигура");
        }
        figures.add(figure);
        actionArea.getChildren().add(figure.getFigure());
        figure.start();
    }

    public void stopScene() {
        this.stopAll();
    }

    private void stopAll() {
        for (Figure figure : figures) {
            figure.stop();
        }
    }

    private void startAll() {
        for (Figure figure : figures) {
            figure.start();
        }
    }
}
