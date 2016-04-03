
import view.GameFrame;

import game.Game;

public class Tetris
{
    private static Game game;

    public static void main(String[] args)
    {
        System.out.println("Hello java!");
        game = new Game();
        new GameFrame(game);
        game.loop();
    }
}

