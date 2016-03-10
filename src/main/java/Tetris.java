package main.java;

import game.Game;

public class Tetris
{
    static Game game;
    public static void main(String[] args)
    {
        System.out.println("Hello java!");
        game = new Game();
        game.loop();
    }

    public static int returnTwo()
    {
        return 2;
    }
}

