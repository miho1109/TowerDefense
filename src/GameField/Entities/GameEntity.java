package GameField.Entities;

import javafx.scene.image.ImageView;

public interface GameEntity {

    public enum ObjectType{
        NormalTroop,
        EliteTroop,
        Tanker,
        Boss,
        normalTower,
        airTower,
        lightTower,
        heavyTower,
        bullet1,
    }

    double getPosX();
    double getPosY();
    double getWidth();
    double getHeight();
}
