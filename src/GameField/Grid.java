package GameField;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Grid extends VBox {
    public static int height = 8;
    public static int width = 15;
    private static int size = 90;
    public static Rectangle [][]grid = new Rectangle[height][width];

    public static int [][]newGrid = {   {1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                                        {1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                                        {1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
                                        {1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1},
                                        {1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1},
                                        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1},
                                        {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                        {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    } ;

    public Grid() {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (newGrid[i][j] == 1) {
                    grid[i][j] = new Rectangle();
                    grid[i][j].setX((j) * size);
                    grid[i][j].setY((i) * size);
                    grid[i][j].setWidth(size);
                    grid[i][j].setHeight(size);
                    grid[i][j].setStroke(Color.RED);
                    grid[i][j].setFill(Color.TRANSPARENT);
                    grid[i][j].setVisible(false);
                    ViewManager.mainPane.getChildren().add(grid[i][j]);
                }
            }
        }
    }
}
