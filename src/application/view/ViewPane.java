package application.view;

import java.beans.PropertyChangeListener;
import application.controller.MinesweeperController;
import application.view.dashboard.Dashboard;
import application.view.dashboard.GameClockPane;
import application.view.dashboard.MineCountPane;
import application.view.dashboard.ResetButton;
import application.view.minefield.Minefield;
import application.view.minefield.ViewCellMatrix;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ViewPane extends View {

  private ResetButton resetButton;

  public ViewPane(MinesweeperController controller, MenuBar menu, int rows, int cols) {
    this.controller = controller;

    // inject cellMatrix into minefield
    ViewCellMatrix cellMatrix = new ViewCellMatrix(this, rows, cols);
    minefield = new Minefield(this, cellMatrix, rows, cols);

    GameClockPane gameClockPane = new GameClockPane();
    MineCountPane mineCountPane = new MineCountPane(this);
    resetButton = new ResetButton(this);
    dashboard = new Dashboard(this, gameClockPane, mineCountPane, resetButton, cols);

    setVgap(10);
    setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
    setPrefWidth(cols * 20 + 24);

    getChildren().clear();
    getChildren().addAll(menu, dashboard, minefield);
    setMargin(dashboard, new Insets(0, 10, 0, 10));
    setMargin(minefield, new Insets(0, 10, 10, 10));
  }

  @Override
  public PropertyChangeListener getCell(int row, int col) {
    return minefield.getCell(row, col);
  }

  @Override
  public PropertyChangeListener getMineCountPcl() {
    return dashboard.getMineCountPane();
  }

  @Override
  public int getNumberOfMines() {
    return controller.getMineCount();
  }

  @Override
  public void resetGame() {
    controller.resetGame();
  }

  @Override
  public void setResetButtonLabel(Label label) {
    resetButton.setButtonLabel(label);
  }
}
