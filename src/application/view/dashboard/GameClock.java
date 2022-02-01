package application.view.dashboard;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class GameClock {

  private Timeline timeline;
  private int elapsedTime;
  private StringProperty gameTime;

  public GameClock() {
    timeline = new Timeline(new KeyFrame(Duration.millis(1000), countSeconds));
    timeline.setCycleCount(Animation.INDEFINITE);
    gameTime = new SimpleStringProperty();
    initTimeline();
  }

  private void initTimeline() {
    elapsedTime = 0;
    gameTime.setValue(formatted(elapsedTime));
  }

  private static String formatted(int elapsedTime) {
    return String.format("%03d", elapsedTime);
  }

  private EventHandler<ActionEvent> countSeconds = e -> {
    elapsedTime++;
    gameTime.setValue(formatted(elapsedTime));
  };

  public Timeline getTimeline() {
    return timeline;
  }

  public StringProperty getGameTime() {
    return gameTime;
  }

  public void reset() {
    initTimeline();
  }

}
