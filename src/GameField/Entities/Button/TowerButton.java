package GameField.Entities.Button;

import GameField.Entities.GameEntity;
import GameField.Entities.Tower.Tower;
import GameField.ViewManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static GameField.ViewManager.mainPane;

public class TowerButton implements GameEntity {

    protected ImageView TBImage;
    private ObjectType towerType;

    public TowerButton(Tower tower) {
        //action();
        this.towerType = tower.getCurrentType();
        loadTowerImage(towerType);
        pressButton();
        ViewManager.mainPane.getChildren().add(TBImage);
        spawnTower();
    }

    private void pressButton() {
        mainPane.setOnMouseClicked(event -> {
            Tower normalTower = new Tower(towerType);
        });
    }

    private void spawnTower() {
        Tower temp = new Tower(towerType);
    }

    private void loadTowerImage(ObjectType type) {
        switch (type) {
            case normalTower:
                loadImage("GameField/Entities/Tower/Resources/frozer.png");
                break;
            /*
            case airTower:
                loadImage("GameField/Entities/Tower/Resources/airTower.png");
                break;

            case lightTower:
                loadImage("GameField/Entities/Tower/Resources/lightTower.png");
                break;

            case heavyTower:
                loadImage("GameField/Entities/Tower/Resources/heavyTower.png");
                break;
             */
        }
    }

    private void loadImage(String location) {
        TBImage = new ImageView(new Image(location));
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
