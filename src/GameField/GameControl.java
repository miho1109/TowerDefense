package GameField;

import GameField.Entities.Button.TowerButton;
import GameField.Entities.Button.testingButton;
import GameField.Entities.GameEntity;
import GameField.Entities.MovingObjects.Bullet.Bullet;
import GameField.Entities.MovingObjects.Enemy.Enemy;
import GameField.Entities.Tower.Tower;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.util.Duration;

import java.util.ArrayList;
import javafx.scene.control.Button;

import static GameField.ViewManager.mainPane;

public class GameControl {
    private static int lives;

    public static int getLives(){ return lives;}
    public static void setLives(int ulives){ lives = ulives; }
    public static ArrayList<Enemy> EnemyList = new ArrayList<>(1);

    public static void gameStart(){
        lives = 5;
        while (lives > 0 ) {
            spawnTroop(5,5,1);
            for(Enemy e: EnemyList){
                if(e.checkTroopSurvive()){
                    lives--;
                }
            }
        }
        System.out.println("YOU LOSE !");
    }

    public static void spawnTroop(int lives, int quantities, int level){
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1500), event -> {
                switch (level){
                    case 1:
                        EnemyList.add( new Enemy(GameEntity.ObjectType.NormalTroop));
                        break;
                    case 2:
                        System.out.println("lv2");
                        EnemyList.add(new Enemy(GameEntity.ObjectType.NormalTroop));
                        EnemyList.add(new Enemy(GameEntity.ObjectType.EliteTroop));
                        break;
                    case 3:
                        System.out.println("lv3");
                        EnemyList.add(new Enemy(GameEntity.ObjectType.NormalTroop));
                        EnemyList.add(new Enemy(GameEntity.ObjectType.EliteTroop));
                        EnemyList.add(new Enemy(GameEntity.ObjectType.Tank));
                        break;
                    case 4:
                        System.out.println("lv4");
                        break;
                }
            }));
            timeline.setCycleCount(quantities);
            timeline.play();
            timeline.setOnFinished(event -> {
                System.out.println("FINISH");
                timeline.setDelay(Duration.seconds(2));
                spawnTroop(5, quantities +2, level + 1);
            });

    }

    void checkCollision(){

    }

    public static void printTroopX() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> {
            if (EnemyList.get(0) != null) {
                System.out.println(EnemyList.get(0).getPosX());
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    static void printMousePosition() {
        mainPane.setOnMouseMoved(event -> {
            System.out.println("MouseX: " + (int) event.getSceneX() );
            System.out.println("MouseY: " + (int) event.getSceneY() );
        });
    }

    public static void mouseClicked() {
        mainPane.setOnMouseClicked(event -> {
            if((int) event.getSceneY() / 90 == 7)
            spawnTowerButton();
        });
    }

    public static void spawnTower() {
        Tower normalTower = new Tower(GameEntity.ObjectType.normalTower);
    }

    public static void spawnTowerButton() {
        TowerButton normalTower = new TowerButton(new Tower(GameEntity.ObjectType.normalTower));
        //normalTower.setTranslateX(250);
        //normalTower.setTranslateY(250);
        //TowerButton airTower = new TowerButton(new Tower(GameEntity.ObjectType.airTower));
        //TowerButton lightTower = new TowerButton(new Tower(GameEntity.ObjectType.lightTower));
        //TowerButton heavyTower = new TowerButton(new Tower(GameEntity.ObjectType.heavyTower));
    }

    public static void drawGrid() {
        Grid grid = new Grid();
    }

    public static void createTestButton() {
        testingButton TB = new testingButton();
    }

}
