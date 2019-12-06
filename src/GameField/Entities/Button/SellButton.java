package GameField.Entities.Button;

import GameField.Entities.Tower.Tower;
import GameField.GameControl;
import GameField.ViewManager;
import javafx.scene.control.Button;

public class SellButton {
    Button sellButton = new Button("Sell");

    public SellButton() {
        setLocation();
        setMouse();
        ViewManager.mainPane.getChildren().add(sellButton);
    }

    public void setLocation() {
        sellButton.setLayoutX(1382);
        sellButton.setLayoutY(300);
        sellButton.setPrefSize(120,60);
        sellButton.setStyle("-fx-border-width: 3;\n" + "-fx-border-color: black;\n" + "-fx-background-color: transparent;");
    }

    private void setMouse() {
        sellButton.setOnMouseClicked(event -> {
            //Tower.clearImage();
            for(int i = 0; i < GameControl.TowerList.size(); i++) {
                if (GameControl.TowerList.get(i).isSelected == true) GameControl.TowerList.get(i).clearTower();
            }
        });
    }
}
