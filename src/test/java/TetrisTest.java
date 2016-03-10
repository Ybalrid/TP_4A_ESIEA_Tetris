package test.java;

import static org.junit.Assert.*;
import main.java.Tetris;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TetrisTest
{
    @Test
    public void shouldReturnTwo()
    {
        assertEquals(Tetris.returnTwo(), 2);
    }
}