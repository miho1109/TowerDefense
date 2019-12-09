package GameField.Entities.Button;
import GameField.Entities.GameEntity;
import GameField.Entities.Tower.Tower;
import GameField.GameControl;
import GameField.Grid;
import GameField.PlayerIndex;
import GameField.ViewManager;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static GameField.ViewManager.mainPane;

public class TowerButton {

    static Text towerDamage, towerCost, towerUpgradeCost;
    private static Rectangle border = new Rectangle();

    public TowerButton() {
        designText();

        ImageView normalTowerIV = new ImageView(new Image("file:src/GameField/Entities/Tower/Resources/frozer.png"));
        ImageView airTowerIV = new ImageView(new Image("file:src/GameField/Entities/Tower/Resources/airTower.png"));
        ImageView lightTowerIV = new ImageView(new Image("file:src/GameField/Entities/Tower/Resources/lightTower.png"));
        ImageView heavyTowerIV = new ImageView(new Image("file:src/GameField/Entities/Tower/Resources/heavyTower.png"));

        Button normalTower = new Button("", normalTowerIV);
        Button airTower = new Button("", airTowerIV);
        Button lightTower = new Button("", lightTowerIV);
        Button heavyTower = new Button("", heavyTowerIV);

        normalTower.setMaxSize(90, 90);
        normalTower.setMinSize(90, 90);
        normalTower.setLayoutX(1350);
        normalTower.setLayoutY(0);
        normalTower.setStyle("-fx-border-width: 0;\n" + "-fx-background-color: transparent;");

        airTower.setMaxSize(90, 90);
        airTower.setMinSize(90, 90);
        airTower.setLayoutX(1440);
        airTower.setLayoutY(0);
        airTower.setStyle("-fx-border-width: 0;\n" + "-fx-background-color: transparent;");

        lightTower.setMaxSize(90, 90);
        lightTower.setMinSize(90, 90);
        lightTower.setLayoutX(1350);
        lightTower.setLayoutY(140);
        lightTower.setStyle("-fx-border-width: 0;\n" + "-fx-background-color: transparent;");

        heavyTower.setMaxSize(90, 90);
        heavyTower.setMinSize(90, 90);
        heavyTower.setLayoutX(1440);
        heavyTower.setLayoutY(140);
        heavyTower.setStyle("-fx-border-width: 0;\n" + "-fx-background-color: transparent;");

        normalTower.setOnMouseClicked(event -> {
            if (!SpawnedTower() && (PlayerIndex.getCoin() >= 50)) {
                    Tower.spawnedTower = true;
                    enableGrid();
                    spawnNormalTower();
                    PlayerIndex.setCoin(PlayerIndex.getCoin() - 50);
            }
        });
        normalTower.setOnMouseEntered(event -> {
            normalTower.setEffect(new Glow());
            towerCost.setText("$: " + Integer.toString(50));
            towerDamage.setText("D: " + Integer.toString(100));
            towerUpgradeCost.setText("U: " + Integer.toString(25));
            enableTowerStats();
        });
        normalTower.setOnMouseExited(event -> {
            normalTower.setEffect(null);
            disableTowerStats();
        });

        airTower.setOnMouseClicked(event -> {
            if (!SpawnedTower() && (PlayerIndex.getCoin() >= 40)) {
                Tower.spawnedTower = true;
                enableGrid();
                spawnAirTower();
                PlayerIndex.setCoin(PlayerIndex.getCoin() - 40);
            }
        });
        airTower.setOnMouseEntered(event -> {
            airTower.setEffect(new Glow());
            towerCost.setText("$: " + Integer.toString(40));
            towerDamage.setText("D: " + Integer.toString(40));
            towerUpgradeCost.setText("U: " + Integer.toString(20));
            enableTowerStats();
        });
        airTower.setOnMouseExited(event -> {
            airTower.setEffect(null);
            disableTowerStats();
        });

        lightTower.setOnMouseClicked(event -> {
            if (!SpawnedTower() && (PlayerIndex.getCoin() >= 10)) {
                    Tower.spawnedTower = true;
                    enableGrid();
                    spawnLightTower();
                    PlayerIndex.setCoin(PlayerIndex.getCoin() - 10);
            }
        });
        lightTower.setOnMouseEntered(event -> {
            lightTower.setEffect(new Glow());
            towerCost.setText("$: " + Integer.toString(10));
            towerDamage.setText("D: " + Integer.toString(10));
            towerUpgradeCost.setText("U: " + Integer.toString(5));
            enableTowerStats();
        });
        lightTower.setOnMouseExited(event -> {
            lightTower.setEffect(null);
            disableTowerStats();
        });

        heavyTower.setOnMouseClicked(event -> {
            if (!SpawnedTower() && (PlayerIndex.getCoin() >= 20)) {
                Tower.spawnedTower = true;
                enableGrid();
                spawnHeavyTower();
                PlayerIndex.setCoin(PlayerIndex.getCoin() - 20);
            }
        });
        heavyTower.setOnMouseEntered(event -> {
            heavyTower.setEffect(new Glow());
            towerCost.setText("$: " + Integer.toString(20));
            towerDamage.setText("D: " + Integer.toString(22));
            towerUpgradeCost.setText("U: " + Integer.toString(10));
            enableTowerStats();
        });
        heavyTower.setOnMouseExited(event -> {
            heavyTower.setEffect(null);
            disableTowerStats();
        });

        normalTower.setViewOrder(-3);
        airTower.setViewOrder(-3);
        lightTower.setViewOrder(-3);
        heavyTower.setViewOrder(-3);
        ViewManager.mainPane.getChildren().add(normalTower);
        ViewManager.mainPane.getChildren().add(airTower);
        ViewManager.mainPane.getChildren().add(lightTower);
        ViewManager.mainPane.getChildren().add(heavyTower);
    }

