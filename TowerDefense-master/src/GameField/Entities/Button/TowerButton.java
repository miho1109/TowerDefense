package GameField.Entities.Button;

import GameField.Entities.GameEntity;
import GameField.Entities.Tower.greenTower;
import GameField.GameControl;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;

import static GameField.ViewManager.mainPane;

public class TowerButton extends Button implements GameEntity {

    public TowerButton() {
        //action();
        //pressButton();
    }

    DropShadow shadow = new DropShadow();

    public void getTowerType(towerType type){
        switch (type){
            case greenTower:
                new greenTower();
        }
    }

    public void action()  {
        mainPane.setOnMouseDragOver(event ->  {
            this.setEffect(shadow);
        } );
    }

    public void pressButton() {
        mainPane.setOnMouseClicked(event -> {
            GameControl.spawnTower();
        });
    }

    public double getPosX(towerType type){
        switch (type){
            case greenTower:
                new greenTower();
        }
        return 0;
    }

    public double getPosX(objectType type) {
        return 0;
    }

    public double getPosY() {
        return 0;
    }

}
