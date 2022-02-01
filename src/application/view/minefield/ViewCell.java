package application.view.minefield;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import application.controller.Controller;
import application.model.Cell;
import application.view.dashboard.Dashboard;
import javafx.event.EventHandler;
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

  public ViewCell(int row, int col, EventHandler<MouseEvent> handler) {
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
        Dashboard.getResetButton().setButtonLabel("smile");
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
    String type = evt.getPropertyName();
    if (type.equals("reveal")) {
      updateCellLabel(source.getValue());
    } else if (type.equals("flag")) {
      boolean isFlagged = (boolean) evt.getNewValue();
      if (isFlagged) {
        getChildren().add(new CellLabel("flag"));
      } else {
        getChildren().clear();
      }
    }
  }

  private void updateCellLabel(int value) {
    setBorder(new Border(new BorderStroke(Color.GRAY,
            new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null), null,
            new BorderWidths(1))));
    switch (value) {
      case -2:
        getChildren().add(new CellLabel("explodedMine"));
        break;
      case -1:
        getChildren().add(new CellLabel("mine"));
        break;
      case 0:
        break;
      default:
        getChildren().add(new CellLabel(value));
        break;
    }
  }
}


