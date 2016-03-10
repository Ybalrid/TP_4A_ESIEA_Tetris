package game;

import model.Grid;

/**
 * Created by kuro on 10/03/16.
 */
public class Game {

    private Grid grid;
    private boolean gameLooping;


    public Game()
    {
        //Setup game environement here
        grid = new Grid();

        gameLooping = true;
    }

    /**
     * Launch the main loop of the game
     */
    public void loop()
    {
        while(gameLooping)
            update();
    }

    private void update()
    {

    }

    public Grid getGrid() {
        return grid;
    }
}
