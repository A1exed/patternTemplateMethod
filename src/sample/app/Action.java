package sample.app;

import javafx.scene.image.ImageView;

public class Action {

    private double widthScene;

    private double heightScene;

    private Figure figure;

    private ImageView imageView;

    private int speed;

    public Action(double widthScene, double heightScene, Figure figure, int speed) {
        this.widthScene = widthScene;
        this.heightScene = heightScene;
        this.figure = figure;
        this.speed = speed;
        imageView = figure.getImageView();
    }

    public void action() {
        imageView.setX(imageView.getX() + speed);
    }
}
