package GameField.Entities.Enemy;

import GameField.Entities.GameEntity;
import javafx.animation.PathTransition;
import javafx.geometry.Bounds;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Enemy implements GameEntity{



    public Enemy() {}

    public void getTroopType(enemyType type){
        switch (type){
            case NormalTroop:
                new NormalTroop();
            case EliteTroop:
                new EliteTroop();
            case Tanker:
                //new Tanker();
            case Boss:
                //new Boss();
        }
    }

    protected static void setPath(javafx.scene.image.ImageView troop,int speed) {
        Path path = new Path();
        MoveTo moveTo = new MoveTo(170,745);
        LineTo line1 = new LineTo(170, 580);
        LineTo line2 = new LineTo(415,570);
        LineTo line3 = new LineTo(427,80);
        LineTo line4 = new LineTo(669,80);
        LineTo line5 = new LineTo(680,444);
        LineTo line6 = new LineTo(920,444);
        LineTo line7 = new LineTo(933,183);
        LineTo line8 = new LineTo(1288,154);
        path.getElements().add(moveTo);
        path.getElements().addAll(line1,line2,line3,line4,line5,line6,line7,line8);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(speed));
        pathTransition.setNode(troop);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        //pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
    }

    public double getPosX(enemyType type){
        switch (type){
            case NormalTroop:
                new NormalTroop();
            case EliteTroop:
                new EliteTroop();
            case Tanker:
                //new Tanker();
            case Boss:
                //new Boss();
        }
        return 0;
    }

    public double getPosX(objectType otype) {
      return 0;
    }

    public double getPosY(){
        return 0;
    }
    public double getWidth(){
        return 0;
    }
    public double getHeight(){
        return 0;
    }
    public boolean isContaining(double posX, double posY, double width, double height){
        return false;
    }
    public boolean isBeingContained(double posX, double posY, double width, double height){
        return false;
    }
    public boolean isBeingOverlapped(double posX, double posY, double width, double height){
        return false;
    }
}
