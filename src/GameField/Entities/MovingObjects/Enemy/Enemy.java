package GameField.Entities.MovingObjects.Enemy;

import GameField.Entities.GameEntity;
import GameField.GameControl;
import GameField.PlayerIndex;
import GameField.ViewManager;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.io.File;
import java.security.Key;

public class Enemy extends Pane implements GameEntity {

    private ImageView EnemyImage;
    private ObjectType currentType;
    private boolean survive = false;
    private ProgressBar healthBar;
    private double health;
    private int earn =0;

    MoveTo moveTo = new MoveTo(170,750);
    LineTo line1 = new LineTo(170, 550);
    LineTo line2 = new LineTo(440,550);
    LineTo line3 = new LineTo(440,100);
    LineTo line4 = new LineTo(720,100);
    LineTo line5 = new LineTo(720,444);
    LineTo line6 = new LineTo(980,444);
    LineTo line7 = new LineTo(980,190);
    LineTo line8 = new LineTo(1320,180);

    public ObjectType getEnemyType(){ return currentType; }
    public boolean checkEnemyImage(){ return EnemyImage==null; }
    public double getHealth(){ if(healthBar != null) {return healthBar.getProgress();}
    return 0;}
    public void subtractHealth(double health){ healthBar.setProgress(health); }

    public Enemy(ObjectType type) {
        currentType = type;
        switch (type){
            case normalTroop:
                loadImage("file:src/GameField/Entities/MovingObjects/Enemy/Resources/normalTroop.png");
                generateHealthBar(ObjectType.normalTroop, 1);
                setPath(20000, GameEntity.ObjectType.onGround);
                earn = 2;
                break;
            case eliteTroop:
                loadImage("file:src/GameField/Entities/MovingObjects/Enemy/Resources/eliteTroop.png");
                generateHealthBar(ObjectType.eliteTroop, 1);
                setPath(15000, GameEntity.ObjectType.onGround);
                earn = 4;
                break;
            case tank:
                loadImage("file:src/GameField/Entities/MovingObjects/Enemy/Resources/tanker.png");
                generateHealthBar(ObjectType.tank, 1);
                setPath(40000, GameEntity.ObjectType.onGround);
                earn = 7;
                break;
            case plane:
                loadImage("file:src/GameField/Entities/MovingObjects/Enemy/Resources/plane1.png");
                generateHealthBar(ObjectType.plane,1);
                setPath(13000, ObjectType.inAir);
                earn = 5;
                break;
        }
        this.getChildren().addAll(EnemyImage);
        EnemyImage.setViewOrder(-1);
        terminator();
        ViewManager.mainPane.getChildren().add(this);
    }


    void generateHealthBar(ObjectType type, double health){
        this.health = health;
        healthBar = new ProgressBar(health);
        healthBar.setPrefSize(35,9);
        healthBar.setStyle("-fx-accent: red;");
        healthBar.setViewOrder(-2);
        healthBar.setTranslateX(35);
        healthBar.setTranslateY(59);
        healthBar.setRotate(90);
        this.getChildren().add(healthBar);
    }

    private void setPath(int speed, ObjectType type){
            Path path = new Path();
            path.getElements().add(moveTo);
            switch (type){
                case onGround:
                    path.getElements().addAll(line1, line2, line3, line4, line5, line6, line7, line8);
                    break;
                case inAir:
                    path.getElements().addAll(line3, line5, line8);
                    break;
            }
            PathTransition pathTransition = new PathTransition();
            pathTransition.setDuration(Duration.millis(speed));
            pathTransition.setNode(this);
            pathTransition.setPath(path);
            pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            pathTransition.setAutoReverse(false);
            pathTransition.setOnFinished(actonEvent -> {
                terminated();
                PlayerIndex.setLives(PlayerIndex.getLives() - 1);
                PlayerIndex.updatePlayerIndex();
                });
            pathTransition.play();
    }

    private void terminated(){
        ViewManager.mainPane.getChildren().remove(this);
        EnemyImage = null;
        healthBar = null;
    }

    private void terminator(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100),event ->{
            if(healthBar != null && healthBar.getProgress() <= 0) {
                terminated();
                PlayerIndex.setCoin(PlayerIndex.getCoin() + earn);
                //PlayerIndex.updatePlayerIndex();
            }
        }));timeline.stop();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public boolean checkTroopSurvive(){
        return this.survive;
    }

    private void loadImage(String location){
        File test = new File(location);
        EnemyImage = new ImageView(new Image(location));
        EnemyImage.setPreserveRatio(true);
        this.setTranslateX(170);
        this.setTranslateY(750);
    }

    public Bounds getBound() { return this.getBoundsInParent(); }

    public double getPosX() { return this.getTranslateX(); }

    public double getPosY(){ return this.getTranslateY(); }

    public double getW() { return this.getWidth(); }

    public double getH() { return this.getHeight(); }
}
