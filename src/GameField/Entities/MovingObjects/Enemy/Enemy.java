package GameField.Entities.MovingObjects.Enemy;

import GameField.Entities.GameEntity;
import GameField.GameControl;
import GameField.ViewManager;
import javafx.animation.PathTransition;
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

public class Enemy extends Pane implements GameEntity {

    private ImageView EnemyImage;
    private ObjectType currentType;
    private boolean survive = false;
    private ProgressBar healthBar;
    private double health;

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

    public Enemy(ObjectType type) {
        currentType = type;
        switch (type){
            case normalTroop:
                loadImage("file:src/GameField/Entities/MovingObjects/Enemy/Resources/normalTroop.png");
                setPath(20000, GameEntity.ObjectType.onGround);
                generateHealthBar(ObjectType.normalTroop, 10);
                break;
            case eliteTroop:
                loadImage("file:src/GameField/Entities/MovingObjects/Enemy/Resources/eliteTroop.png");
                setPath(15000, GameEntity.ObjectType.onGround);
                generateHealthBar(ObjectType.eliteTroop, 15);
                break;
            case tank:
                loadImage("file:src/GameField/Entities/MovingObjects/Enemy/Resources/tanker.png");
                setPath(40000, GameEntity.ObjectType.onGround);
                generateHealthBar(ObjectType.tank, 40);
                break;
            case plane:
                loadImage("file:src/GameField/Entities/MovingObjects/Enemy/Resources/plane1.png");
                setPath(13000, ObjectType.inAir);
                generateHealthBar(ObjectType.plane,5);
                break;
        }
        this.getChildren().addAll(EnemyImage);
        EnemyImage.setViewOrder(-1);
        ViewManager.mainPane.getChildren().add(this);
    }

    public double getHealth(){ return health; }
    public void subtractHealth(double health){ healthBar.setProgress(health); }

    void generateHealthBar(ObjectType type, double health){
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
            });
            pathTransition.play();
    }

    private void terminated(){
        ViewManager.mainPane.getChildren().remove(this);
        EnemyImage = null;
        GameControl.setLives(GameControl.getLives()-1);
        this.survive = true;
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

    public double getW() { return 0; }

    public double getH() { return 0; }
}
