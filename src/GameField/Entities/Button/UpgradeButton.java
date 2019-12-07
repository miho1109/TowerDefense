package GameField.Entities.Button;

import GameField.Entities.Tower.Tower;
import GameField.GameControl;
import GameField.ViewManager;
import javafx.scene.control.Button;

public class UpgradeButton {
    Button upgradeButton = new Button("Upgrade");

    public UpgradeButton() {
        setLocation();
        setMouse();
        ViewManager.mainPane.getChildren().add(upgradeButton);
    }

    public void setLocation() {
        //upgradeButton.setVisible(false);
        upgradeButton.setLayoutX(1382);
        upgradeButton.setLayoutY(370);
        upgradeButton.setPrefSize(120,60);
        upgradeButton.setStyle("-fx-border-width: 3;\n" + "-fx-border-color: black;\n" + "-fx-background-color: transparent;");
        upgradeButton.setViewOrder(-3);
    }

    private void setMouse() {
        upgradeButton.setOnMouseClicked(event -> {
            //Tower.clearImage();
            for (int i = 0; i < GameControl.TowerList.size(); i++) {
                if (GameControl.TowerList.get(i).isSelected == true) {
                    GameControl.TowerList.get(i).upgradeTower();
                }
            }
        });
    }

    public static void enableButton() {

    }
}
