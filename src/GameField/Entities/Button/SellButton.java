package GameField.Entities.Button;

import GameField.Entities.Tower.Tower;
import GameField.GameControl;
import GameField.PlayerIndex;
import GameField.ViewManager;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SellButton {
    protected static ImageView SB = new ImageView(new Image("file:src/GameField/Entities/Button/Resources/Sell.png"));
    static Button sellButton = new Button("", SB);

    public SellButton() {
        setLocation();
        setMouse();
        ViewManager.mainPane.getChildren().add(sellButton);
    }

    private void setLocation() {
        sellButton.setPrefSize(90, 90);
        sellButton.setLayoutX(1430);
        sellButton.setLayoutY(480);
        sellButton.setStyle("-fx-border-width: 0;\n" + "-fx-background-color: transparent;");
        sellButton.setViewOrder(-3);
    }

    private void setMouse() {
        sellButton.setOnMouseEntered(event -> sellButton.setEffect(new Glow()));
        sellButton.setOnMouseExited(event -> sellButton.setEffect(null));

        sellButton.setOnMouseClicked(event -> {
            for(int i = 0; i < GameControl.TowerList.size(); i++) {
               if (GameControl.TowerList.get(i).isSelected == true) {
                   PlayerIndex.setCoin((PlayerIndex.getCoin() + (int) (GameControl.TowerList.get(i).getCost() * 0.7)));
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
