package GameField.Entities.MovingObjects.Bullet;

import GameField.Entities.GameEntity;
import GameField.ViewManager;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Bullet extends Pane implements GameEntity {

    ImageView bullet;

    public Bullet(ObjectType bulletType, double targetX, double targetY){
            switch(bulletType){
                case lightTower: {
                    loadImage("GameField/Entities/MovingObjects/Bullet/Resources/lightBullet.png");
                    break;
                }
                case heavyTower:{
                    loadImage("GameField/Entities/MovingObjects/Bullet/Resources/heavyBullet.png");
                    break;
                }
                case frozer:{
                    loadImage("GameField/Entities/MovingObjects/Bullet/Resources/frozer.png");
                    break;
                }
                case missle:{
                    loadImage("GameField/Entities/MovingObjects/Bullet/Resources/missle.png");
                    break;
                }
            }
            setPath(targetX, targetY);
            this.getChildren().add(bullet);
            ViewManager.mainPane.getChildren().add(this);
    }

    private void loadImage(String location){
        bullet = new ImageView(new Image(location));
        bullet.setPreserveRatio(true);
        this.setTranslateX(170);
        this.setTranslateY(750);
    }

    private void setPath(double targetX, double targetY){
        Path path = new Path();
        MoveTo moveTo = new MoveTo(50, 600);
        LineTo line1 = new LineTo(targetX, targetY);
        path.getElements().add(moveTo);
        if(targetX >0 && targetY >0)    path.getElements().addAll(line1);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(500));
        pathTransition.setNode(this);
        pathTransition.setPath(path);
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
