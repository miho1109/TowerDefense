package GameField;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class PlayerIndex {
    private static Rectangle border = new Rectangle();
    public static boolean playing = true;
    private static int lives = 20;
    private static int coin = 50;
    static Text playerLives, playerMoney, gameLevel;

    public static void setLives(int lives){ PlayerIndex.lives = lives; }
    public static void setCoin(int coin){ PlayerIndex.coin = coin; }
    public static int getLives(){ return lives; }
    public static int getCoin(){ return coin;}


    public PlayerIndex(){
        creatLables();
        updatePlayerIndex();
    }

    public static void creatLables(){
        gameLevel = new Text("Lv:" + " " + Integer.toString(GameControl.getGameLevel()));
        playerLives = new Text(":" + " " + Integer.toString(getLives()));
        playerMoney = new Text(":" + " " + Integer.toString(getCoin()));

        playerMoney.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        playerMoney.setTranslateX(1410);
        playerMoney.setTranslateY(620);
        playerMoney.setFill(Color.WHITE);
        playerMoney.setStroke(Color.BLACK);

        playerLives.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        playerLives.setTranslateX(1410);
        playerLives.setTranslateY(660);
        playerLives.setFill(Color.WHITE);
        playerLives.setStroke(Color.BLACK);

        gameLevel.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        gameLevel.setTranslateX(1410);
        gameLevel.setTranslateY(700);
        gameLevel.setFill(Color.WHITE);
        gameLevel.setStroke(Color.BLACK);

        border.setWidth(163);
        border.setHeight(130);
        border.setX(1360);
        border.setY(580);
        border.setStroke(Color.BLACK);
        border.setFill(Color.TRANSPARENT);

        ViewManager.mainPane.getChildren().addAll(playerLives, playerMoney, gameLevel, border);
    }

    public static void updatePlayerIndex() {
        Timeline updateTimeLine = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
            playerMoney.setText(":" + Integer.toString(coin));
            playerLives.setText(":" + Integer.toString(lives));
            gameLevel.setText(":" + Integer.toString(GameControl.getGameLevel()));
        }));
        updateTimeLine.setCycleCount(Animation.INDEFINITE);
        updateTimeLine.setAutoReverse(false);
        updateTimeLine.play();
    }

}
