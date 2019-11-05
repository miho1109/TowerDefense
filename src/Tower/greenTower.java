package Tower;

import GameField.ViewManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class greenTower extends Tower {
    private double x;
    private double y;
    private double width;
    private double height;

    public Image image = new Image("GameField/Tower/Resources/greenTower.png");
    public ImageView Tower = new ImageView(image);

    public greenTower() {
        super();
        greenTower.g
        ViewManager.mainPane.getChildren().add(greenTower);
    }
}
