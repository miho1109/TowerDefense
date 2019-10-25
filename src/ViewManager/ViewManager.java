package ViewManager;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ViewManager {

    private static final int HEIGHT = 1280;
    private static final int WIDTH = 720;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    public ViewManager(){
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane,HEIGHT, WIDTH);
        mainStage = new Stage();
        mainStage.setTitle("TowerDefense");
        mainStage.setScene(mainScene);
        creatBackGround();
    }

    public Stage getMainStage(){
        return mainStage;
    }

    private void creatBackGround(){
        Image backgroundImage = new Image("ViewManager/resources/background.png", 1280,720, true, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }
}
