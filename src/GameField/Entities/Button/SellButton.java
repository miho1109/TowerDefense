package GameField.Entities.Button;

import GameField.Entities.Tower.Tower;
import GameField.ViewManager;
import javafx.scene.control.Button;

public class SellButton {
    Button sellButton = new Button("Sell");

    public SellButton() {
        setLocation();
        //setMouse();
        ViewManager.mainPane.getChildren().add(sellButton);
    }

    private void setLocation() {
        sellButton.setLayoutX(1300);
        sellButton.setLayoutY(300);
    }

    private void setMouse() {
        sellButton.setOnMouseClicked(event -> {
            //Tower.clearImage();
        });
    }
}
