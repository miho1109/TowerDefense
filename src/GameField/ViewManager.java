package GameField;

import GameField.Entities.GameEntity;
import GameField.Entities.MovingObjects.Bullet.Bullet;
import GameField.Entities.Tower.Tower;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ViewManager extends VBox{

    private static final int HEIGHT = 1530;
    private static final int WIDTH = 720;
    public static AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    public ViewManager(){
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane,HEIGHT, WIDTH);
        mainStage = new Stage();
        mainStage.setTitle("TowerDefense");
        mainStage.setScene(mainScene);
        mainStage.setResizable(false);
        createBackGround();
        GameControl.createGameButton();
        //GameControl.gameStart();
//        mainPane.setOnMouseMoved(event -> {
//           event.
//        });
        //PlayerIndex.creatLables();
        //GameControl.printMousePosition();
        //GameControl.mouseClicked();
        //GameControl.printTroopXY();
        //GameControl.createTestButton();
    }


    public Stage getMainStage(){
        return mainStage;
    }

    private void createBackGround(){
        Image backgroundImage = new Image("file:src/GameField/resources/background3.png", HEIGHT, WIDTH, true, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }
}
