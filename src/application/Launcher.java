package application;

import application.controller.Controller;
import application.controller.MinesweeperController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

  private Stage stage;
  private Controller controller;

  @Override
  public void start(Stage theStage) {

    controller = new MinesweeperController(this);

    stage = theStage;
    stage.setScene(new Scene(controller.getView()));
    stage.setTitle("Minesweeper");
    stage.setResizable(false);
    stage.show();
  }

  public Stage getStage() {
    return stage;
  }
}
