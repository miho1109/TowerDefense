package sample;

import ViewManager.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
            try{
                ViewManager view = new ViewManager();
                primaryStage = view.getMainStage();
                primaryStage.show();
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
