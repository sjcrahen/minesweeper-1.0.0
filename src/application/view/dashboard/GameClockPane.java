package application.view.dashboard;

import application.controller.GameClock;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameClockPane extends StackPane {

  private Label label;

  public GameClockPane() {
    setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(3), null)));
    label = new Label();
    label.textProperty().bind(GameClock.getGameTimeStringProperty());
    Font font = Font.loadFont(
            getClass().getClassLoader().getResourceAsStream("resources/fonts/digitalFont.ttf"),
            40.0);
    label.setFont(font);
    label.setTextFill(Color.RED);
    getChildren().add(label);
  }
}
