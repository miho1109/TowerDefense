package GameField.Entities.Button;
import GameField.Entities.GameEntity;
import GameField.Entities.Tower.Tower;
import GameField.ViewManager;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static GameField.ViewManager.mainPane;

public class testingButton {

    public testingButton() {

        Image normalTowerIMG = new Image("GameField/Entities/Tower/Resources/normalTower.png");
        ImageView normalTowerIV = new ImageView(normalTowerIMG);

        Image airTowerIMG = new Image("GameField/Entities/Tower/Resources/airTower.png");
        ImageView airTowerIV = new ImageView(airTowerIMG);

        Image lightTowerIMG = new Image("GameField/Entities/Tower/Resources/lightTower.png");
        ImageView lightTowerIV = new ImageView(lightTowerIMG);

        Image heavyTowerIMG = new Image("GameField/Entities/Tower/Resources/heavyTower.png");
        ImageView heavyTowerIV = new ImageView(heavyTowerIMG);

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
            spawnNormalTower();
        });

        airTower.setOnMouseClicked(event -> {
            spawnAirTower();
        });

        lightTower.setOnMouseClicked(event -> {
            spawnLightTower();
        });

        heavyTower.setOnMouseClicked(event -> {
            spawnHeavyTower();
        });

        ViewManager.mainPane.getChildren().add(normalTower);
        ViewManager.mainPane.getChildren().add(airTower);
        ViewManager.mainPane.getChildren().add(lightTower);
        ViewManager.mainPane.getChildren().add(heavyTower);
    };

    private void setMouse() {
        mainPane.setOnMouseClicked(event -> {

        });
    }

    private void spawnNormalTower() {
        Tower temp = new Tower(GameEntity.ObjectType.normalTower);
    }

    private void spawnAirTower() {
        Tower temp = new Tower(GameEntity.ObjectType.airTower);
    }

    private void spawnLightTower() {
        Tower temp = new Tower(GameEntity.ObjectType.lightTower);
    }

    private void spawnHeavyTower() {
        Tower temp = new Tower(GameEntity.ObjectType.heavyTower);
    }
}
