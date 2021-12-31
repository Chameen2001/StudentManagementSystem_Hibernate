package util;

import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class TransitionUtil {
    public static void start_scale_transition(double x_coordinate, double y_coordinate, Node node, Duration duration_millis){
        ScaleTransition scaleTransition = new ScaleTransition(duration_millis,node);
        scaleTransition.setToX(x_coordinate);
        scaleTransition.setToY(y_coordinate);
        scaleTransition.play();
    }
}
