package application.model;

import java.util.ArrayList;

public class AdjacentCellsListBuilder {

  public static ArrayList<Cell> build(Cell[][] matrix, int row,
          int col) {
    ArrayList<Cell> cellsList = new ArrayList<>();

    if (row > 0) {
      cellsList.add(matrix[row - 1][col]);

      if (col > 0) {
        cellsList.add(matrix[row - 1][col - 1]);
      }
      if (col < matrix[0].length - 1) {
        cellsList.add(matrix[row - 1][col + 1]);
      }
    }

    if (row < matrix.length - 1) {
      cellsList.add(matrix[row + 1][col]);

      if (col > 0) {
        cellsList.add(matrix[row + 1][col - 1]);
      }
      if (col < matrix[0].length - 1) {
        cellsList.add(matrix[row + 1][col + 1]);
      }
    }

    if (col > 0) {
      cellsList.add(matrix[row][col - 1]);
    }

    if (col < matrix[0].length - 1) {
      cellsList.add(matrix[row][col + 1]);
    }

    return cellsList;
  }

}
