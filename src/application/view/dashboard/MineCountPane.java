package application.view.dashboard;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import application.view.View;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MineCountPane extends StackPane implements PropertyChangeListener {

  private Label label;

  public MineCountPane(View view) {
    setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(3), null)));
    label = new Label();
    Font font = Font.loadFont("file:resources/fonts/digitalFont.ttf", 40.0);
    label.setFont(font);
    label.setTextFill(Color.RED);
    label.setText(String.format("%03d", view.getNumberOfMines()));
    getChildren().add(label);
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    label.setText(String.format("%03d", evt.getNewValue()));
  }
}
