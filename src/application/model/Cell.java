package application.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Cell {

  private int row;
  private int col;
  private int value;
  private boolean revealed;
  private boolean flagged;
  private PropertyChangeSupport support;
  private PropertyChangeListener pcl;

  public Cell(int row, int col, int value, Model model) {
    this.row = row;
    this.col = col;
    this.value = value;
    revealed = false;
    flagged = false;
    support = new PropertyChangeSupport(this);
    pcl = model.getController().getView().getCell(row, col);
    support.addPropertyChangeListener(pcl);
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public void setRevealed(boolean revealed) {
    boolean oldValue = revealed();
    this.revealed = revealed;
    support.firePropertyChange("reveal", oldValue, this.revealed);
  }

  public boolean revealed() {
    return revealed;
  }

  public void setFlagged(boolean flagged) {
    boolean oldValue = flagged();
    this.flagged = flagged;
    support.firePropertyChange("flag", oldValue, this.flagged);
  }

  public boolean flagged() {
    return flagged;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

}

