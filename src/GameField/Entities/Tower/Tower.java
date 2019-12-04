package GameField.Entities.Tower;

import GameField.Entities.GameEntity;
import GameField.Entities.MovingObjects.Bullet.Bullet;
import GameField.Entities.MovingObjects.Enemy.Enemy;
import GameField.GameControl;
import GameField.Grid;
import GameField.ViewManager;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


import static GameField.ViewManager.mainPane;

public class Tower extends Pane implements GameEntity {
    protected ImageView TowerImage;
    public ObjectType currentType;

    private double x;
    private double y;
    private double width;
    private double height;
    private double fireRate;
    private double damage;
    private boolean dragAble = true;
    private double shootRange;

    Circle towerRange = new Circle();

    public ObjectType getTowerType(){ return currentType; }

    public Tower(ObjectType type) {
        loadTowerImage(type);
        currentType = type;
        dragTower();
        towerRange.setRadius(shootRange);
        towerRange.setFill(Color.TRANSPARENT);
        towerRange.setCenterX(2000);
        towerRange.setCenterY(50);
        towerRange.setStroke(Color.RED);
        ViewManager.mainPane.getChildren().add(TowerImage);
        ViewManager.mainPane.getChildren().add(towerRange);
    }

    private void loadTowerImage(ObjectType type) {
        switch (type) {
            case frozer:
                loadImage("file:src/GameField/Entities/Tower/Resources/frozer.png");
                TowerImage.setX(1300);
                TowerImage.setY(0);
                shootRange = 90;
                break;

            case missle:
                loadImage("file:src/GameField/Entities/Enemy/Resources/airTower.png");
                TowerImage.setX(1400);
                TowerImage.setY(0);
                shootRange = 130;
                break;

            case lightTower:
                loadImage("file:src/GameField/Entities/Tower/Resources/lightTower.png");
                TowerImage.setX(1300);
                TowerImage.setY(140);
                shootRange = 170;
                break;

            case heavyTower:
                loadImage("file:src/GameField/Entities/Tower/Resources/heavyTower.png");
                TowerImage.setX(1400);
                TowerImage.setY(140);
                shootRange = 100;
                break;
        }
        this.getChildren().add(TowerImage);
        mainPane.getChildren().add(this);
    }

    private void loadImage(String location) {
        TowerImage = new ImageView(new Image(location));
    }

    public void clearImage() {
        ViewManager.mainPane.getChildren().remove(TowerImage);
        TowerImage = null;
    }

    private boolean spawnAble(double x, double y) {
        int i = (int) y / 90;
        int j = (int) x / 90;
        return Grid.newGrid[i][j] == 1;
    }

    private void dragTower() {

        mainPane.setOnMouseMoved(event -> {
            if (dragAble) {
                TowerImage.setX(event.getSceneX() - 45);
                TowerImage.setY(event.getSceneY() - 50);
                towerRange.setCenterX(TowerImage.getX()+45);
                towerRange.setCenterY(TowerImage.getY()+45);
                towerRange.setVisible(true);
            }
        });

        mainPane.setOnMouseReleased(event -> {
            if ((spawnAble(event.getSceneX(), event.getSceneY())) && (dragAble)) {
                TowerImage.setX(((int) (event.getSceneX() / 90) * 90));
                TowerImage.setY(((int) (event.getSceneY() / 90) * 90));
                towerRange.setCenterX(TowerImage.getX()+45);
                towerRange.setCenterY(TowerImage.getY()+45);
                towerRange.setVisible(false);
                /*
                int i = (int)(event.getSceneY() / 90) * 90;
                int j = (int)(event.getSceneX() / 90) * 90;
                Grid.newGrid[i][j] = 0;
                 */
                dragAble = false;
            }
        });

    }

    void collisionHandle(){
           Timeline collide = new Timeline(new KeyFrame(Duration.seconds(300), event -> {
               for(Enemy enemy: GameControl.EnemyList){
                 if(enemy.getBound().intersects(towerRange.getBoundsInParent())){
                     mainPane.getChildren().add(new Bullet(getTowerType(),getPosX(), getPosY(), enemy.getPosX(), enemy.getPosY()));
                 }
               }
           }));
           collide.setCycleCount(Animation.INDEFINITE);
           collide.play();
    }

    public double getPosX() {
        return TowerImage.getTranslateX();
    }

    public double getPosY() { return TowerImage.getTranslateY(); }

    public double getW() {
        return 0;
    }

    public double getH() {
        return 0;
    }

}
