package sample.app.impl;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import sample.app.Action;
import sample.app.Figure;

public class Square implements Figure {

    private Node square;

    private Action action;

    private AnimationTimer timer;

    public Square(double sceneWidth, double sceneHeight, int speed) {
        square = new Rectangle(25, 25);
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
        return square;
    }
}
