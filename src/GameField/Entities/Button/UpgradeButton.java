package GameField.Entities.Button;

import GameField.Entities.MovingObjects.Bullet.Bullet;
import GameField.Entities.Tower.Tower;
import GameField.GameControl;
import GameField.PlayerIndex;
import GameField.ViewManager;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UpgradeButton {
    protected static ImageView UB = new ImageView(new Image("file:src/GameField/Entities/Button/Resources/Upgrade.png"));
    Button upgradeButton = new Button("", UB);

    public UpgradeButton() {
        setLocation();
        setMouse();
        ViewManager.mainPane.getChildren().add(upgradeButton);
    }

    private void setLocation() {
        upgradeButton.setPrefSize(90, 90);
        upgradeButton.setLayoutX(1345);
        upgradeButton.setLayoutY(460);
        upgradeButton.setStyle("-fx-border-width: 0;\n" + "-fx-background-color: transparent;");
        upgradeButton.setViewOrder(-3);
    }

    private void setMouse() {
        upgradeButton.setOnMouseEntered(event -> upgradeButton.setEffect(new Glow()));
        upgradeButton.setOnMouseExited(event -> upgradeButton.setEffect(null));

        upgradeButton.setOnMouseClicked(event -> {
            for (int i = 0; i < GameControl.TowerList.size(); i++) {
                if (GameControl.TowerList.get(i).isSelected == true && (PlayerIndex.getCoin() >= GameControl.TowerList.get(i).getUpgradeCost())) {
                    GameControl.TowerList.get(i).upgradeTower();
                    PlayerIndex.setCoin(PlayerIndex.getCoin() - GameControl.TowerList.get(i).getUpgradeCost());
                    GameControl.TowerList.get(i).setUpgradeCost((int) (GameControl.TowerList.get(i).getUpgradeCost() * 1.2));
                }
            }
        });
    }

}
