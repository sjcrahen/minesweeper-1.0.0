package application.controller;

import application.Main;
import application.model.MinesweeperModel;
import application.view.ViewPane;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

public class MinesweeperController extends Controller {

  private final int DEFAULT_ROWS = 9;
  private final int DEFAULT_COLS = 9;
  private final int DEFAULT_NUM_OF_MINES = 10;
  private int rows = DEFAULT_ROWS;
  private int cols = DEFAULT_COLS;
  private int numberOfMines = DEFAULT_NUM_OF_MINES;

  public MinesweeperController(Main launcher) {
    this.launcher = launcher;

    Menu gameMenu = new Menu("Game");
    MenuItem easy = new MenuItem("Easy");
    easy.setOnAction(e -> resetGame(9, 9, 10));
    MenuItem medium = new MenuItem("Medium");
    medium.setOnAction(e -> resetGame(16, 16, 40));
    MenuItem hard = new MenuItem("Hard");
    hard.setOnAction(e -> resetGame(16, 30, 100));
    gameMenu.getItems().add(easy);
    gameMenu.getItems().add(new SeparatorMenuItem());
    gameMenu.getItems().add(medium);
    gameMenu.getItems().add(new SeparatorMenuItem());
    gameMenu.getItems().add(hard);

    menuBar = new MenuBar(gameMenu);
    menuBar.setPrefWidth(cols * 20 + 24);
    menuBar.setPrefHeight(26);
    menuBar.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
    menuBar.setBorder(new Border(new BorderStroke(
            null, null, Color.DARKGRAY, null, null, null,
            new BorderStrokeStyle(StrokeType.INSIDE, null, null, 10, 0, null),
            null, null, new BorderWidths(1), null)));

    view = new ViewPane(this, menuBar, DEFAULT_ROWS, DEFAULT_COLS);
    model = new MinesweeperModel(this, DEFAULT_ROWS, DEFAULT_COLS, DEFAULT_NUM_OF_MINES);
    gameOn = true;
  }

  @Override
  public void resetGame() {
    view = new ViewPane(this, menuBar, rows, cols);
    model = new MinesweeperModel(this, rows, cols, numberOfMines);
    menuBar.setPrefWidth(cols * 20 + 24);
    launcher.setScene(new Scene(view));
    gameOn = true;
  }

  public void resetGame(int rows1, int cols1, int numberOfMines1) {
    GameClock.stop();
    GameClock.reset();
    rows = rows1;
    cols = cols1;
    numberOfMines = numberOfMines1;
    view = new ViewPane(this, menuBar, rows, cols);
    model = new MinesweeperModel(this, rows, cols, numberOfMines);
    menuBar.setPrefWidth(cols * 20 + 24);
    launcher.setScene(new Scene(view));
    gameOn = true;
  }

  @Override
  public void stopGame() {
    gameOn = false;
    GameClock.stop();
    view.setResetButtonLabel(new Label(null, new ImageView(
            new Image(getClass().getClassLoader()
                    .getResourceAsStream("resources/img/done.PNG"),
                    26, 26, true, true))));
  }

  @Override
  public int getMineCount() {
    return numberOfMines;
  }

  @Override
  public void youWin() {
    gameOn = false;
    view.setResetButtonLabel(new Label(null, new ImageView(
            new Image(getClass().getClassLoader()
                    .getResourceAsStream("resources/img/sunglasses.PNG"),
                    26, 26, true, true))));
  }

}
