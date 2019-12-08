package GameField.Entities.Button;

import GameField.GameControl;
import GameField.HighScore;
import GameField.PlayerIndex;
import GameField.ViewManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class EndingButton extends Pane {
    private static HighScore temp;
    Button rePlay = new Button("Try Again !");
    Button highscore = new Button("Highscore :)");
    Button exit = new Button("Exit :(");

    public EndingButton() {
        this.getChildren().addAll(rePlay, highscore, exit);
        designButton();
        setLocation();
        ViewManager.mainPane.getChildren().add(this);
        action();
    }

    private void designButton() {
        rePlay.setPrefSize(120, 60);
        rePlay.setStyle("-fx-border-width: 3;\n" + "-fx-border-color: black;\n" + "-fx-background-color: transparent;");

        highscore.setPrefSize(120, 60);
        highscore.setStyle("-fx-border-width: 3;\n" + "-fx-border-color: black;\n" + "-fx-background-color: transparent;");

        exit.setPrefSize(120, 60);
        exit.setStyle("-fx-border-width: 3;\n" + "-fx-border-color: black;\n" + "-fx-background-color: transparent;");
    }

    private void setLocation() {
        rePlay.setLayoutX(700);
        rePlay.setLayoutY(250);
        rePlay.setViewOrder(-3);

        highscore.setLayoutX(700);
        highscore.setLayoutY(350);
        highscore.setViewOrder(-3);

        exit.setLayoutX(700);
        exit.setLayoutY(450);
        exit.setViewOrder(-3);
    }

    private void action() {
        rePlay.setOnMouseClicked(event -> {
            GameControl.gameStart();
            rePlay = null;
            highscore = null;
            exit = null;
            PlayerIndex.resetPlayerIndex();
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

        exit.setOnMouseClicked(event -> {
            ViewManager.getMainStage().close();

        });
    }
}