package application.view.dashboard;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SmileLabel extends Label {

  public SmileLabel() {
    this(null, new ImageView(new Image("file:resources/img/smile.PNG", 26, 26, true, true)));
  }

  public SmileLabel(String str, Node node) {
    super(str, node);
  }

}
