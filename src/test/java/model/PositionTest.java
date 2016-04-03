package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vincet on 03/04/16.
 */
public class PositionTest {
    private Position pos;

    @Before
    public void setUp() throws Exception {
        pos = new Position(12,24);
    }
    @Test
    public void getX() throws Exception {
        assertTrue(pos.getX()==12);
    }

    @Test
    public void setX() throws Exception {
        pos.setX(32);
        assertTrue(pos.getX()==32);
    }

    @Test
    public void getY() throws Exception {
        assertTrue(pos.getY()==24);
    }

    @Test
    public void setY() throws Exception {
        pos.setY(42);
        assertTrue(pos.getY()==42);
    }

}