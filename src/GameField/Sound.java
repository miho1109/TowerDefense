package GameField;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Sound {
    private static String path = "src/GameField/resources/ThemeSong.mp3";
    private static Media song = new Media(new File(path).toURI().toString());
    private static MediaPlayer themeSong = new MediaPlayer(song);

    public Sound(){
        themeSong.setAutoPlay(true);
    }

    public static void stopThemeSong(){
        themeSong.stop();
    }
}
