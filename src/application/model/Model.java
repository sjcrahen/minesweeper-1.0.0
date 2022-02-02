package application.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import application.controller.Controller;

public abstract class Model {

  protected Controller controller;
  protected CellMatrix matrix;
  protected final PropertyChangeSupport support = new PropertyChangeSupport(this);
  protected int rows;
  protected int cols;
  protected int numberOfMines;
  protected int numberOfUnflaggedMines;
  protected int numberOfRevealedCells;

  public abstract void revealCell(int row, int col);

  public abstract void toggleFlag(int row, int col);

  public PropertyChangeListener getCellPcl(int row, int col) {
    return controller.getCellPcl(row, col);
  }

}
