package game;

import model.Grid;

/**
 * Created by kuro on 10/03/16.
 */
public class Game {

    private Grid grid;
    private Player players[];
    private boolean gameLooping;
    private long now, last, frameTime;
    private int level;

    public Game()
    {
        //Setup game environement here
        grid = new Grid();
        gameLooping = true;
        players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();
        level = 1;

    }

    /**
     * Launch the main loop of the game
     */
    public void loop()
    {
        while(gameLooping)
        {
            now = System.nanoTime();
            System.out.println(frameTime = (now - last));
            update();
            last = now;
        }
    }

    private void update()
    {
    }

    public Grid getGrid()
    {
        return grid;
    }
}
