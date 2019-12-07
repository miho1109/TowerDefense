package GameField;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class PlayerIndex {
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
        playerMoney.setTranslateX(1400);
        playerMoney.setTranslateY(620);
        playerMoney.setFill(Color.WHITE);
        playerMoney.setStroke(Color.BLACK);

        playerLives.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        playerLives.setTranslateX(1400);
        playerLives.setTranslateY(660);
        playerLives.setFill(Color.WHITE);
        playerLives.setStroke(Color.BLACK);

        gameLevel.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        gameLevel.setTranslateX(1400);
        gameLevel.setTranslateY(700);
        gameLevel.setFill(Color.WHITE);
        gameLevel.setStroke(Color.BLACK);

        ViewManager.mainPane.getChildren().addAll(playerLives, playerMoney, gameLevel);
    }

    public static void updatePlayerIndex() {
        Timeline updateTimeLine = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
            playerMoney.setText(":" + Integer.toString(coin));
            playerLives.setText(Integer.toString(lives));
            gameLevel.setText(Integer.toString(GameControl.getGameLevel()));
        }));
        updateTimeLine.setCycleCount(Animation.INDEFINITE);
        updateTimeLine.setAutoReverse(false);
        updateTimeLine.play();
    }

}
