import model.Position;
import model.Tetromino;

import java.util.Arrays;

public class Tetris
{
    public static void main(String[] args)
    {
        Tetromino L = new Tetromino('L', new Position(2,0));
        System.out.println(Arrays.deepToString(L.getShape()));
        L.rotate(true);
        System.out.println(Arrays.deepToString(L.getShape()));
    }

    public static int returnTwo()
    {
        return 2;
    }
}

