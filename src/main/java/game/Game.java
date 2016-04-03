package game;

import model.Grid;
import model.Tetromino;

/**
 * Created by kuro on 10/03/16.
 */
public class Game {

    private Grid grid;
    private Player players[];
    private Tetromino activeTetromino;
    private Tetromino nextTetromino;
    private Tetromino stockTetromino;
    private int level;

    private boolean gameLooping;
    private long lastUpdateTime; // nanoseconds

    public Game()
    {
        // Setup game environment here
        this.grid = new Grid();
        this.players = new Player[] {new Player(), new Player()};
        this.level = 1;

        this.gameLooping = true;
        this.lastUpdateTime = System.nanoTime();
    }

    /**
     * Launch the main loop of the game
     */
    public void loop()
    {
        long now = System.nanoTime(), deltaTime;
        System.out.println("Startup time: " + (now - this.lastUpdateTime));
        this.lastUpdateTime = now;

        while (gameLooping)
        {
            now = System.nanoTime();
            deltaTime = (now - this.lastUpdateTime);
            if (now % 100000 == 0) System.out.println("DT: " + String.valueOf(deltaTime / 1_000_000f) + "ms");
            if (deltaTime >= 1_000_000_000) {
                update();
                this.lastUpdateTime = now;
            }
        }
    }

    private void update()
    {
        System.out.println("Update");
    }

    public Grid getGrid()
    {
        return grid;
    }
}
