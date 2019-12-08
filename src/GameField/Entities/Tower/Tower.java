package GameField.Entities.Tower;

import GameField.*;
import GameField.Entities.Button.SellButton;
import GameField.Entities.Button.TowerButton;
import GameField.Entities.GameEntity;
import GameField.Entities.MovingObjects.Bullet.Bullet;
import GameField.Entities.MovingObjects.Enemy.Enemy;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;


import static GameField.ViewManager.mainPane;

public class Tower extends Pane implements GameEntity {

    private ImageView TowerImage;
    private Circle towerRange;

    public ObjectType currentType;

    private int fireRate;
    private boolean dragAble = true;
    private boolean towerExist = false;
    private double shootRange = 0;
    private double angle = 0 ;
    private boolean placedTower = false;
    private static double damage;
    private static int cost;
    private static int upgradeCost;

    public boolean isSelected = false;
    public static boolean spawnedTower = false;
    public static void setUpgradeCost(int upgradeCost){ Tower.upgradeCost = upgradeCost; }
    public static void setCost(int cost){ Tower.cost = cost; }
    public static int getUpgradeCost(){ return upgradeCost; }
    public static int getCost() { return cost; }
    public static double getDamage() { return damage; }

    public ObjectType getTowerType(){ return currentType; }

    public Tower(ObjectType type) {
        loadTowerImage(type);
        towerRange = new Circle(2000, 50, shootRange);
        currentType = type;
        towerRange.setFill(Color.TRANSPARENT);
        towerRange.setStroke(Color.RED);
        dragTower();
        towerRange.setViewOrder(-1);
        this.getChildren().addAll(TowerImage, towerRange);
        ViewManager.mainPane.getChildren().add(towerRange);
        ViewManager.mainPane.getChildren().add(TowerImage);
        resetStats();
        chooseTower();

    }

    private void loadTowerImage(ObjectType type) {
        switch (type) {
            case frozer:
                loadImage("file:src/GameField/Entities/Tower/Resources/frozer.png");
                TowerImage.setX(1300);
                TowerImage.setY(0);
                shootRange = 90;
                fireRate = 250;
                damage = 1;
                cost = 50;
                upgradeCost = 25;
                break;

            case launcher:
                loadImage("file:src/GameField/Entities/Tower/Resources/airTower.png");
                TowerImage.setX(1400);
                TowerImage.setY(0);
                shootRange = 130;
                fireRate = 500;
                damage = 0.4;
                cost = 40;
                upgradeCost = 20;
                break;

            case lightTower:
                loadImage("file:src/GameField/Entities/Tower/Resources/lightTower.png");
                TowerImage.setX(1300);
                TowerImage.setY(140);
                shootRange = 140;
                fireRate = 200;
                damage = 0.1;
                cost = 10;
                upgradeCost = 5;
                break;

            case heavyTower:
                loadImage("file:src/GameField/Entities/Tower/Resources/heavyTower.png");
                TowerImage.setX(1400);
                TowerImage.setY(140);
                shootRange = 100;
                fireRate = 300;
                damage = 0.17;
                cost = 20;
                upgradeCost = 10;
                break;
        }
        TowerImage.setViewOrder(-2);
    }

    private void loadImage(String location) {
        TowerImage = new ImageView(new Image(location));
    }

    public void clearTower() {
        int i = (int) TowerImage.getY() / 90;
        int j = (int) TowerImage.getX() / 90;
        Grid.newGrid[i][j] = 1;
        ViewManager.mainPane.getChildren().remove(TowerImage);
        ViewManager.mainPane.getChildren().remove(towerRange);
        TowerImage = null;
        towerRange = null;
    }

    private boolean spawnAble(double x, double y) {
        int i = (int) y / 90;
        int j = (int) x / 90;
        return Grid.newGrid[i][j] == 1;
    }

