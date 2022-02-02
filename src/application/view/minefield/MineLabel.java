package application.view.minefield;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MineLabel extends Label {

  public MineLabel() {
    this(null, new ImageView(new Image("file:resources/img/mine.PNG", 19, 19, false, true)));
  }

  public MineLabel(String str, Node node) {
    super(str, node);
  }

}
