package GameField.Entities.MovingObjects.Enemy;

import GameField.Entities.MovingObjects.MovingObjects;
import GameField.ViewManager;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.io.File;

public class Enemy extends MovingObjects {

    MoveTo moveTo = new MoveTo(150,716);
    LineTo line1 = new LineTo(150, 540);
    LineTo line2 = new LineTo(415,540);
    LineTo line3 = new LineTo(427,80);
    LineTo line4 = new LineTo(669,80);
    LineTo line5 = new LineTo(680,444);
    LineTo line6 = new LineTo(920,444);
    LineTo line7 = new LineTo(933,183);
    LineTo line8 = new LineTo(1270,170);

    public Enemy(ObjectType type) {
        switch (type){
            case NormalTroop:
                loadImage("GameField/Entities/MovingObjects/Enemy/Resources/normalTroop.png");
                setPath(15000, moveTo, line1, line2, line3, line4, line5, line6, line7,line8);
                break;
            case EliteTroop:
                loadImage("GameField/Entities/MovingObjects/Enemy/Resources/eliteTroop.png");
                setPath(13500, moveTo, line1, line2, line3, line4, line5, line6, line7,line8);
                break;
            case Tanker:
                //new Tanker();
            case Boss:
                //new Boss();
        }
    }

    private void loadImage(String location){
        EnemyImage = new ImageView(new Image(location));
        EnemyImage.setPreserveRatio(true);
        EnemyImage.setX(150);
        EnemyImage.setY(716);
        ViewManager.mainPane.getChildren().add(EnemyImage);
    }

    public double getPosX() {
        return EnemyImage.getTranslateX();
    }

    public double getPosY(){
        return EnemyImage.getTranslateY();
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    public boolean isContaining(double posX, double posY, double width, double height){
        return false;
    }
    public boolean isBeingContained(double posX, double posY, double width, double height){
        return false;
    }
    public boolean isBeingOverlapped(double posX, double posY, double width, double height){
        return false;
    }
}
