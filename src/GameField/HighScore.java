package GameField;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class HighScore extends VBox {

    private ArrayList<Integer> scoreList = new ArrayList<>();
    private Label[] highScoreList = new Label[5];
    public static int playerScore = PlayerIndex.getCoin();

    public HighScore() throws IOException {
        loadScore();
        displayScore();
    }

    private void displayScore() {
        double startX = 850;
        double startY = 350;

        for(int i = 0; i < 5; i++) {
            highScoreList[i] = new Label(String.valueOf(scoreList.get(i)));
            highScoreList[i].setTranslateX(startX);
            highScoreList[i].setTranslateY(startY);
            if(scoreList.get(i) == playerScore) highScoreList[i].setTextFill(Color.WHITE);
            else highScoreList[i].setTextFill(Color.WHITE);
            highScoreList[i].setFont(Font.loadFont("file:AssetsKit_2/Font/UTM Helve.ttf", 30));
            startY += 10;
        }

        for (Label label : highScoreList) {
            if (label != null)
                this.getChildren().add(label);
        }
    }

    private void loadScore() throws IOException {
        FileReader fileReader = new FileReader("AssetsKit_2/HighScore.txt");
        BufferedReader test = new BufferedReader(fileReader);
        String line;

        while((line = test.readLine()) != null) {
            scoreList.add(Integer.valueOf(line));
        }

        test.close();

        Collections.sort(scoreList, Collections.reverseOrder());

    }

    public static void writeScore() throws IOException {
        FileWriter fileWriter = new FileWriter("AssetsKit_2/HighScore.txt", true);
        BufferedWriter test = new BufferedWriter(fileWriter);

        test.write(String.valueOf(playerScore));
        test.newLine();
        test.close();
    }
}
