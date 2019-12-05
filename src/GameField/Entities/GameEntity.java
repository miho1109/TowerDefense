package GameField.Entities;

import javafx.scene.image.ImageView;

public interface GameEntity {

     enum ObjectType{
         onGround,
         inAir,
         normalTroop,
         eliteTroop,
         tank,
         plane,
         frozer,
         launcher,
         lightTower,
         heavyTower,
         missle,
    }

    double getPosX();
    double getPosY();
    double getWidth();
    double getHeight();
}
