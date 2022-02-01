package application.controller;

import application.Launcher;
import application.model.Model;
import application.view.View;
import application.view.dashboard.Dashboard;
import javafx.scene.Scene;

public class MinesweeperController extends Controller {

  private Launcher launcher;
  private final int ROW = 16;
  private final int COL = 30;
  private final int NUM_OF_MINES = 100;

  public MinesweeperController(Launcher launcher) {
    this.launcher = launcher;
    view = new View(this, ROW, COL);
    model = new Model(this, ROW, COL, NUM_OF_MINES);
    gameOn = true;
  }

  @Override
  public void resetGame() {
    view = new View(this, ROW, COL);
    model = new Model(this, ROW, COL, NUM_OF_MINES);
    launcher.getStage().setScene(new Scene(view));
    gameOn = true;
  }

  @Override
  public void revealCell(int row, int col) {
    model.revealCell(row, col);
  }

  @Override
  public void toggleFlag(int row, int col) {
    model.toggleFlag(row, col);
  }

  @Override
  public void stopGame() {
    gameOn = false;
    Dashboard.getGameClock().getTimeline().stop();
    Dashboard.getResetButton().setButtonLabel("done");
  }

}
