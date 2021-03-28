package sample.app;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.app.impl.Circle;
import sample.app.impl.Square;
import sample.app.impl.Star;

public class Scene {

    private Pane actionArea;

    private final double width;

    private final double height;

    private static final int SPEED = 5;

    private boolean isAction;

    public Scene(Pane actionArea) {
        this.actionArea = actionArea;
        width = actionArea.getWidth();
        height = actionArea.getHeight();
        isAction = true;
    }

    public Figure addFigure(String figureID) throws Exception {
        Figure figure;
        switch (figureID) {
            case "circle":
                figure = new Circle(width, height, SPEED);
                break;
            case "star":
                figure = new Star(width, height, SPEED);
                break;
            case "square":
                figure = new Square(width, height, SPEED);
                break;
            default:
                throw new Exception("Некорректная фигура");
        }
        actionArea.getChildren().add(figure.getImageView());
        return figure;
    }

    public void startFigure(Figure figure) {
        Thread thread = new Thread(() -> {
            while (isAction) {
                try {
                    figure.action();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public void stopScene() {
        isAction = false;
    }
}
