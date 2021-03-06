package application.view.minefield;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import application.controller.Controller;
import application.model.Cell;
import application.view.View;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

public class ViewCell extends StackPane implements PropertyChangeListener {

  private int row;
  private int col;

  public ViewCell(View view, int row, int col, EventHandler<MouseEvent> handler) {
    this.row = row;
    this.col = col;

    setMinWidth(20);
    setMaxWidth(20);
    setMinHeight(20);
    setMaxHeight(20);

    setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
    setBorder(new Border(new BorderStroke(Color.WHITE, Color.GRAY, Color.GRAY, Color.WHITE,
            new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, USE_PREF_SIZE,
                    USE_PREF_SIZE, null),
            new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, USE_PREF_SIZE,
                    USE_PREF_SIZE, null),
            new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, USE_PREF_SIZE,
                    USE_PREF_SIZE, null),
            new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, USE_PREF_SIZE,
                    USE_PREF_SIZE, null),
            null, new BorderWidths(2), null)));

    setOnMousePressed(handler);
    setOnMouseReleased(e -> {
      if (Controller.gameIsOn())
        view.setResetButtonLabel(new Label(null, new ImageView(
                new Image(getClass().getClassLoader()
                        .getResourceAsStream("resources/img/smile.PNG"),
                        26, 26, true, true))));
    });
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  @Override
  public String toString() {
    return "( " + getRow() + ", " + getCol() + ")";
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {

    Cell source = (Cell) evt.getSource();
    String eventType = evt.getPropertyName();

    if (eventType.equals("reveal")) {

      displayCellLabel(source.getValue());

    } else if (eventType.equals("flag")) {

      boolean isFlagged = (boolean) evt.getNewValue();

      if (isFlagged) {
        getChildren().add(new ImageView(
                new Image(getClass().getClassLoader()
                        .getResourceAsStream("resources/img/flag.PNG"),
                        14, 14, true, true)));
      } else {
        getChildren().clear();
      }
    }
  }

  private void displayCellLabel(int value) {
    setBorder(new Border(new BorderStroke(Color.GRAY,
            new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null), null,
            new BorderWidths(1))));
    switch (value) {
      case -2:
        getChildren().add(new ImageView(
                new Image(getClass().getClassLoader()
                        .getResourceAsStream("resources/img/explodedMine.PNG"),
                        19, 19, false, true)));
        break;
      case -1:
        getChildren().add(new ImageView(
                new Image(getClass().getClassLoader()
                        .getResourceAsStream("resources/img/mine.PNG"),
                        19, 19, false, true)));
        break;
      case 0:
        break;
      default:
        getChildren().add(new ValueLabel(value));
        break;
    }
  }
}


