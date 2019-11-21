package GameField.Entities;

import javafx.scene.image.ImageView;

public interface GameEntity {

    enum objectType{
        tower, enemy,
    }

    public enum enemyType{
        NormalTroop,
        EliteTroop,
        Tanker,
        Boss,
    }

    public enum towerType{
        greenTower,
    }

    double getPosX(objectType type);
    double getPosY();
    double getWidth();
    double getHeight();



    //boolean isContaining(double posX, double posY, double width, double height);
    //boolean isBeingContained(double posX, double posY, double width, double height);
    //boolean isBeingOverlapped(double posX, double posY, double width, double height);
}
