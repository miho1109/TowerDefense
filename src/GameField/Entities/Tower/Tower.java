package GameField.Entities.Tower;

import GameField.Entities.GameEntity;
import GameField.Grid;
import GameField.ViewManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        loadTowerImage(type);
        currentType = type;
        dragTower();
        ViewManager.mainPane.getChildren().add(TowerImage);
    }

    public ObjectType getCurrentType() {
        return currentType;
    }

    private void loadTowerImage(ObjectType type) {
        switch (type) {
            case frozer:
                loadImage("GameField/Entities/Tower/Resources/frozer.png");
                TowerImage.setX(1300);
                TowerImage.setY(0);
                break;

            case missle:
                loadImage("GameField/Entities/Tower/Resources/airTower.png");
                TowerImage.setX(1400);
                TowerImage.setY(0);
                break;

            case lightTower:
                loadImage("GameField/Entities/Tower/Resources/lightTower.png");
                TowerImage.setX(1300);
                TowerImage.setY(140);
                break;

            case heavyTower:
                loadImage("GameField/Entities/Tower/Resources/heavyTower.png");
                TowerImage.setX(1400);
                TowerImage.setY(140);
                break;
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
//        TowerImage.setOnMouseClicked(event -> {
//            if ((spawnAble(event.getSceneX(), event.getSceneY())) && (dragAble)) {
//                TowerImage.setX(((int) (event.getSceneX() / 90) * 90));
//                TowerImage.setY(((int) (event.getSceneY() / 90) * 90));
//                dragAble = false;
//            }
//        });

        TowerImage.setOnMouseDragged(event -> {
            if (dragAble) {
                TowerImage.setX(event.getSceneX() - 45);
                TowerImage.setY(event.getSceneY() - 50);
            }
        });

        TowerImage.setOnMouseReleased(event -> {
            if ((spawnAble(event.getSceneX(), event.getSceneY())) && (dragAble)) {
                TowerImage.setX(((int) (event.getSceneX() / 90) * 90));
                TowerImage.setY(((int) (event.getSceneY() / 90) * 90));
                dragAble = false;
            }
        });

    }

    public double getPosX() {
        return TowerImage.getTranslateX();
    }

    public double getPosY() {
        return TowerImage.getTranslateY();
    }

    public double getWidth() {
        return 0;
    }

    public double getHeight() {
        return 0;
    }

}