    private void enableGrid() {
        for (int i = 0; i < Grid.height; i++) {
            for (int j = 0; j < Grid.width; j++) {
                if (Grid.newGrid[i][j] == 1) Grid.grid[i][j].setVisible(true);
            }
        }
    }

    public static void disableGrid() {
        for (int i = 0; i < Grid.height; i++) {
            for (int j = 0; j < Grid.width; j++) {
                if (Grid.newGrid[i][j] == 1) Grid.grid[i][j].setVisible(false);
            }
        }
    }

    private boolean SpawnedTower() {
        return Tower.spawnedTower;
    }

    private void spawnNormalTower() {
        Tower temp = new Tower(GameEntity.ObjectType.frozer);
        GameControl.TowerList.add(temp);
    }

    private void spawnAirTower() {
        Tower temp = new Tower(GameEntity.ObjectType.launcher);
        GameControl.TowerList.add(temp);
    }

    private void spawnLightTower() {
        Tower temp = new Tower(GameEntity.ObjectType.lightTower);
        GameControl.TowerList.add(temp);
    }

    private void spawnHeavyTower() {
        Tower temp = new Tower(GameEntity.ObjectType.heavyTower);
        GameControl.TowerList.add(temp);
    }

    private void designText() {
        towerCost = new Text("$:" + " " + Integer.toString(50));
        towerDamage = new Text("D:" + " " + Integer.toString(0));
        towerUpgradeCost = new Text("U:" + " " + Integer.toString(0));

        towerCost.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        towerCost.setTranslateX(1380);
        towerCost.setTranslateY(325);
        towerCost.setFill(Color.WHITE);
        towerCost.setStroke(Color.BLACK);
        towerCost.setVisible(false);

        towerDamage.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        towerDamage.setTranslateX(1380);
        towerDamage.setTranslateY(375);
        towerDamage.setFill(Color.WHITE);
        towerDamage.setStroke(Color.BLACK);
        towerDamage.setVisible(false);

        towerUpgradeCost.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        towerUpgradeCost.setTranslateX(1380);
        towerUpgradeCost.setTranslateY(425);
        towerUpgradeCost.setFill(Color.WHITE);
        towerUpgradeCost.setStroke(Color.BLACK);
        towerUpgradeCost.setVisible(false);

        border.setWidth(163);
        border.setHeight(165);
        border.setX(1360);
        border.setY(280);
        border.setStroke(Color.BLACK);
        border.setFill(Color.TRANSPARENT);
        border.setVisible(false);

        ViewManager.mainPane.getChildren().addAll(towerCost, towerDamage, towerUpgradeCost, border);
    }

    private static void enableTowerStats() {
        towerCost.setVisible(true);
        towerDamage.setVisible(true);
        towerUpgradeCost.setVisible(true);
        border.setVisible(true);
    }

    private static void disableTowerStats() {
        towerCost.setVisible(false);
        towerDamage.setVisible(false);
        towerUpgradeCost.setVisible(false);
        border.setVisible(false);
    }
}
