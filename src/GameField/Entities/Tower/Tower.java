package GameField.Entities.Tower;

import GameField.Entities.GameEntity;
import GameField.Grid;
import GameField.ViewManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static GameField.ViewManager.mainPane;

public class Tower implements GameEntity {
    protected ImageView TowerImage;
    public ObjectType currentType;

    private double x;
    private double y;
    private double width;
    private double height;
    private double fireRate;
    private double damage;
    private boolean dragAble = true;

    public Tower(ObjectType type) {
        currentType = type;
        dragTower();
        loadTowerImage(type);
        ViewManager.mainPane.getChildren().add(TowerImage);
    }

    public ObjectType getCurrentType() {
        return currentType;
    }

    private void loadTowerImage(ObjectType type) {
        switch (type) {
            case normalTower:
                loadImage("GameField/Entities/Tower/Resources/normalTower.png");
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
        TowerImage = new ImageView(new Image(location));
    }

    public void clearImage() {
        ViewManager.mainPane.getChildren().remove(TowerImage);
        TowerImage = null;
    }

    private boolean spawnAble(double x, double y) {
        int i = (int) y / 90;
        int j = (int) x / 90;
        if (Grid.newGrid[i][j] == 1) return true;
        else return false;
    }

    private void dragTower() {

        mainPane.setOnMouseDragged(event -> {
            if (dragAble) {
                TowerImage.setX(event.getSceneX() - 45);
                TowerImage.setY(event.getSceneY() - 50);
            }
        });

        mainPane.setOnMouseReleased(event -> {
            if ((spawnAble(event.getSceneX(), event.getSceneY())) && (dragAble)) {
                TowerImage.setX(((int) (event.getSceneX() / 90) * 90));
                TowerImage.setY(((int) (event.getSceneY() / 90) * 90));
                dragAble = false;
            }
        });

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
