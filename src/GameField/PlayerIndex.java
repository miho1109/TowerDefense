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
    private static int coin = 100;
    private static int score = 0;
    static Text playerLives, playerMoney, gameLevel, playerScore;

    public static void setLives(int lives){ PlayerIndex.lives = lives; }
    public static void setCoin(int coin){ PlayerIndex.coin = coin; }
    public static void setScore(int score) { PlayerIndex.score = score; }
    public static int getLives(){ return lives; }
    public static int getCoin(){ return coin;}
    public static int getScore() { return score; }


    public PlayerIndex(){
        creatLables();
        updatePlayerIndex();
    }

    public static void creatLables(){
        gameLevel = new Text(":" + " " + Integer.toString(GameControl.getGameLevel()));
        playerLives = new Text(":" + " " + Integer.toString(getLives()));
        playerMoney = new Text(":" + " " + Integer.toString(getCoin()));
        playerScore = new Text("Score:" + " " + Integer.toString(getScore()));

        gameLevel.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        gameLevel.setTranslateX(1400);
        gameLevel.setTranslateY(600);
        gameLevel.setFill(Color.WHITE);

        playerLives.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        playerLives.setTranslateX(1400);
        playerLives.setTranslateY(550);
        playerLives.setFill(Color.WHITE);

        playerMoney.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        playerMoney.setTranslateX(1400);
        playerMoney.setTranslateY(500);
        playerMoney.setFill(Color.WHITE);

        playerScore.setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 40));
        playerScore.setTranslateX(1350);
        playerScore.setTranslateY(650);
        playerScore.setFill(Color.WHITE);

        ViewManager.mainPane.getChildren().addAll(playerLives, playerMoney, gameLevel);
    }

    public static void updatePlayerIndex() {
        Timeline updateTimeLine = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
            playerMoney.setText(Integer.toString(coin));
        }));
        updateTimeLine.setCycleCount(Animation.INDEFINITE);
        updateTimeLine.setAutoReverse(false);
        updateTimeLine.play();
    }

}
