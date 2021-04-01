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

    private static final int SPEED = 5;

    public Scene(Pane actionArea) {
        this.actionArea = actionArea;
        width = actionArea.getWidth();
        height = actionArea.getHeight();
        figures = new ArrayList<>();
    }

    public void addFigure(String figureID) throws Exception {
        if (!figures.isEmpty()) {
            this.startAll();
        }
        Figure figure;
        switch (figureID) {
            case "circle":
                figure = new Circle(width, height, SPEED);
                break;
            case "star":
                figure = new Star(width, height, SPEED);
                break;
            case "square":
                figure = new Square(width, height, SPEED);
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
