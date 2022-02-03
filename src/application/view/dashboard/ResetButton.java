package application.view.dashboard;

import application.controller.GameClock;
import application.view.View;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;

public class ResetButton extends StackPane {

  public ResetButton(View view) {
    setMinWidth(30);
    setMaxWidth(30);
    setMinHeight(30);
    setMaxHeight(30);
    setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
    setBorder(new Border(new BorderStroke(Color.WHITE, Color.GRAY, Color.GRAY, Color.WHITE,
            new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null),
            new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null),
            new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null),
            new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null), null,
            new BorderWidths(2), null)));
    setButtonLabel(new Label(null, new ImageView(
            new Image(getClass().getClassLoader()
                    .getResourceAsStream("resources/img/smile.PNG"),
                    26, 26, true, true))));

    setOnMousePressed(e -> {
      setBorder(new Border(new BorderStroke(Color.GRAY,
              new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null),
              null, new BorderWidths(2, 1, 1, 2))));
      GameClock.stop();
    });

    setOnMouseReleased(e -> {
      GameClock.reset();
      setBorder(new Border(new BorderStroke(
              Color.WHITE, Color.GRAY, Color.GRAY, Color.WHITE,
              new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null),
              new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null),
              new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null),
              new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null),
              null, new BorderWidths(2), null)));
      setButtonLabel(new Label(null, new ImageView(
              new Image(getClass().getClassLoader()
                      .getResourceAsStream("resources/img/smile.PNG"),
                      26, 26, true, true))));
      view.resetGame();
    });
  }

  public void setButtonLabel(Label label) {
    getChildren().clear();
    getChildren().add(label);
  }
}
