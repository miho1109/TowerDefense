package GameField.Entities;

import javafx.scene.image.ImageView;

public interface GameEntity {

     enum ObjectType{
        OnGround,
        InAir,
        NormalTroop,
        EliteTroop,
        Tank,
        Plane,
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
