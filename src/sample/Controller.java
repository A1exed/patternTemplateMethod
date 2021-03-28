package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import sample.app.Figure;
import sample.app.Scene;
import sample.app.impl.Circle;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Pane actionArea;

    @FXML
    private Button start;

    @FXML
    private Button stop;

    @FXML
    private RadioButton circleBtn;

    @FXML
    private RadioButton squareBtn;

    @FXML
    private RadioButton starBtn;

    private List<ImageView> views;

    private Scene scene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        views = new LinkedList<>();
        ToggleGroup group = new ToggleGroup();
        circleBtn.setToggleGroup(group);
        squareBtn.setToggleGroup(group);
        starBtn.setToggleGroup(group);
        circleBtn.setSelected(true);

        scene = new Scene(actionArea);
    }

    @FXML
    public void start() throws Exception {
        Figure figure = null;
        ImageView figureView;
        if (circleBtn.isSelected()) {
            figure = scene.addFigure("circle");
        }
        if (squareBtn.isSelected()) {
            figure = scene.addFigure("square");
        }
        if (starBtn.isSelected()) {
            figure = scene.addFigure("star");
        }
        assert figure != null;
        figureView = figure.getImageView();
        views.add(figureView);
        scene.startFigure(figure);

    }

    @FXML
    public void stop() {
        start.setDisable(true);
        stop.setDisable(true);
        scene.stopScene();
    }
}
