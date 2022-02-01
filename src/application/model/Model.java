package application.model;

import java.beans.PropertyChangeSupport;
import java.util.List;
import application.controller.Controller;
import application.view.dashboard.Dashboard;

public class Model {

  private Controller controller;
  private CellMatrix matrix;
  private PropertyChangeSupport support;
  private int totalNumberOfMines;
  private int numberOfUnflaggedMines;

  public Model(Controller controller, int rows, int cols, int numOfMines) {
    this.controller = controller;
    matrix = new CellMatrix(this, rows, cols, numOfMines);
    totalNumberOfMines = numOfMines;
    numberOfUnflaggedMines = totalNumberOfMines;
    support = new PropertyChangeSupport(this);
    support.addPropertyChangeListener(controller.getMineCountListener());
  }

  public void revealCell(int row, int col) {
    Cell cell = matrix.getMatrix()[row][col];
    if (!cell.revealed() && !cell.flagged()) {

      if (cell.getValue() == -1) {
        cell.setValue(-2); // explodedMine
        cell.setRevealed(true);

        controller.stopGame();
        Dashboard.getGameClock().getTimeline().stop();
        Dashboard.getResetButton().setButtonLabel("done");

        revealAllMines();

      } else if (cell.getValue() == 0) {
        cell.setRevealed(true);
        revealAdjacentCells(cell.getRow(), cell.getCol());

      } else {
        cell.setRevealed(true);
      }
    }
  }

  private void revealAdjacentCells(int row, int col) {
    List<Cell> list =
            AdjacentCellsListBuilder.build(matrix.getMatrix(), row, col);
    for (Cell cell : list) {
      revealCell(cell.getRow(), cell.getCol());
    }
  }

  private void revealAllMines() {
    for (Cell cell : matrix.getMinesList()) {
      if (!cell.revealed() && !cell.flagged()) {
        cell.setRevealed(true);
      }
    }
  }

  public void toggleFlag(int row, int col) {
    Cell cell = matrix.getMatrix()[row][col];
    if (!cell.revealed()) {
      cell.setFlagged(!cell.flagged());
      int oldValue = numberOfUnflaggedMines;
      numberOfUnflaggedMines = cell.flagged() ? --numberOfUnflaggedMines : ++numberOfUnflaggedMines;
      support.firePropertyChange("mineCount", oldValue, numberOfUnflaggedMines);
    }
  }

  public Controller getController() {
    return controller;
  }

}
