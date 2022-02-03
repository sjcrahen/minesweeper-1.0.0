package application.view;

import java.beans.PropertyChangeListener;
import application.controller.Controller;
import application.view.dashboard.Dashboard;
import application.view.minefield.Minefield;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public abstract class View extends FlowPane {

  protected Controller controller;
  protected static Minefield minefield;
  protected static Dashboard dashboard;

  public Controller getController() {
    return controller;
  }

  public Minefield getMinefield() {
    return minefield;
  }

  public void toggleFlag(int row, int col) {
    controller.toggleFlag(row, col);
  }

  public void revealCell(int row, int col) {
    controller.revealCell(row, col);
  }

  public int getNumberOfMines() {
    return controller.getMineCount();
  };

  public void resetGame() {
    controller.resetGame();
  }

  public abstract void setResetButtonLabel(Label label);

  public abstract PropertyChangeListener getCell(int row, int col);

  public abstract PropertyChangeListener getMineCountPcl();

}
