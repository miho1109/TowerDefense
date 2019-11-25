package GameField.Entities.MovingObjects.Bullet;

import GameField.Entities.MovingObjects.MovingObjects;
import GameField.ViewManager;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Bullet extends MovingObjects {

    ImageView bullet;
    public Bullet(ObjectType type, double targetX, double targetY){
        Timeline bullettimeline = new Timeline(new KeyFrame(Duration.millis(300), bulletevent-> {
            bullet = new ImageView(new Image("GameField/Entities/MovingObjects/Bullet/Resources/bullet1.png"));
            bullet.setPreserveRatio(true);
            bullet.setX(170);
            bullet.setY(720);
            ViewManager.mainPane.getChildren().add(bullet);
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
        }));
        bullettimeline.setCycleCount(Animation.INDEFINITE);
        bullettimeline.play();
    }

    private void setPath(int speed){

    }



    @Override
    public double getPosX() {
        return 0;
    }

    @Override
    public double getPosY() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }
}
