package game;

import model.Grid;

/**
 * Created by kuro on 10/03/16.
 */
public class Game {

    private Grid grid;
    private Player player0;
    private boolean gameLooping;
    private long now, last, frameTime;

    public Game()
    {
        //Setup game environement here
        grid = new Grid();
        gameLooping = true;
        player0 = new Player();
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
