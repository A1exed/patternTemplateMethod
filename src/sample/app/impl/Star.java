package sample.app.impl;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import sample.app.Action;
import sample.app.Figure;

public class Star implements Figure {

    private Node star;

    private Action action;

    private AnimationTimer timer;

    public Star(double sceneWidth, double sceneHeight, int speed) {

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
        return star;
    }
}
