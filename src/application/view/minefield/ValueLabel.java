package application.view.minefield;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ValueLabel extends Label {

  public ValueLabel(int value) {
    Font font = Font.loadFont(
            getClass().getClassLoader().getResourceAsStream("resources/fonts/labelFont.ttf"), 20.0);
    setFont(font);
    setText(String.valueOf(value));
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
