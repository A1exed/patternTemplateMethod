package sample.app.impl;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import sample.app.Action;
import sample.app.Figure;

public class Circle implements Figure {

    private Node circle;

    private Action action;

    private AnimationTimer timer;

    public Circle(double sceneWidth, double sceneHeight, int speed) {
        circle = new javafx.scene.shape.Circle(25);
        action = new Action(sceneWidth, sceneHeight, this.getFigure(), speed);
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
