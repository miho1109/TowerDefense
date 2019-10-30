package GameField;

import GameField.Entities.Enemy.NormalTroop;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ViewManager extends VBox{

    private static final int HEIGHT = 1496;
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
        creatBackGround();
        NormalTroop troop1 = new NormalTroop(1.0,2.0,3.0,4.0,5.0,6.0,7.0);
        print();
    }

    void print() {
        mainPane.setOnMouseMoved(event -> {
            System.out.println(event.getSceneX());
            System.out.println(event.getSceneY());
        });
    }

    public Stage getMainStage(){
        return mainStage;
    }

    private void creatBackGround(){
        Image backgroundImage = new Image("GameField/resources/background.png", 1496,720, true, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }
}
