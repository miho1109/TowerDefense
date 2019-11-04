package GameField;

import GameField.Entities.Enemy.Enemy;
import GameField.Entities.Enemy.NormalTroop;
import GameField.Entities.GameEntity;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.util.Duration;

public class GameControl {
    public static void spawnTroop(){
        Timeline timeline  = new Timeline(new KeyFrame(Duration.millis(1500), event-> {
            Enemy normlaTroop = new Enemy();
            Enemy eliteTroop = new Enemy();
            normlaTroop.getTroopType(Enemy.enemyType.NormalTroop);
            eliteTroop.getTroopType(Enemy.enemyType.EliteTroop);
            //System.out.println(normlaTroop.getPosX());
        }));
        timeline.setCycleCount(5);
        timeline.play();
    }

}
