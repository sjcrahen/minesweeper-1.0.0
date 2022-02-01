package application.view.dashboard;

import java.beans.PropertyChangeListener;
import application.view.View;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

public class Dashboard extends HBox {

  private View view;
  private static GameClock gameClock;
  private static ResetButton resetButton;
  private static MineCountPane mineCountPane;
  private static GameClockPane gameCountPane;


  public Dashboard(View view, int cols) {
    this.view = view;
    gameClock = new GameClock();
    mineCountPane = new MineCountPane(view);
    gameCountPane = new GameClockPane(gameClock);
    resetButton = new ResetButton(this);

    setMinWidth(cols * 20 + 4);
    setMaxWidth(cols * 20 + 4);
    setMinHeight(54);
    setMaxHeight(54);
    setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
    setBorder(new Border(new BorderStroke(
            Color.GRAY, Color.WHITE, Color.WHITE, Color.GRAY,
            new BorderStrokeStyle(StrokeType.INSIDE, null, null, 10, 0, null),
            new BorderStrokeStyle(StrokeType.INSIDE, null, null, 10, 0, null),
            new BorderStrokeStyle(StrokeType.INSIDE, null, null, 10, 0, null),
            new BorderStrokeStyle(StrokeType.INSIDE, null, null, 10, 0, null),
            null, new BorderWidths(2), null)));
    getChildren().addAll(mineCountPane, resetButton, gameCountPane);
    setAlignment(Pos.CENTER);
    HBox.setMargin(mineCountPane, new Insets(10, 195, 10, 10));
    HBox.setMargin(gameCountPane, new Insets(10, 10, 10, 195));
    HBox.setMargin(resetButton, new Insets(10));
  }

  public void reset() {
    resetButton.setButtonLabel("smile");
    gameClock.reset();
  }

  public static GameClock getGameClock() {
    return gameClock;
  }

  public static ResetButton getResetButton() {
    return resetButton;
  }

  public PropertyChangeListener getMineCountPane() {
    return mineCountPane;
  }

  public void resetGame() {
    view.getController().resetGame();
  }

}
