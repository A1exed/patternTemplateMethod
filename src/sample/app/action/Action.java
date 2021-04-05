package sample.app.action;

public abstract class Action<T> {

    protected double widthScene;

    protected double heightScene;

    protected T figure;

    protected boolean inScene;

    protected double dX;

    protected double dY;

    public Action(double widthScene, double heightScene, T node) {
        this.widthScene = widthScene;
        this.heightScene = heightScene;
        this.figure = node;
        dX = - ((Math.random() * 3) + 1);
        dY = - ((Math.random() * 3) + 1);
        this.inScene = false;
    }
}
