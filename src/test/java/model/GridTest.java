package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vincet on 03/04/16.
 */
public class GridTest extends Grid{
    public GridTest(){
        super();
    }
    private Grid objectTest;
    Position pos = new Position(10,45);
    @Before
    public void setUp() throws Exception {
        objectTest = new GridTest();
        objectTest.
    }

    @Test
    public void getTest() throws Exception {
        int newgrid = objectTest.get(pos);
        assertTrue("valeur correcte", objectTest.get(pos) == newgrid);
    }

    @Test
    public void setTest() throws Exception {
        objectTest.set(pos,98);
        assertTrue("valeur mise a jour", objectTest.get(pos)==98);
    }

    @Test
    public void applyTetrominoTest() throws Exception {

    }


    @Test
    private void fall() {

    }

    @Test
    private int checkAndClearLines() {

    }

    @Test
    private boolean isLineFull(int y) {
        Position pos1 = new Position(10,5);
        objectTest.set(pos,5);
    }

    @Test
    private boolean isLineVoid(int y) {

    }

    @Test
    private void clearLine(int y) {

    }

}