package GameField;

import GameField.Entities.MovingObjects.Enemy.Enemy;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class PlayerIndex {
    public static Timeline updatePlayerIndexTimeLine;
    private static int lives = 5;
    private static int coin = 50;
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
        gameLevel = new Text("Lv:" + " " + Integer.toString(GameControl.getGameLevel()));
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

    public void updatePlayerIndex() {
        updatePlayerIndexTimeLine = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
            playerMoney.setText(Integer.toString(coin));
            playerLives.setText(Integer.toString(lives));
            gameLevel.setText(Integer.toString(GameControl.getGameLevel()));
            if(lives == 0) {
                GameControl.EnemyCleanUp();
                for(Enemy e: GameControl.EnemyList){
                    e.deleteEnemyWhenReplay();
                }
                ViewManager.mainPane.getChildren().clear();
                ViewManager.creatEndInterface();
                updatePlayerIndexTimeLine.stop();
            }
        }));
        updatePlayerIndexTimeLine.setCycleCount(Animation.INDEFINITE);
        updatePlayerIndexTimeLine.setAutoReverse(false);
        updatePlayerIndexTimeLine.play();
    }

    public static void resetPlayerIndex(){
        setCoin(50);
        setLives(5);
    }
}
