package application;

import application.controller.Controller;
import application.controller.MinesweeperController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

  private Stage stage;
  private Controller controller;

  @Override
  public void start(Stage primaryStage) {

    controller = new MinesweeperController(this);

    stage = primaryStage;
    stage.setScene(new Scene(controller.getView()));
    stage.setTitle("Minesweeper");
    stage.getIcons().add(new Image("file:resources/img/explodedMine.PNG"));
    stage.setResizable(false);
    stage.show();
  }

  public void setScene(Scene scene) {
    stage.setScene(scene);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
