package sample.app.action.impl;

import javafx.scene.shape.Rectangle;
import sample.app.action.Action;

public class SquareAction extends Action<Rectangle> {

    public SquareAction(double widthScene, double heightScene, Rectangle node) {
        super(widthScene, heightScene, node);
        figure = node;
        figure.setX(widthScene - figure.getWidth());
        figure.setY(heightScene - figure.getHeight());
    }

    public void action() {
        double x = figure.getX();
        double y = figure.getY();
        double sizeX = figure.getWidth();
        double sizeY = figure.getHeight();
        if (!inScene) {
            figure.setX(x + dX);
            figure.setY(y + dY);
            if (x + dX < widthScene && y + dY < heightScene)
                inScene = true;
        } else {
            if (x + sizeX + dX > widthScene || x + dX < 0) {
                dX = -dX;
            }
            if (y + sizeY + dY > heightScene || y + dY < 0) {
                dY = -dY;
            }
            figure.setX(x + dX);
            figure.setY(y + dY);
        }
    }

}
