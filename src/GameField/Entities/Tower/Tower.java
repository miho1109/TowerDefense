package GameField.Entities.Tower;

import GameField.Entities.GameEntity;

public class Tower implements GameEntity {

    public Tower() {}

    public void getTowerType(ObjectType type){
        switch (type){
            case greenTower:
                new greenTower();
        }
    }

    public double getPosX(ObjectType type){
        switch (type){
            case greenTower:
                new greenTower();
        }
        return 0;
    }

    public double getPosX() {
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

}
