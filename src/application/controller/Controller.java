package application.controller;

import java.beans.PropertyChangeListener;
import application.model.Model;
import application.view.View;

public abstract class Controller {

  View view;
  Model model;
  static boolean gameOn;

  public View getView() {
    return view;
  }

  public Model getModel() {
    return model;
  }

  public PropertyChangeListener getMineCountListener() {
    return view.getMineCountListener();
  }

  public static boolean gameIsOn() {
    return gameOn;
  }

  public void startGame() {
    gameOn = true;
  }

  public abstract void stopGame();

  public abstract void resetGame();

  abstract void revealCell(int row, int col);

  abstract void toggleFlag(int row, int col);
}
