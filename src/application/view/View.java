package application.view;

import java.beans.PropertyChangeListener;
import application.controller.MinesweeperController;
import application.view.dashboard.Dashboard;
import application.view.minefield.Minefield;
import application.view.minefield.ViewCell;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

public class View extends FlowPane {

  private MinesweeperController controller;
  private static Minefield minefield;
  private static Dashboard dashboard;

  public View(MinesweeperController controller, int rows, int cols) {
    this.controller = controller;
    minefield = new Minefield(this, rows, cols);
    dashboard = new Dashboard(this, cols);

    setVgap(10);
    setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
    setPrefWidth(624);
    setPrefHeight(408);

    getChildren().clear();
    getChildren().addAll(dashboard, minefield);
    setMargin(dashboard, new Insets(10, 10, 0, 10));
    setMargin(minefield, new Insets(0, 10, 10, 10));
  }

  public void resetBoard() {
    minefield.reset();
    dashboard.reset();
  }

  public MinesweeperController getController() {
    return controller;
  }

  public Minefield getMinefield() {
    return minefield;
  }

  public ViewCell getCell(int row, int col) {
    return minefield.getCellMatrix().getCell(row, col);
  }

  public PropertyChangeListener getMineCountListener() {
    return dashboard.getMineCountPane();
  }
}
