package sample.app.figure.impl;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import sample.app.action.impl.CircleAction;
import sample.app.figure.Figure;

public class Circle implements Figure {

    private Node circle;

    private CircleAction action;

    private AnimationTimer timer;

    public Circle(double sceneWidth, double sceneHeight) {
        circle = new javafx.scene.shape.Circle(25);
        action = new CircleAction(sceneWidth, sceneHeight, (javafx.scene.shape.Circle) this.getFigure());
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
        return circle;
    }
}
