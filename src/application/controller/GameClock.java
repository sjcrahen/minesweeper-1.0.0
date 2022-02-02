package application.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Duration;

public class GameClock {

  private static StringProperty gameTimeStringProperty = new SimpleStringProperty();
  private static int elapsedTime = 0;
  private static Timeline timeline = new Timeline();
  private static boolean stopped = true;

  static {
    gameTimeStringProperty.setValue(String.format("%03d", elapsedTime));
    timeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
      gameTimeStringProperty.setValue(String.format("%03d", ++elapsedTime));
    }));
    timeline.setCycleCount(Animation.INDEFINITE);
  }

  public static void play() {
    stopped = false;
    timeline.play();
  }

  public static StringProperty getGameTimeStringProperty() {
    return gameTimeStringProperty;
  }

  public static void reset() {
    elapsedTime = 0;
    gameTimeStringProperty.setValue(String.format("%03d", 0));
  }

  public static void stop() {
    timeline.stop();
    stopped = true;
  }

  public static boolean stopped() {
    return stopped;
  }

}
