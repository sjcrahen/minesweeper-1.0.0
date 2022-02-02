package application.controller;

import java.beans.PropertyChangeListener;
import application.Launcher;
import application.model.Model;
import application.view.View;
import javafx.scene.control.MenuBar;

public abstract class Controller {

  protected Launcher launcher;
  protected View view;
  protected MenuBar menuBar;
  protected Model model;
  protected GameClock clock;
  public static boolean gameOn;

  public View getView() {
    return view;
  }

  public Model getModel() {
    return model;
  }

  public PropertyChangeListener getCellPcl(int row, int col) {
    return view.getCell(row, col);
  }

  public PropertyChangeListener getMineCountPcl() {
    return view.getMineCountPcl();
  }

  public void revealCell(int row, int col) {
    model.revealCell(row, col);
  }

  public void toggleFlag(int row, int col) {
    model.toggleFlag(row, col);
  }

  public static boolean gameIsOn() {
    return gameOn;
  }

  public void startGame() {
    gameOn = true;
  }

  public abstract void stopGame();

  public abstract void resetGame();

  public abstract int getMineCount();

  public abstract void youWin();

}
