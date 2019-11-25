package GameField;

import GameField.Entities.GameEntity;
import GameField.Entities.MovingObjects.Bullet.Bullet;
import GameField.Entities.MovingObjects.Enemy.Enemy;
import GameField.Entities.Tower.Tower;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.text.Normalizer;
import java.util.ArrayList;

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

    public static void printMousePosition() {
        mainPane.setOnMouseMoved(event -> {
            System.out.println("MouseX: " + event.getSceneX());
            System.out.println("MouseY: " + event.getSceneY());
        });
    }

    public static void mouseClicked() {
        mainPane.setOnMouseClicked(event -> {
            spawnTower();
        });
    }

    public static void spawnTower() {
        Tower greenTower = new Tower();
        greenTower.getTowerType(Tower.ObjectType.greenTower);
    }


}
