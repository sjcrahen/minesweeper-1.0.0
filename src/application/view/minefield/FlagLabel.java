package application.view.minefield;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FlagLabel extends Label {

  public FlagLabel() {
    this(null, new ImageView(new Image("file:resources/img/flag.PNG", 14, 14, true, true)));
  }

  public FlagLabel(String str, Node node) {
    super(str, node);
  }

}
