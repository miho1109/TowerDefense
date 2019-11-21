package GameField.Entities.Tower;

import GameField.Grid;
import GameField.ViewManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static GameField.ViewManager.mainPane;

public class greenTower extends Tower {
    private double x;
    private double y;
    private double width;
    private double height;
    private double fireRate;
    private double damage;

    private boolean dragAble = true;

    public Image image = new Image("GameField/Entities/Tower/Resources/greenTower.png");
    public ImageView greenTower = new ImageView(image);

    private void loadImage() {
        ViewManager.mainPane.getChildren().add(greenTower);
    }

    private void clearImage() {
        ViewManager.mainPane.getChildren().remove(greenTower);
        greenTower  = null;
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
                    greenTower.setX(event.getSceneX() - 45);
                    greenTower.setY(event.getSceneY() - 50);
                }
            });

            mainPane.setOnMouseReleased(event -> {
                if ((spawnAble(event.getSceneX(), event.getSceneY())) && (dragAble)) {
                    greenTower.setX(((int) (event.getSceneX() / 90) * 90));
                    greenTower.setY(((int) (event.getSceneY() / 90) * 90));
                    dragAble = false;
                }
            });

    }

    public greenTower() {
        super();
        dragTower();
        loadImage();
    }


         /**

          greenTower.setX(250);
          greenTower.setY(250);
          ViewManager.mainPane.getChildren().add(greenTower);


        mainPane.setOnMouseDragEntered(event -> {
            greenTower.setX(event.getSceneX()-60);
            greenTower.setY(event.getSceneY()-70);
        });

        mainPane.setOnMouseDragExited(event -> {
            ViewManager.mainPane.getChildren().add(greenTower);
        });
         */
}

