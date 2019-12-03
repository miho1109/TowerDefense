package GameField;

import GameField.Entities.Button.TowerButton;
import GameField.Entities.GameEntity;
import GameField.Entities.MovingObjects.Enemy.Enemy;
import GameField.Entities.Tower.Tower;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.util.Duration;

import java.util.ArrayList;

import static GameField.ViewManager.mainPane;

public class GameControl {
    private static int lives;

    public static int getLives(){ return lives;}
    public static void setLives(int ulives){ lives = ulives; }
    public static ArrayList<Enemy> EnemyList = new ArrayList<>();
    public static ArrayList<Tower> TowerList = new ArrayList<>();

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
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1200), event -> {
                switch (level){
                    case 1:
                    case 2: {
                        EnemyList.add(new Enemy(GameEntity.ObjectType.normalTroop));
                        break;
                    }
                    case 3:
                    case 4: {
                        //EnemyList.add(new Enemy(GameEntity.ObjectType.NormalTroop));
                        EnemyList.add(new Enemy(GameEntity.ObjectType.eliteTroop));
                        break;
                    }
                    case 5: {
//                        EnemyList.add(new Enemy(GameEntity.ObjectType.NormalTroop));
//                        EnemyList.add(new Enemy(GameEntity.ObjectType.EliteTroop));
                        EnemyList.add(new Enemy(GameEntity.ObjectType.tank));
                        break;
                    }
                    case 6: {
                        EnemyList.add(new Enemy((GameEntity.ObjectType.plane)));
                        break;
                    }
                    case 7:{
                        break;
                    }
                }
            }));
            timeline.setCycleCount(quantities);
            timeline.play();
            timeline.setOnFinished(event -> {
                System.out.println("FINISH");
                timeline.setDelay(Duration.seconds(2));
                spawnTroop(5, quantities + 1, level + 1);
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
    
    public static void drawGrid() {
        Grid grid = new Grid();
    }

    public static void createTestButton() {
        TowerButton TB = new TowerButton();
    }

}
