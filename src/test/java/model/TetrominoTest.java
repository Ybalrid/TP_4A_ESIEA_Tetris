package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vincet on 31/03/16.
 */
public class TetrominoTest {
    private Tetromino objectTest;
    @Before
    public void setUp() throws Exception {
        objectTest = new Tetromino(TetrominoType.L,new Position(0,0));
    }

    @Test
    public void getPosition() throws Exception {
        Position pos = objectTest.getPosition();
        assertTrue("Position incorrecte", pos.getX()==0 && pos.getY()==0);
    }

    @Test
    public void setPosition() throws Exception {
        objectTest.setPosition(new Position(12,31));
        Position pos = objectTest.getPosition();
        assertTrue("Position mise correctement", pos.getX()==12 && pos.getY()==31);

    }

    @Test
    public void getRotation() throws Exception {
        int rot = objectTest.getRotation();
        assertTrue("Rotation Valide", rot==0 || rot==1 || rot==2 || rot==3);
    }

    @Test
    public void rotate() throws Exception {
        objectTest.rotate(true);

        assertTrue(0==1);
    }

}