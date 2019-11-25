package GameField.Entities.MovingObjects;

import GameField.Entities.GameEntity;
import GameField.ViewManager;
import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public abstract class MovingObjects implements GameEntity {

    protected ImageView EnemyImage;

    protected void setPath(int speed, MoveTo moveTo, LineTo line1, LineTo line2,LineTo line3,LineTo line4,LineTo line5,LineTo line6, LineTo line7,LineTo line8 ){
        Path path = new Path();
        path.getElements().add(moveTo);
        path.getElements().addAll(line1,line2,line3,line4,line5,line6,line7,line8);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(speed));
        pathTransition.setNode(EnemyImage);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setAutoReverse(false);
        pathTransition.setOnFinished(actonEvent ->{
            terminated();
        });
        pathTransition.play();
    }

    void terminated(){
        ViewManager.mainPane.getChildren().remove(EnemyImage);
        EnemyImage = null;
    }
}
