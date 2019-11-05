package Tower;

import GameField.Entities.AbstractTile;
import GameField.Entities.GameEntity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tower extends AbstractTile {

    public Tower(long posX, long posY, long width, long height) {
        super(posX, posY, width, height);
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

    public Tower createTower() {
        Tower tower = new Tower();
        tower.posX = 4 * 128;
        tower.posY = 2 * 128;
        return tower;
    }

}
