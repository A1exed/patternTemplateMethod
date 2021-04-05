package sample.app.figure.impl;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.shape.Polygon;
import sample.app.action.impl.StarAction;
import sample.app.figure.Figure;

import java.util.ArrayList;
import java.util.List;

public class Star implements Figure {

    private Node star;

    private StarAction action;

    private AnimationTimer timer;

    public Star(double sceneWidth, double sceneHeight) {
        Polygon star = new Polygon();
        star.getPoints().addAll(this.getPoints());
        this.star = star;
        action = new StarAction(sceneWidth, sceneHeight, (Polygon) this.getFigure());
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                action.action();
            }
        };
    }

    @Override
    public void start() {
        timer.start();
    }

    @Override
    public void stop() {
        timer.stop();
    }

    @Override
    public Node getFigure() {
        return star;
    }

    private List<Double> getPoints() {
        List<Double> points = new ArrayList<>();
        double a = 0, b = Math.PI / 5, k = 0.3;
        double x1 = 50 * Math.cos(a), x2, y1 = 50 * Math.sin(a), y2;

        for (int i = 0; i < 5; i++) {
            a += b;
            points.add(x1);
            points.add(y1);
            y2 = k * 50 * Math.sin(a);
            x2 = k * 50 * Math.cos(a);
            points.add(x2);
            points.add(y2);
            a += b;
            x1 = 50 * Math.cos(a);
            y1 = 50 * Math.sin(a);
        }
        return points;
    }
}
