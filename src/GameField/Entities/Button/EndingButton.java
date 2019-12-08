package GameField.Entities.Button;

import GameField.GameControl;
import GameField.PlayerIndex;
import GameField.ViewManager;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class EndingButton extends Pane {
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

        highscore.setLayoutX(700);
        highscore.setLayoutY(350);

        exit.setLayoutX(700);
        exit.setLayoutY(450);
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
        exit.setOnMouseClicked(event -> {
            ViewManager.getMainStage().close();

        });
    }
}
