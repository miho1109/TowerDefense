package GameField.Entities.Button;

import GameField.GameControl;
import GameField.HighScore;
import GameField.ViewManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class StartUpButtons extends Pane {
    private static HighScore temp;
    Button play = new Button("Play !");
    Button highscore = new Button("Highscore :)" );
    Button exit = new Button("Exit :(");

    public StartUpButtons() {
        this.getChildren().addAll(play, highscore, exit);
        designButton();
        setLocation();
        ViewManager.mainPane.getChildren().add(this);
        action();
    }

    private void designButton() {
        play.setPrefSize(120, 60);
        play.setStyle("-fx-border-width: 3;\n" + "-fx-border-color: black;\n" + "-fx-background-color: transparent;");

        highscore.setPrefSize(120, 60);
        highscore.setStyle("-fx-border-width: 3;\n" + "-fx-border-color: black;\n" + "-fx-background-color: transparent;");

        exit.setPrefSize(120, 60);
        exit.setStyle("-fx-border-width: 3;\n" + "-fx-border-color: black;\n" + "-fx-background-color: transparent;");
    }

    private void setLocation() {
        play.setLayoutX(700);
        play.setLayoutY(250);

        highscore.setLayoutX(700);
        highscore.setLayoutY(350);

        exit.setLayoutX(700);
        exit.setLayoutY(450);
    }

    private void action() {
        play.setOnMouseClicked(event -> {
            GameControl.gameStart();
            play = null;
            highscore = null;
            exit = null;
            ViewManager.mainPane.getChildren().remove(this);

        });

        highscore.setOnMouseClicked(event ->{
            try {
                temp = new HighScore();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), event1 -> {
                ViewManager.mainPane.getChildren().add(temp);
            }));
            timeline.setCycleCount(1);
            timeline.play();
            timeline.setOnFinished(event1 -> {
                Timeline delayTimeline = new Timeline(new KeyFrame(Duration.seconds(3), event2 -> {
                }));
                delayTimeline.setCycleCount(1);
                delayTimeline.play();
                delayTimeline.setOnFinished(event2 -> {
                    ViewManager.mainPane.getChildren().remove(temp);;
                });
            });
        });

        exit.setOnMouseClicked(event ->{
            ViewManager.getMainStage().close();
        });
    }
}
