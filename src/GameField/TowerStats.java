package GameField;

import GameField.Entities.GameEntity;
import GameField.Entities.Tower.Tower;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class TowerStats {
    private static Rectangle border = new Rectangle();
    static Text towerDamage, towerCost, towerUpgradeCost, description;

    public TowerStats(){
        createLabels();
        //updateTowerStats();
    }

    public static void createLabels() {

        towerCost = new Text(":" + " " + Integer.toString(0));
        towerDamage = new Text(":" + " " + Integer.toString(0));
        towerUpgradeCost = new Text(":" + " " + Integer.toString(0));

        towerCost.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        towerCost.setTranslateX(1410);
        towerCost.setTranslateY(320);
        towerCost.setFill(Color.WHITE);
        towerCost.setStroke(Color.BLACK);

        towerDamage.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        towerDamage.setTranslateX(1410);
        towerDamage.setTranslateY(370);
        towerDamage.setFill(Color.WHITE);
        towerDamage.setStroke(Color.BLACK);

        towerUpgradeCost.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        towerUpgradeCost.setTranslateX(1410);
        towerUpgradeCost.setTranslateY(420);
        towerUpgradeCost.setFill(Color.WHITE);
        towerUpgradeCost.setStroke(Color.BLACK);

        border.setWidth(163);
        border.setHeight(165);
        border.setX(1360);
        border.setY(280);
        border.setStroke(Color.BLACK);
        border.setFill(Color.TRANSPARENT);

        ViewManager.mainPane.getChildren().addAll(towerDamage, towerCost, towerUpgradeCost,border);
}

    public static void updateTowerStats(Tower tower) {
        towerCost.setText(":" + Integer.toString(Tower.getCost()));
        towerDamage.setText(":" + Integer.toString((int) (Tower.getDamage() * 100)));
        towerUpgradeCost.setText(":" + Integer.toString(Tower.getUpgradeCost()));

        /*
        for (int i = 0; i < GameControl.TowerList.size(); i++){
                if (GameControl.TowerList.get(i).isSelected == true) {
                    towerCost.setText(":" + Integer.toString(GameControl.TowerList.get(i).getCost()));
                    towerDamage.setText(":" + Integer.toString((int) (GameControl.TowerList.get(i).getDamage() * 100)));
                }
            }



        Timeline updateTimeLine = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
            for (int i = 0; i < GameControl.TowerList.size(); i++){
                if (GameControl.TowerList.get(i).isSelected == true) {
                    towerCost.setText(":" + Integer.toString(GameControl.TowerList.get(i).getCost()));
                    towerDamage.setText(":" + Integer.toString((int) (GameControl.TowerList.get(i).getDamage() * 100)));
                    towerUpgradeCost.setText(":" + Integer.toString(GameControl.TowerList.get(i).getUpgradeCost()));
                }
            }
        }));
        updateTimeLine.setCycleCount(Animation.INDEFINITE);
        updateTimeLine.setAutoReverse(false);
        updateTimeLine.play();
        */
    }

    public static void enableTowerStats() {
        towerCost.setVisible(true);
        towerDamage.setVisible(true);
        towerUpgradeCost.setVisible(true);
        border.setVisible(true);
    }

    public static void disableTowerStats() {
        towerCost.setVisible(false);
        towerDamage.setVisible(false);
        towerUpgradeCost.setVisible(false);
        border.setVisible(false);
    }

}
