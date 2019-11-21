package GameField.Entities.Enemy;

import GameField.ViewManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EliteTroop extends Enemy{
        private double x;
        private double y;
        private double width;
        private double height;
        private double health = 20;
        private int speed = 9500;

        public Image image = new Image("GameField/Entities/Enemy/Resources/eliteTroop.png");
        public ImageView eliteTroop = new ImageView(image);

        public EliteTroop() {
            super();
            eliteTroop.setX(170);
            eliteTroop.setY(720);
            eliteTroop.setPreserveRatio(true);
            Enemy.setPath(eliteTroop,speed);
            ViewManager.mainPane.getChildren().add(eliteTroop);
        }
}
