package game;

import model.Grid;
import model.Position;
import model.Tetromino;
import model.TetrominoType;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Tenma on 10/03/16.
 */
public class Game {

    private Grid grid;
    private Player players[];
    private int level;
    private Tetromino activeTetromino;
    private Tetromino nextTetromino;
    private Tetromino stockTetromino;
    private ArrayList<Tetromino> tetrominosBag;
    private int tetrominosBagCounter;

    private boolean gameLooping;
    private long lastUpdateTime; // nanoseconds

    private ArrayList<GridObserver> gridObservers;
    private ArrayList<ScoreObserver> scoreObservers;

    public Game()
    {
        // Setup game environment here
        this.grid = new Grid();
        this.players = new Player[] {new Player(), new Player()};
        this.level = 1;
        
        this.initTetrominosBag();
        
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
        this.gameLooping = true;

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
        
        this.grid.update();
    }

    public Grid getGrid()
    {
        return grid;
    }

    private void initTetrominosBag() {
        this.tetrominosBag = new ArrayList<Tetromino>(7);
        for (TetrominoType type : TetrominoType.values()) {
            this.tetrominosBag.add(new Tetromino(type, new Position(0, 0)));
        }
        this.shuffleTetrominosBag();
    }

    private void shuffleTetrominosBag() {
        this.tetrominosBagCounter = 0;
        Collections.shuffle(this.tetrominosBag);
    }

    private Tetromino getRandomTetromino() {
        if (this.tetrominosBagCounter == this.tetrominosBag.size())
            this.shuffleTetrominosBag();
        return this.tetrominosBag.get(this.tetrominosBagCounter++);
    }
}
