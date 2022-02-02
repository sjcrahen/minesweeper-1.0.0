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

  public abstract PropertyChangeListener getCell(int row, int col);

  public abstract PropertyChangeListener getMineCountPcl();

  public abstract int getNumberOfMines();

  public abstract void resetGame();

  public abstract void setResetButtonLabel(Label smileLabel);

}
