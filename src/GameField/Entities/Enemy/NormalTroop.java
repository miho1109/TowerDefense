package GameField.Entities.Enemy;

import GameField.ViewManager;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NormalTroop extends Enemy{
    private double x ;
    private double y ;
    private double width;
    private double height;
    private double health = 20;
    private int speed = 10000;
    public Bounds troopBound;

    public Image image = new Image("GameField/Entities/Enemy/Resources/normalTroop.png");
    public ImageView normalTroop = new ImageView(image);

    public NormalTroop() {
        super();
        normalTroop.setX(170);
        normalTroop.setY(720);
        normalTroop.setPreserveRatio(true);
        troopBound = normalTroop.localToScene(normalTroop.getBoundsInLocal());
        Enemy.setPath(normalTroop,speed);
        ViewManager.mainPane.getChildren().add(normalTroop);
    }

}

