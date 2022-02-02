package application.view.dashboard;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SunglassesLabel extends Label {

  public SunglassesLabel() {
    this(null, new ImageView(new Image("file:resources/img/sunglasses.PNG", 26, 26, true, true)));
  }

  public SunglassesLabel(String str, Node node) {
    super(str, node);
  }

}
