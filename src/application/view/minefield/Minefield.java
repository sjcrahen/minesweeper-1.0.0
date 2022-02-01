package application.view.minefield;

import application.view.View;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

public class Minefield extends StackPane {

  private View view;
  private ViewCellMatrix cellMatrix;

  public Minefield(View view, int rows, int cols) {
    this.view = view;
    cellMatrix = new ViewCellMatrix(this, rows, cols);
    getChildren().clear();
    getChildren().add(cellMatrix);

    setMinWidth(cols * cellMatrix.getTileWidth() + 4);
    setMaxWidth(cols * cellMatrix.getTileWidth() + 4);
    setMinHeight(rows * cellMatrix.getTileWidth() + 4);
    setMaxHeight(rows * cellMatrix.getTileWidth() + 4);
    setBorder(new Border(new BorderStroke(
            Color.GRAY, Color.WHITE, Color.WHITE, Color.GRAY,
            new BorderStrokeStyle(StrokeType.INSIDE, null, null, 10, 0, null),
            new BorderStrokeStyle(StrokeType.INSIDE, null, null, 10, 0, null),
            new BorderStrokeStyle(StrokeType.INSIDE, null, null, 10, 0, null),
            new BorderStrokeStyle(StrokeType.INSIDE, null, null, 10, 0, null),
            null, new BorderWidths(2), null)));
  }

  public View getView() {
    return view;
  }

  public ViewCellMatrix getCellMatrix() {
    return cellMatrix;
  }

  public void reset() {
    // TODO Auto-generated method stub

  }
}
