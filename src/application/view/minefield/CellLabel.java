package application.view.minefield;

import java.io.InputStream;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CellLabel extends Label {

  public CellLabel(String label) {
    if (label.equals("flag")) {
      InputStream flag = getClass().getClassLoader().getResourceAsStream("resources/img/flag.PNG");
      setGraphic(new ImageView(new Image(flag, 14, 14, true, true)));
    } else if (label.equals("explodedMine")) {
      InputStream mine =
              getClass().getClassLoader().getResourceAsStream("resources/img/explodedMine.PNG");
      setGraphic(new ImageView(new Image(mine, 19, 19, false, true)));
    } else if (label.equals("mine")) {
      InputStream unexplodedMine =
              getClass().getClassLoader().getResourceAsStream("resources/img/mine.PNG");
      setGraphic(new ImageView(new Image(unexplodedMine, 19, 19, false, true)));
    }
  }

  public CellLabel(int value) {
    Font font = Font.loadFont(
            getClass().getClassLoader().getResourceAsStream("resources/fonts/labelFont.ttf"), 20.0);
    setFont(font);
    setText(Integer.toString(value));
    setFontColor();
  }

  private void setFontColor() {
    switch (this.getText()) {
      case "1":
        this.setTextFill(Color.BLUE);
        break;
      case "2":
        this.setTextFill(Color.GREEN);
        break;
      case "3":
        this.setTextFill(Color.RED);
        break;
      case "4":
        this.setTextFill(Color.DARKBLUE);
        break;
      case "5":
        this.setTextFill(Color.DARKRED);
        break;
      case "6":
        this.setTextFill(Color.ORANGE);
        break;
      default:
        this.setTextFill(Color.BLACK);
        break;
    }
  }

}
