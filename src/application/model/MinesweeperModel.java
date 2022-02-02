package application.model;

import java.util.List;
import application.controller.Controller;
import application.controller.GameClock;

public class MinesweeperModel extends Model {

  public MinesweeperModel(Controller controller, int rows, int cols, int numOfMines) {
    this.controller = controller;
    this.rows = rows;
    this.cols = cols;
    numberOfMines = numOfMines;
    matrix = new CellMatrix(this, rows, cols, numOfMines);
    numberOfUnflaggedMines = numOfMines;
    numberOfRevealedCells = 0;
    support.addPropertyChangeListener(controller.getMineCountPcl());
  }

  @Override
  public void revealCell(int row, int col) {
    Cell cell = matrix.getCell(row, col);
    if (!cell.revealed() && !cell.flagged()) {

      if (cell.getValue() == -1) { // hit bomb

        cell.setValue(-2); // explodedMine
        cell.setRevealed(true);

        controller.stopGame();
        revealAllMines();

      } else if (cell.getValue() == 0) {
        cell.setRevealed(true);
        numberOfRevealedCells++;
        checkForWin();
        revealAdjacentCells(cell.getRow(), cell.getCol());

      } else {
        cell.setRevealed(true);
        numberOfRevealedCells++;
        checkForWin();
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

  @Override
  public void toggleFlag(int row, int col) {
    Cell cell = matrix.getCell(row, col);
    if (!cell.revealed()) {
      cell.setFlagged(!cell.flagged());
      int oldValue = numberOfUnflaggedMines;
      numberOfUnflaggedMines = cell.flagged() ? --numberOfUnflaggedMines : ++numberOfUnflaggedMines;
      support.firePropertyChange("mineCount", oldValue, numberOfUnflaggedMines);
      checkForWin();
    }
  }

  private void checkForWin() {
    if (numberOfUnflaggedMines == 0 && numberOfRevealedCells == rows * cols - numberOfMines) {
      GameClock.stop();
      controller.youWin();
    }
  }
}
