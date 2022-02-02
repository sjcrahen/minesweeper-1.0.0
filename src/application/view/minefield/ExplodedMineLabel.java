package application.view.minefield;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ExplodedMineLabel extends Label {

  public ExplodedMineLabel() {
    this(null,
            new ImageView(new Image("file:resources/img/explodedMine.PNG", 19, 19, false, true)));
  }

  public ExplodedMineLabel(String str, Node node) {
    super(str, node);
  }

}
