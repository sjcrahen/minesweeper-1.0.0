package application.view.dashboard;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DoneLabel extends Label {

  public DoneLabel() {
    this(null, new ImageView(new Image("file:resources/img/done.PNG", 26, 26, true, true)));
  }

  public DoneLabel(String str, Node node) {
    super(str, node);
  }

}
