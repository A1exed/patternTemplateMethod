package sample.app.action.impl;

import javafx.scene.shape.Circle;
import sample.app.action.Action;

public class CircleAction extends Action<Circle> {

    public CircleAction(double widthScene, double heightScene, Circle node) {
        super(widthScene, heightScene, node);
        figure = node;
        figure.setCenterX(widthScene);
        figure.setCenterY(heightScene);
    }

    public void action() {
        double x = figure.getCenterX();
        double y = figure.getCenterY();
        double radius = figure.getRadius();
        if (!inScene) {
            figure.setCenterX(x + dX);
            figure.setCenterY(y + dY);
            if (x + radius + dX < widthScene && y + radius + dY < heightScene)
                inScene = true;
        } else {
            if (x + dX > widthScene - radius || x + dX < radius) {
                dX = -dX;
            }
            if (y + dY > heightScene - radius || y + dY < radius) {
                dY = -dY;
            }
            figure.setCenterX(x + dX);
            figure.setCenterY(y + dY);
        }
    }
}
