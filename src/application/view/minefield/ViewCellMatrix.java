package application.view.minefield;

import application.controller.Controller;
import application.view.dashboard.Dashboard;
import javafx.animation.Animation;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;

public class ViewCellMatrix extends TilePane {

  private Minefield minefield;
  private ViewCell[][] cellsMatrix;

  public ViewCellMatrix(Minefield minefield, int rows, int cols) {
    this.minefield = minefield;
    cellsMatrix = new ViewCell[rows][cols];

    EventHandler<MouseEvent> handler = new MouseEventHandler();
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        cellsMatrix[row][col] = new ViewCell(row, col, handler);
      }
    }

    getChildren().clear();
    for (int row = 0; row < cellsMatrix.length; row++) {
      getChildren().addAll(cellsMatrix[row]);
    }
  }

  public Minefield getMinefield() {
    return minefield;
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
          Dashboard.getResetButton().setButtonLabel("scared");
          minefield.getView().getController().revealCell(clickedCell.getRow(),
                  clickedCell.getCol());
        } else if (event.getButton() == MouseButton.SECONDARY) {
          minefield.getView().getController().toggleFlag(clickedCell.getRow(),
                  clickedCell.getCol());
        }
      }
    }
  }

  private static void startGameClock() {
    if (Dashboard.getGameClock().getTimeline().getStatus() == Animation.Status.STOPPED)
      Dashboard.getGameClock().getTimeline().play();
  }
}
