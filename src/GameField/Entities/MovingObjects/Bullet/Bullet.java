package GameField.Entities.MovingObjects.Bullet;

import GameField.Entities.GameEntity;
import GameField.Entities.MovingObjects.Enemy.Enemy;
import GameField.ViewManager;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import javafx.util.Duration;

public class Bullet extends Pane implements GameEntity {

    private ImageView bulletImage;
    private int speed;
    private double damage;

    public Bullet(Enemy e, ObjectType towerType, double spawnX, double spawnY, double targetX, double targetY){
            switch(towerType){
                case lightTower: {
                    loadImage("file:src/GameField/Entities/MovingObjects/Bullet/Resources/lightBullet.png");
                    speed = 300;
                    damage = 0.1;
                    break;
                }
                case heavyTower:{
                    loadImage("file:src/GameField/Entities/MovingObjects/Bullet/Resources/heavyBullet.png");
                    speed = 350;
                    damage = 0.2;
                    break;
                }
                case frozer:{
                    loadImage("file:src/GameField/Entities/MovingObjects/Bullet/Resources/frozer.png");
                    speed = 300;
                    damage = 2;
                    break;
                }
                case launcher:{
                    loadImage("file:src/GameField/Entities/MovingObjects/Bullet/Resources/missle.png");
                    speed = 350;
                    damage = 0.5;
                    break;
                }
            }
            bulletImage.setViewOrder(2);
            this.getChildren().add(bulletImage);
            setPath(e, speed, spawnX, spawnY, targetX, targetY);
            ViewManager.mainPane.getChildren().add(this);
    }

    private void loadImage(String location){
        bulletImage = new ImageView(new Image(location));
        bulletImage.setPreserveRatio(true);
        this.setTranslateX(170);
        this.setTranslateY(750);
    }

    private void setPath(Enemy e, int speed, double spawnX, double spawnY, double targetX, double targetY){
        Line line = new Line();
        line.setStartX(spawnX);       line.setEndX(targetX);
        line.setStartY(spawnY);       line.setEndY(targetY);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(300));
        pathTransition.setNode(this);
        pathTransition.setPath(line);
        pathTransition.setCycleCount(1);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setAutoReverse(false);
        pathTransition.setOnFinished(actonEvent ->{
            ViewManager.mainPane.getChildren().remove(this);
            bulletImage = null;
            if(e != null) e.subtractHealth(e.getHealth()-damage);
        });
        pathTransition.play();
    }

    public double getPosX() {
        return this.getTranslateX();
    }

    public double getPosY() {
        return this.getTranslateY();
    }

    public double getW() {
        return 0;
    }

    public double getH() {
        return 0;
    }
}
