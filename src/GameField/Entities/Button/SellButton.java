package GameField.Entities.Button;

import GameField.Entities.Tower.Tower;
import GameField.GameControl;
import GameField.PlayerIndex;
import GameField.ViewManager;
import javafx.scene.control.Button;

public class SellButton {
    static Button sellButton = new Button("Sell");

    public SellButton() {
        setLocation();
        setMouse();
        ViewManager.mainPane.getChildren().add(sellButton);
    }

    public void setLocation() {
        //sellButton.setVisible(false);
        sellButton.setLayoutX(1382);
        sellButton.setLayoutY(300);
        sellButton.setPrefSize(120,60);
        sellButton.setStyle("-fx-border-width: 3;\n" + "-fx-border-color: black;\n" + "-fx-background-color: transparent;");
        sellButton.setViewOrder(-3);
    }

    private void setMouse() {
        sellButton.setOnMouseClicked(event -> {
            for(int i = 0; i < GameControl.TowerList.size(); i++) {
               if (GameControl.TowerList.get(i).isSelected == true) {
                   PlayerIndex.setCoin(PlayerIndex.getCoin() + GameControl.TowerList.get(i).getCost());
                   GameControl.TowerList.get(i).clearTower();
                   GameControl.TowerList.remove(i);
               }
            }
        });
    }

    public static void enableButton() {
        sellButton.setVisible(true);
    }

    public static void disableButton() {
        sellButton.setVisible(false);
    }
}
