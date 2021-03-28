package sample.app.impl;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.app.Action;
import sample.app.Figure;

import java.io.File;

public class Circle implements Figure {

    private ImageView imageView;

    private Action action;

    public Circle(double sceneWidth, double sceneHeight, int speed) {
        imageView = new ImageView();
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        imageView.setX(sceneWidth);
        imageView.setY(sceneHeight - 50);
        imageView.setImage(new Image(new File("src/sample/asserts/circle.png").toURI().toString()));
        action = new Action(sceneWidth, sceneHeight, this, speed);
    }

    @Override
    public void action() {
        action.action();
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }
}
