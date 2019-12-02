package GameField.Entities.MovingObjects.Bullet;

import GameField.Entities.GameEntity;
import GameField.Entities.MovingObjects.MovingObjects;
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
    public Bullet(ObjectType type, double targetX, double targetY){
        Timeline bullettimeline = new Timeline(new KeyFrame(Duration.millis(300), bulletevent-> {
            loadImage("GameField/Entities/MovingObjects/Bullet/Resources/bullet1.png");
            setPath(targetX, targetY);
            //this.getChildren().add(bullet);

        }));
        bullettimeline.setCycleCount(Animation.INDEFINITE);
        bullettimeline.play();
    }

    private void loadImage(String location){
        bullet = new ImageView(new Image(location));
        bullet.setPreserveRatio(true);
        bullet.setTranslateX(170);
        bullet.setTranslateY(720);
        ViewManager.mainPane.getChildren().add(this);
    }
    private void setPath(double targetX, double targetY){
        Path path = new Path();
        MoveTo moveTo = new MoveTo(50, 600);
        LineTo line1 = new LineTo(targetX, targetY);
        path.getElements().add(moveTo);
        if(targetX >0 && targetY >0)    path.getElements().addAll(line1);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(500));
        pathTransition.setNode(bullet);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setAutoReverse(false);
        pathTransition.setOnFinished(actonEvent ->{
            ViewManager.mainPane.getChildren().remove(bullet);
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
