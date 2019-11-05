package GameField.Entities.Tower;

import GameField.ViewManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static GameField.ViewManager.mainPane;

public class greenTower extends Tower {
    private double x;
    private double y;
    private double width;
    private double height;

    public Image image = new Image("GameField/Entities/Tower/Resources/greenTower.png");
    public ImageView greenTower = new ImageView(image);

    public greenTower() {
        super();
        greenTower.setPreserveRatio(true);
        mainPane.setOnMouseDragged(event -> {
            greenTower.setX(event.getSceneX()-60);
            greenTower.setY(event.getSceneY()-70);
            ViewManager.mainPane.getChildren().add(greenTower);

        });
        /**
        greenTower.setX(250);
        greenTower.setY(250);
        ViewManager.mainPane.getChildren().add(greenTower);
         */
    }
}
