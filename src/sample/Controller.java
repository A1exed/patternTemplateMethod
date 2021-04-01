package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import sample.app.Figure;
import sample.app.Scene;

import java.net.URL;
import java.util.ArrayList;
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

    private Scene scene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup group = new ToggleGroup();
        circleBtn.setToggleGroup(group);
        squareBtn.setToggleGroup(group);
        starBtn.setToggleGroup(group);
        circleBtn.setSelected(true);

        scene = new Scene(actionArea);
    }

    @FXML
    public void start() throws Exception {
        if (circleBtn.isSelected()) {
            scene.addFigure("circle");
        }
        if (squareBtn.isSelected()) {
            scene.addFigure("square");
        }
        if (starBtn.isSelected()) {
            scene.addFigure("star");
        }
    }

    @FXML
    public void stop() {
        scene.stopScene();
    }
}
