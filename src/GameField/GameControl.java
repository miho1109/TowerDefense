package GameField;

import GameField.Entities.Button.TowerButton;
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

    public static ArrayList<Enemy> EnemyList = new ArrayList<>(1);

    public static void spawnTroop(){
        Timeline timeline  = new Timeline(new KeyFrame(Duration.millis(1500), event-> {
            Enemy normalTroop = new Enemy(GameEntity.ObjectType.NormalTroop);
            //Enemy eliteTroop = new Enemy(GameEntity.ObjectType.EliteTroop);
            EnemyList.add(normalTroop);
            /* Bullet ------------------------------------------------------------------------------- */

            for(Enemy e:EnemyList) {
                if(e != null ) {
                    Bullet bullet = new Bullet(GameEntity.ObjectType.bullet1, e.getPosX(), e.getPosX());
                }
            }

            /*----------------------------------------------------------------------------------------*/
        }));
        timeline.setCycleCount(5);
        timeline.play();
    }

    public static void printTroopX(){
        Timeline timeline  = new Timeline(new KeyFrame(Duration.millis(500), event-> {
            if(EnemyList.get(0) != null){
                System.out.println(EnemyList.get(2).getPosX());
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    static void printMousePosition() {
        mainPane.setOnMouseMoved(event -> {
            System.out.println("MouseX: " + (int) event.getSceneX() / 90);
            System.out.println("MouseY: " + (int) event.getSceneY() / 90);
        });
    }

    public static void mouseClicked() {
        mainPane.setOnMouseClicked(event -> {
            if((int) event.getSceneY() / 90 == 7)
            spawnTower();
        });
    }
    /**
    public static void createButton() {
        Button button = new Button();
        mainPane.button1.setOnAction(new EventHandler<ActionEvent>() ) {
            @Override public void handle(ActionEvent e) {

                                        }
    }
    }
    */
    public static void spawnTower() {
        Tower greenTower = new Tower(GameEntity.ObjectType.normalTower);
    }

    public static void spawnTowerButton() {
        //TowerButton TB = new TowerButton();
    }

    public static void drawGrid() {
        Grid grid = new Grid();
    }

}
