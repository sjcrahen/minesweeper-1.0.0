package application.view.dashboard;

import java.beans.PropertyChangeListener;
import application.view.View;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

public class Dashboard extends BorderPane {

  private View view;
  private static ResetButton resetButton;
  private static MineCountPane mineCountPane;
  private static GameClockPane gameClockPane;


  public Dashboard(View view, GameClockPane gameClock, MineCountPane mineCount, ResetButton reset,
          int cols) {
    this.view = view;
    mineCountPane = mineCount;
    gameClockPane = gameClock;
    resetButton = reset;

    setMinWidth(cols * 20 + 4);
    setMaxWidth(cols * 20 + 4);
    setMinHeight(42);
    setMaxHeight(42);
    setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
    setBorder(new Border(new BorderStroke(
            Color.GRAY, Color.WHITE, Color.WHITE, Color.GRAY,
            new BorderStrokeStyle(StrokeType.INSIDE, null, null, 10, 0, null),
            new BorderStrokeStyle(StrokeType.INSIDE, null, null, 10, 0, null),
            new BorderStrokeStyle(StrokeType.INSIDE, null, null, 10, 0, null),
            new BorderStrokeStyle(StrokeType.INSIDE, null, null, 10, 0, null),
            null, new BorderWidths(2), null)));
    setLeft(mineCountPane);
    setCenter(resetButton);
    setRight(gameClockPane);
    BorderPane.setMargin(mineCountPane, new Insets(3));
    BorderPane.setMargin(gameClockPane, new Insets(3));
    BorderPane.setMargin(resetButton, new Insets(5));
  }

  public static ResetButton getResetButton() {
    return resetButton;
  }

  public PropertyChangeListener getMineCountPane() {
    return mineCountPane;
  }

  public void resetGame() {
    view.resetGame();
  }

}
