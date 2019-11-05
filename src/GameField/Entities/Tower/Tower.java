package GameField.Entities.Tower;

import GameField.Entities.GameEntity;

import static GameField.ViewManager.mainPane;

public class Tower implements GameEntity {

    public Tower() {}

    public void getTowerType(towerType type){
        switch (type){
            case greenTower:
                new greenTower();
        }
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

    public double getWidth() {
        return 0;
    }

    public double getHeight() {
        return 0;
    }

    void printMousePosition() {
        mainPane.setOnMouseMoved(event -> {
            System.out.println("MouseX: " + event.getSceneX());
            System.out.println("MouseY: " + event.getSceneY());
        });
    }

}
