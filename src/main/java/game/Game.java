package game;

import model.Grid;

/**
 * Created by kuro on 10/03/16.
 */
public class Game {

    private Grid grid;

    public Game()
    {
        grid = new Grid();
    }

    /**
     * Launch the main loop of the game
     */
    public void loop()
    {

    }

    public Grid getGrid() {
        return grid;
    }
}
