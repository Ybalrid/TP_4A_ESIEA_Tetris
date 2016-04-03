package model;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * Created by vincet on 21/03/16.
 */
public class ScoreDAO {

    private File highScoresFile;

    public static void main(String[] args){
        ScoreDAO toto = new ScoreDAO();
        toto.writeScore(25);
        toto.writeScore(23);
        toto.writeScore(68);
        toto.writeScore(2);
        toto.writeScore(5);
        toto.writeScore(425);
        toto.writeScore(0);
        System.out.println(Arrays.toString(toto.readScores()));
    }

    public ScoreDAO() {
        //Create or read a file
        //Save the five highest score
        //Open a file if it does not exist, create a new file (highscores.dat)
        highScoresFile = new File("highscores.dat");
    }

    //Write a score in the high score file
    //If there is already five highs scores, update the five
    /**The algorithm: Read the scores. If there is an empty space in tab,
     * write it, else If the actual score is lower than the last one, stop.
     * else if replace the lowest score with the actual one.
     * Then, sort all the high score.
     */
    public void writeScore(Integer score) {
        Integer scores[] = readScores();
        int i;
        for (i = 0; i < scores.length && scores[i] != 0; i++);
        if (i == scores.length) {// Tab is full
            if (score > scores[i-1]){
                scores[i-1] = score;
            }
        }
        else{
            scores[i] = score;
        }
        // Array sort
        Arrays.sort(scores, Collections.reverseOrder());
        StringBuilder scoresDump = new StringBuilder();
        for (int j = 0; j < scores.length; j++) {
            scoresDump.append(((Integer)scores[j]).toString()+"\n");
        }
        try {
            Files.write(scoresDump, this.highScoresFile, Charsets.UTF_8);
        } catch (IOException e) {e.printStackTrace();}
    }


    public Integer[] readScores(){
        Integer[]  scores = new Integer[5]; //Read the five high score
        try {
            List<String> filecontent = Files.readLines(this.highScoresFile, Charsets.UTF_8);
            for (int i = 0; i < scores.length && i < filecontent.size(); i++) {
                scores[i] = Integer.parseInt(filecontent.get(i));
            }
        } catch (IOException e) { e.printStackTrace(); }
        return scores;
    }
}
