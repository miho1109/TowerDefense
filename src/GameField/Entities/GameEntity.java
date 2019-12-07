package GameField.Entities;

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
    }

    double getPosX();
    double getPosY();
    double getW();
    double getH();
}
