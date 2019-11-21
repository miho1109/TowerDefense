package GameField;

import GameField.Entities.Button.TowerButton;
import GameField.Entities.Enemy.Enemy;
import GameField.Entities.Enemy.NormalTroop;
import GameField.Entities.GameEntity;
import GameField.Entities.Tower.Tower;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.event.ActionEvent;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.util.Duration;

import java.beans.EventHandler;

import static GameField.ViewManager.mainPane;

public class GameControl {
    public Button button;

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

    static void printMousePosition() {
        mainPane.setOnMouseMoved(event -> {
            System.out.println("MouseX: " + (int) event.getSceneX() / 90);
            System.out.println("MouseY: " + (int) event.getSceneY() / 90);
        });
    }

    public static void mouseClicked() {
        mainPane.setOnMouseClicked(event -> {
            //if((int) event.getSceneX() / 90 == 1)
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
        Tower greenTower = new Tower();
        greenTower.getTowerType(Tower.towerType.greenTower);
    }

    public static void spawnTowerButton() {
        TowerButton TB = new TowerButton();

    }

    public static void drawGrid() {
        Grid grid = new Grid();
    }

}
