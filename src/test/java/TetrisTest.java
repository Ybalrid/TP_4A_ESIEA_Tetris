package test.java;

import junit.framework.Assert;
import org.junit.Test;

import main.java.Tetris;

public class TetrisTest
{
    @Test
    public void shouldReturnTwo()
    {
        Assert.assertEquals(Tetris.returnTwo(), 2);
    }
}
