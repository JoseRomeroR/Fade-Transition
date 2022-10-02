
package fadetransition;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeTransition extends Application {
    Pane pane = new Pane();       
    Ellipse ellipse = new Ellipse();
    javafx.animation.FadeTransition fadeTransition = new javafx.animation.FadeTransition();
    Scene scene;
    
    @Override
    public void start(Stage stage) {
        
        //Settings ellipse
        ellipse.setRadiusX(100);
        ellipse.setRadiusY(75);
        ellipse.centerXProperty().bind(pane.widthProperty().divide(2));
        ellipse.centerYProperty().bind(pane.heightProperty().divide(2));
        ellipse.setFill(Color.RED);
        ellipse.setStroke(Color.BLACK);
        ellipse.setOnMousePressed(e -> fadeStop());
        ellipse.setOnMouseReleased(e -> fadePlay());
        
        //Settings fade transition
        fadeTransition.setNode(ellipse);
        fadeTransition.setDuration(Duration.millis(3000));
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.1);
        fadeTransition.setCycleCount(Timeline.INDEFINITE);
        fadeTransition.play();
        
        //Settins pane
        pane.getChildren().add(ellipse);
        
        //Settings scene
        scene= new Scene(pane, 300, 250);
        
        //Settings stage
        stage.setTitle("Fade Transition");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void fadePlay() {
        fadeTransition.play();
       
    }
    private void fadeStop(){
        fadeTransition.stop(
        );
    }
    
}