    private void chooseTower() {

        TowerImage.setOnMouseReleased(event -> {
           for(int i = 0; i < GameControl.TowerList.size(); i++) {
               GameControl.TowerList.get(i).isSelected = false;
           }
            isSelected = true;
            TowerStats.updateTowerStats(this);
        });

        TowerImage.setOnMouseEntered(event -> {
            TowerImage.setEffect(new Glow());
            towerRange.setVisible(true);
            TowerStats.enableTowerStats();
        });
        TowerImage.setOnMouseExited(event -> {
            TowerImage.setEffect(null);
            towerRange.setVisible(false);
            TowerStats.disableTowerStats();
        });
    }

    private void resetStats() {
        for (int i = 1; i < GameControl.TowerList.size(); i++) {
            GameControl.TowerList.get(i).isSelected = false;
        }
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

        TowerImage.setOnMouseClicked(event -> {
            if ((spawnAble(event.getSceneX(), event.getSceneY())) && (dragAble)) {
                int i = ((int) (event.getSceneX() / 90) * 90);
                int j = ((int) (event.getSceneY() / 90) * 90);
                TowerImage.setX(i);
                TowerImage.setY(j);
                towerRange.setCenterX(TowerImage.getX()+45);
                towerRange.setCenterY(TowerImage.getY()+45);
                towerRange.setVisible(false);
                dragAble = false;
                spawnedTower = false;
                towerExist = true;
                placedTower = true;
                TowerButton.disableGrid();
                Grid.newGrid[j / 90][i / 90] = 0;
                collisionHandle(getTowerType(), fireRate);
            }
        });

    }

    private int lengthCaculate(Enemy e){ return (int)Math.sqrt(Math.pow(towerRange.getCenterX()-e.getPosX(),2) + Math.pow(towerRange.getCenterY()-e.getPosY(),2)); }

    private double calculateAngle(Point2D a, Point2D b) { return 180 - Math.toDegrees(Math.atan2(a.getX() - b.getX(), a.getY() - b.getY())); }

    private void rotateTower(Enemy e){
        Point2D a = new Point2D(e.getPosX(), e.getPosY());
        Point2D b = new Point2D(getPosX(), getPosY());
        double nangle = calculateAngle(a,b);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.5), TowerImage);
        rotateTransition.setFromAngle(angle);
        rotateTransition.setToAngle(nangle);
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
        angle = nangle;
    }

    private void collisionHandle(ObjectType type, int fireRate){
        Timeline collide = new Timeline(new KeyFrame(Duration.millis(fireRate), event -> {
            if(towerExist && !GameControl.EnemyList.isEmpty()) {
                for (int i=0; i<GameControl.EnemyList.size(); i++) {
                    if (towerRange != null && GameControl.EnemyList.get(i).getBound().intersects(towerRange.getBoundsInParent()) && !GameControl.EnemyList.get(i).checkEnemyImage()){
                        if (GameControl.EnemyList.get(i).getEnemyMovingMethod() == ObjectType.inAir && getTowerType()!=ObjectType.launcher){
                            break;
                        }else if(GameControl.EnemyList.get(i).getEnemyMovingMethod() != ObjectType.inAir && getTowerType()==ObjectType.launcher){

                            break;
                        }
                        rotateTower(GameControl.EnemyList.get(i));
                        new Bullet(GameControl.EnemyList.get(i), getTowerType(), getPosX() + 45, getPosY() + 45,
                            GameControl.EnemyList.get(i).getPosX() + GameControl.EnemyList.get(i).getW() / 2,
                            GameControl.EnemyList.get(i).getPosY() + GameControl.EnemyList.get(i).getH() / 2);
                        break;
                    }
                }
            }
    }));
        collide.setCycleCount(Animation.INDEFINITE);
        collide.play();
    }

    public void upgradeTower() {
        shootRange += 10;
        towerRange.setRadius(shootRange);
        damage *= 1.2;
        cost += upgradeCost;
    }

    public double getPosX() { return TowerImage.getX(); }

    public double getPosY() { return TowerImage.getY(); }

    public double getW() { return this.getWidth(); }

    public double getH() {
        return this.getHeight();
    }

}
