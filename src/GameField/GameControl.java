package GameField;

import GameField.Entities.Enemy.Enemy;
import GameField.Entities.Enemy.NormalTroop;
import GameField.Entities.GameEntity;
import GameField.Entities.Tower.Tower;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.util.Duration;

import static GameField.ViewManager.mainPane;

public class GameControl {
    public static void spawnTroop(){
        Timeline timeline  = new Timeline(new KeyFrame(Duration.millis(1500), event-> {
            Enemy normalTroop = new Enemy();
            Enemy eliteTroop = new Enemy();
            normalTroop.getTroopType(Enemy.enemyType.NormalTroop);
            eliteTroop.getTroopType(Enemy.enemyType.EliteTroop);
            //System.out.println(normalTroop.getPosX());

        }));

        timeline.setCycleCount(5);
        timeline.play();
    }

    void printMousePosition() {
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
        greenTower.getTowerType(Tower.towerType.greenTower);
    }


}
