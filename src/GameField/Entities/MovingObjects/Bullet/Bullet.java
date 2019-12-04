package GameField.Entities.MovingObjects.Bullet;

import GameField.Entities.GameEntity;
import GameField.Entities.MovingObjects.Enemy.Enemy;
import GameField.ViewManager;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Bullet extends Pane implements GameEntity {

    ImageView bullet;

    public Bullet(ObjectType bulletType, double spawnX, double spawnY, double targetX, double targetY){
            switch(bulletType){
                case lightTower: {
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> {
                        loadImage("GameField/Entities/MovingObjects/Bullet/Resources/lightBullet.png");
                    }));
                    timeline.setCycleCount(Animation.INDEFINITE);
                    timeline.play();
                    break;
                }
                case heavyTower:{
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> {
                        loadImage("GameField/Entities/MovingObjects/Bullet/Resources/heavyBullet.png");
                    }));
                    timeline.setCycleCount(Animation.INDEFINITE);
                    timeline.play();
                    break;
                }
                case frozer:{
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> {
                        loadImage("GameField/Entities/MovingObjects/Bullet/Resources/frozer.png");
                    }));
                    timeline.setCycleCount(Animation.INDEFINITE);
                    timeline.play();
                    break;
                }
                case missle:{
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> {
                        loadImage("GameField/Entities/MovingObjects/Bullet/Resources/missle.png");
                    }));
                    timeline.setCycleCount(Animation.INDEFINITE);
                    timeline.play();
                    break;
                }
            }
            setPath(spawnX, spawnY, targetX, targetY);
            this.getChildren().add(bullet);
    }

    private void loadImage(String location){
        bullet = new ImageView(new Image(location));
        bullet.setPreserveRatio(true);
        this.setTranslateX(170);
        this.setTranslateY(750);
    }

    private void setPath(double spawnX, double spawnY, double targetX, double targetY){
        Line line = new Line();
        line.setStartX(spawnX);       line.setEndX(targetX);
        line.setStartY(spawnY);       line.setEndY(targetY);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(500));
        pathTransition.setNode(this);
        pathTransition.setPath(line);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setAutoReverse(false);
        pathTransition.setOnFinished(actonEvent ->{
            ViewManager.mainPane.getChildren().remove(this);
            bullet = null;
        });
        pathTransition.play();
    }

    public double getPosX() {
        return bullet.getTranslateX();
    }

    public double getPosY() {
        return bullet.getTranslateY();
    }

    public double getW() {
        return 0;
    }

    public double getH() {
        return 0;
    }
}
