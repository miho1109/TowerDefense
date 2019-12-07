package GameField.Entities.Button;

import GameField.GameControl;
import GameField.ViewManager;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class StartButton extends Pane {
    Button play = new Button("Play");
    Button highscore = new Button("Highscore");
    Button exit = new Button("Exit");

    public StartButton() {
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
        exit.setOnMouseClicked(event ->{
            ViewManager.getMainStage().close();
        });
    }
}
