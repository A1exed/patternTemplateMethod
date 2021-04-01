package sample.app;

import javafx.scene.Node;

public class Action {

    private double widthScene;

    private double heightScene;

    private Node node;

    private int speed;

    public Action(double widthScene, double heightScene, Node node, int speed) {
        this.widthScene = widthScene;
        this.heightScene = heightScene;
        this.speed = speed;
        this.node = node;
        this.node.setLayoutX(widthScene);
        this.node.setLayoutY(heightScene);
    }

    public void action() {
        node.setLayoutX(node.getLayoutX() - speed);
        node.setLayoutY(node.getLayoutY() - speed);
    }
}
