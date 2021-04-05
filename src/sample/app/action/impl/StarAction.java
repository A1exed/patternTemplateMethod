package sample.app.action.impl;

import javafx.scene.shape.Polygon;
import sample.app.action.Action;

public class StarAction extends Action<Polygon> {

    public StarAction(double widthScene, double heightScene, Polygon node) {
        super(widthScene, heightScene, node);
        figure = node;
        figure.setTranslateX(widthScene);
        figure.setTranslateY(heightScene);
    }

    public void action() {
        double x = figure.getTranslateX();
        double y = figure.getTranslateY();
        double radius = 50;
        if (!inScene) {
            figure.setTranslateX(x + dX);
            figure.setTranslateY(y + dY);
            if (x + radius + dX < widthScene && y + radius + dY < heightScene)
                inScene = true;
        } else {
            if (x + dX > widthScene - radius || x + dX < radius) {
                dX = -dX;
            }
            if (y + dY > heightScene - radius || y + dY < radius) {
                dY = -dY;
            }
            figure.setTranslateX(x + dX);
            figure.setTranslateY(y + dY);
        }
    }
}
