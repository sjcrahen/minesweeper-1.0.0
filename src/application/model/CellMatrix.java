package application.model;

import java.util.ArrayList;
import java.util.List;

public class CellMatrix {

  private Model model;
  private Cell[][] matrix;
  private List<Cell> minesList;
  private int numberOfMines;

  public CellMatrix(Model model, int rows, int cols, int numOfMines) {
    this.model = model;
    matrix = new Cell[rows][cols];
    numberOfMines = numOfMines;
    minesList = new ArrayList<>();
    initCells();
    setValues();
  }

  public Cell[][] getMatrix() {
    return matrix;
  }

  public Cell getCell(int row, int col) {
    return matrix[row][col];
  }

  public List<Cell> getMinesList() {
    return minesList;
  }

  private void initCells() {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        matrix[row][col] =
                new Cell(row, col, 0, model.getCellPcl(row, col));
      }
    }
  }

  private void setValues() {
    placeMines();
    setAdjacencyValues();
  }

  private void placeMines() {
    int remainingMines = numberOfMines;
    while (remainingMines > 0) {
      int row = (int) (Math.random() * matrix.length);
      int col = (int) (Math.random() * matrix[0].length);
      Cell cell = matrix[row][col];
      if (cell.getValue() != -1) {
        cell.setValue(-1);
        minesList.add(cell);
        remainingMines--;
      }
    }
  }

  private void setAdjacencyValues() {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        if (!isMine(matrix[row][col].getValue())) {
          matrix[row][col].setValue(countAdjacentMines(row, col));
        }
      }
    }
  }

  private int countAdjacentMines(int row, int col) {
    int numberOfAdjacentMines = 0;
    List<Cell> adjacentCells = AdjacentCellsListBuilder.build(matrix, row, col);
    for (Cell cell : adjacentCells) {
      if (cell.getValue() == -1)
        numberOfAdjacentMines++;
    }
    return numberOfAdjacentMines;
  }

  private static boolean isMine(int value) {
    return value == -1;
  }
}
