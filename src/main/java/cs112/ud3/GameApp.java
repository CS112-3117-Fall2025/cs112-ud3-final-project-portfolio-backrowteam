package cs112.ud3;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class GameApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApp.class.getResource("finalfxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setResizable(false);
        stage.setTitle("Clicker");
        stage.setScene(scene);
        stage.show();

        FinalController myController = fxmlLoader.getController();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> myController.everySecond()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.playFromStart();

        myController.oneTimeCall();
    }

    public static void main(String[] args) {
        launch();
    }
}