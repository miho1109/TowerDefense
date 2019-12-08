package GameField;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class writeScore {
    public writeScore() throws IOException{
        action();
    }

    private void action() throws IOException {
        //File file = new File("Highscore.txt");

        // creates the file
        //file.createNewFile();

        // creates a FileWriter Object
        FileWriter writer = new FileWriter("Highscore.txt");

        // Writes the content to the file
        writer.write(PlayerIndex.getCoin());
        //writer.flush();
        //writer.close();
        /*
        // Creates a FileReader Object
        FileReader fr = new FileReader(file);
        char [] a = new char[50];
        fr.read(a);   // reads the content to the array

        for(char c : a)
            System.out.print(c);   // prints the characters one by one
        fr.close();
         */
    }


}
