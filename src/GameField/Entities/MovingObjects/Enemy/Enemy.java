package GameField.Entities.MovingObjects.Enemy;

import GameField.Entities.GameEntity;
import GameField.Entities.MovingObjects.MovingObjects;
import GameField.GameControl;
import GameField.ViewManager;
import javafx.animation.PathTransition;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.io.File;

public class Enemy extends Pane implements GameEntity {

    private ImageView EnemyImage;
    private boolean survive = false;

    MoveTo moveTo = new MoveTo(170,730);
    LineTo line1 = new LineTo(170, 550);
    LineTo line2 = new LineTo(440,550);
    LineTo line3 = new LineTo(440,100);
    LineTo line4 = new LineTo(720,100);
    LineTo line5 = new LineTo(720,444);
    LineTo line6 = new LineTo(980,444);
    LineTo line7 = new LineTo(980,190);
    LineTo line8 = new LineTo(1350,170);

    public Enemy(ObjectType type) {
        switch (type){
            case NormalTroop:
                loadImage("GameField/Entities/MovingObjects/Enemy/Resources/normalTroop.png");
                setPath(15000);
                break;
            case EliteTroop:
                loadImage("GameField/Entities/MovingObjects/Enemy/Resources/eliteTroop.png");
                setPath(13500);
                break;
            case Tank:
                loadImage("GameField/Entities/MovingObjects/Enemy/Resources/tank.png");
                setPath(20000);
                break;
            case Boss:
                //new Boss();
        }
        this.getChildren().add(EnemyImage);
        ViewManager.mainPane.getChildren().add(EnemyImage);
    }

    private void setPath(int speed){
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

    private void terminated(){
        ViewManager.mainPane.getChildren().remove(EnemyImage);
        EnemyImage = null;
        GameControl.setLives(GameControl.getLives()-1);
        this.survive = true;
    }

    public boolean checkTroopSurvive(){
        return this.survive;
    }

    private void loadImage(String location){
        EnemyImage = new ImageView(new Image(location));
        EnemyImage.setPreserveRatio(true);
        EnemyImage.setTranslateX(150);
        EnemyImage.setTranslateY(716);
    }

    public Bounds getBound() { return EnemyImage.getBoundsInParent(); }

    public double getPosX() {
        return EnemyImage.getTranslateX();
    }

    public double getPosY(){
        return EnemyImage.getTranslateY();
    }

    public double getW() {
        return 0;
    }

    public double getH() {
        return 0;
    }

}
