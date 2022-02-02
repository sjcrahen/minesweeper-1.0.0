package application.view.minefield;

import application.controller.Controller;
import application.controller.GameClock;
import application.view.View;
import application.view.dashboard.ScaredLabel;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;

public class ViewCellMatrix extends TilePane {

  private View view;
  private ViewCell[][] cellsMatrix;

  public ViewCellMatrix(View view, int rows, int cols) {
    this.view = view;
    cellsMatrix = new ViewCell[rows][cols];

    EventHandler<MouseEvent> handler = new MouseEventHandler();
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        cellsMatrix[row][col] = new ViewCell(view, row, col, handler);
      }
    }

    getChildren().clear();
    for (int row = 0; row < cellsMatrix.length; row++) {
      getChildren().addAll(cellsMatrix[row]);
    }
  }

  public ViewCell[][] getCellsMatrix() {
    return cellsMatrix;
  }

  public void setCellsMatrix(ViewCell[][] cellsMatrix) {
    this.cellsMatrix = cellsMatrix;
  }

  public ViewCell getCell(int row, int col) {
    return cellsMatrix[row][col];
  }

  // EventHandler for MouseEvents
  class MouseEventHandler implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
      if (Controller.gameIsOn()) {

        ViewCell clickedCell = (ViewCell) event.getSource();

        if (event.getButton() == MouseButton.PRIMARY) {

          startGameClock();

          view.setResetButtonLabel(new ScaredLabel());

          view.getController().revealCell(clickedCell.getRow(),
                  clickedCell.getCol());

        } else if (event.getButton() == MouseButton.SECONDARY) {

          view.getController().toggleFlag(clickedCell.getRow(),
                  clickedCell.getCol());
        }
      }
    }
  }

  private static void startGameClock() {
    if (GameClock.stopped()) {
      GameClock.play();
    }
  }
}
