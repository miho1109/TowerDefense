package GameField;

import GameField.Entities.Button.*;
import GameField.Entities.GameEntity;
import GameField.Entities.MovingObjects.Enemy.Enemy;
import GameField.Entities.Tower.Tower;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.print.PageLayout;
import javafx.util.Duration;

import java.util.ArrayList;

import static GameField.ViewManager.mainPane;

public class GameControl {
    private static int gameLevel;
    public static ArrayList<Enemy> EnemyList = new ArrayList<>();
    public static ArrayList<Tower> TowerList = new ArrayList<>();
    private static int offTime ;
    private static Timeline spawnEnemyTimeline;
    private static Timeline restTimeline;

    public static int getGameLevel(){ return gameLevel; }

    public static void gameStart(){
        ViewManager.createInGameBackGround();
        drawGrid();
        spawnTroop(5, 3, 1);
        createTowerButton();
        new PlayerIndex();
        new TowerStats();
    }

    public static void EnemyCleanUp(){
        if(restTimeline != null) {
            restTimeline.stop();
        }
        if(spawnEnemyTimeline != null){
            spawnEnemyTimeline.stop();
        }
    }

    public static void spawnTroop(int lives, int quantities, int lv){
        gameLevel = lv;
        spawnEnemyTimeline = new Timeline(new KeyFrame(Duration.millis(1200), event -> {
            switch (lv){
                case 1:{
                    offTime = 15;
                    creatTroopByNeed(GameEntity.ObjectType.normalTroop, 5);
                    break;
                }
                case 2: {
                    offTime = 15;
                    creatTroopByNeed(GameEntity.ObjectType.eliteTroop, 10);
                    break;
                }
                case 3:{
                    offTime = 15;
                    creatTroopByNeed(GameEntity.ObjectType.normalTroop, 5);
                    creatTroopByNeed(GameEntity.ObjectType.eliteTroop, 5);
                    break;
                }
                case 4: {
                    offTime = 25;
                    creatTroopByNeed(GameEntity.ObjectType.tank, 3);
                    break;
                }
                case 5: {
                    offTime = 25;
                    creatTroopByNeed(GameEntity.ObjectType.tank, 2);
                    creatTroopByNeed(GameEntity.ObjectType.normalTroop, 5);
                    break;
                }
                case 6: {
                    offTime = 25;
                    creatTroopByNeed(GameEntity.ObjectType.plane, 5);
                    creatTroopByNeed(GameEntity.ObjectType.tank, 3);
                    break;
                }
                case 7:{
                    offTime = 25;
                    creatTroopByNeed(GameEntity.ObjectType.normalTroop, 3);
                    creatTroopByNeed(GameEntity.ObjectType.eliteTroop, 3);
                    creatTroopByNeed(GameEntity.ObjectType.tank, 3);
                    creatTroopByNeed(GameEntity.ObjectType.plane, 3);
                    break;
                }
                default:
                {
                    offTime = 25;
                    creatTroopByNeed(GameEntity.ObjectType.normalTroop, quantities);
                    creatTroopByNeed(GameEntity.ObjectType.eliteTroop, quantities);
                    creatTroopByNeed(GameEntity.ObjectType.tank, quantities - 5);
                    creatTroopByNeed(GameEntity.ObjectType.plane, quantities);
                    break;
                }
            }
        }));
        spawnEnemyTimeline.setCycleCount(1);
        spawnEnemyTimeline.play();
        spawnEnemyTimeline.setOnFinished(event -> {
            restTimeline = new Timeline(new KeyFrame(Duration.seconds(offTime), event1 -> {
            }));
            restTimeline.setCycleCount(1);
            restTimeline.play();
            restTimeline.setOnFinished(event1 -> {
                spawnTroop(5, quantities + 1, gameLevel+ 1);
            });
        });
    }

    private static void creatTroopByNeed(GameEntity.ObjectType type, int quantities){
        switch (type){
            case normalTroop: {
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> {
                    EnemyList.add(new Enemy(GameEntity.ObjectType.normalTroop));
                }));
                timeline.setCycleCount(quantities);
                timeline.play();
                break;
            }
            case eliteTroop: {
                Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(800), event -> {
                    EnemyList.add(new Enemy(GameEntity.ObjectType.eliteTroop));
                }));
                timeline1.setCycleCount(quantities);
                timeline1.play();
                break;
            }
            case tank: {
                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(2000), event -> {
                    EnemyList.add(new Enemy(GameEntity.ObjectType.tank));
                }));
                timeline2.setCycleCount(quantities);
                timeline2.play();
                break;
            }
            case plane: {
                Timeline timeline3 = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
                    EnemyList.add(new Enemy(GameEntity.ObjectType.plane));
                }));
                timeline3.setCycleCount(quantities);
                timeline3.play();
                break;
            }
        }
    }

    public static void printTroopXY() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> {
            if (!EnemyList.isEmpty()) {
                System.out.println(EnemyList.get(0).getPosX() + " " +EnemyList.get(0).getPosY());
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    static void printMousePosition() {
        mainPane.setOnMouseMoved(event -> {
            System.out.println("MouseX: " + (int) event.getSceneX() );
            System.out.println("MouseY: " + (int) event.getSceneY() );
        });
    }

    public static void drawGrid() {
        Grid grid = new Grid();
    }

    public static void createTowerButton() {
        TowerButton TB = new TowerButton();
        SellButton SB = new SellButton();
        UpgradeButton UB = new UpgradeButton();
    }

    public static void createGameButton() {
        StartUpButtons SB = new StartUpButtons();
    }

}