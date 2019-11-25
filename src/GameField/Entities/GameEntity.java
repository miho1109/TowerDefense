package GameField.Entities;

public interface GameEntity {

    enum ObjectType{
        NormalTroop,
        EliteTroop,
        Tanker,
        Boss,
        greenTower,
        bullet1,
    }

    double getPosX();
    double getPosY();
    double getWidth();
    double getHeight();

}
