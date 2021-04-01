package sample.app;

import javafx.scene.layout.Pane;
import sample.app.impl.Circle;
import sample.app.impl.Square;
import sample.app.impl.Star;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    private Pane actionArea;

    private List<Figure> figures;

    private double width;

    private double height;

    private int speed;

    public Scene(Pane actionArea) {
        this.actionArea = actionArea;
        width = actionArea.getPrefWidth();
        height = actionArea.getPrefHeight();
        figures = new ArrayList<>();
        speed = 5;
    }

    public void addFigure(String figureID) throws Exception {
        if (!figures.isEmpty()) {
            this.startAll();
        }
        Figure figure;
        switch (figureID) {
            case "circle":
                figure = new Circle(width, height, speed);
                break;
            case "star":
                figure = new Star(width, height, speed);
                break;
            case "square":
                figure = new Square(width, height, speed);
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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
