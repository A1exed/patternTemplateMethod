package sample.app.figure.impl;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import sample.app.action.impl.SquareAction;
import sample.app.figure.Figure;

public class Square implements Figure {

    private Node square;

    private SquareAction action;

    private AnimationTimer timer;

    public Square(double sceneWidth, double sceneHeight) {
        square = new Rectangle(50, 50);
        action = new SquareAction(sceneWidth, sceneHeight, (Rectangle) this.getFigure());
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
