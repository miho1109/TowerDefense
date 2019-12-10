package GameField;

import GameField.Entities.Button.EndingButton;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewManager extends VBox{

    protected static final int HEIGHT = 1530;
    protected static final int WIDTH = 720;
    public static AnchorPane mainPane;
    private static Stage mainStage;

    public ViewManager() throws IOException{
        mainPane = new AnchorPane();
        Scene mainScene = new Scene(mainPane, HEIGHT, WIDTH);
        mainStage = new Stage();
        mainStage.setTitle("TowerDefense");
        mainStage.setScene(mainScene);
        mainStage.setResizable(false);
        createStartUpInterface();
        GameControl.createGameButton();
        new Sound();
    }


    public static Stage getMainStage(){
        return mainStage;
    }

    public static void createInGameBackGround() {
        Image backgroundImage = new Image("file:src/GameField/resources/background3.png", HEIGHT, WIDTH, true, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }

    public void createStartUpInterface() throws IOException{
        Image startBackgroundImage = new Image("file:src/GameField/resources/subBackground.png", HEIGHT, WIDTH, true, true);
        BackgroundImage startBackground = new BackgroundImage(startBackgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(startBackground));
    }

    public static void createEndInterface(){
        Image endBackgroundImage = new Image("file:src/GameField/resources/subBackground.png", HEIGHT, WIDTH, true, true);
        BackgroundImage endBackground = new BackgroundImage(endBackgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(endBackground));
        new EndingButton();
    }
}