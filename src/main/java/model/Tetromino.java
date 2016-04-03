package model;

import java.util.Iterator;

/**
 * Created by Tenma on 10/03/16.
 */
public class Tetromino implements Iterable<Position> {

    private final TetrominoType type;
    private Position position;
    private int rotation; // 0 -> 0°; 1->90°; 2->180°; 3->270°
    private Position[] shape; // Must be 4x4 square

    private final static int SIZE = 4;

    /** Possible values for type are [L,J,T,O,I,S,Z] */
    public Tetromino(TetrominoType type, Position position) {
        this.position = position;
        this.rotation = 0;
        this.type = type;
        switch (type) {
            case L: this.shape = new Position[] {new Position(1,0), new Position(1,1), new Position(1,2), new Position(2,2)}; break;
            case J: this.shape = new Position[] {new Position(2,0), new Position(3,1), new Position(1,2), new Position(2,2)}; break;
            case T: this.shape = new Position[] {new Position(0,1), new Position(1,1), new Position(2,1), new Position(1,2)}; break;
            case O: this.shape = new Position[] {new Position(1,1), new Position(2,1), new Position(1,2), new Position(2,2)}; break;
            case I: this.shape = new Position[] {new Position(1,0), new Position(1,1), new Position(1,2), new Position(1,3)}; break;
            case S: this.shape = new Position[] {new Position(1,1), new Position(2,1), new Position(0,2), new Position(1,2)}; break;
            case Z: this.shape = new Position[] {new Position(0,1), new Position(1,1), new Position(1,2), new Position(2,2)}; break;
        }
    }

    public TetrominoType getType() {
        return type;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getRotation() {
        return rotation;
    }

    /** Optional */
    public Position[] getShape() {
        return shape;
    }

    public void rotate(boolean clockwise) {
        for (int i = 0; i < SIZE; i++) {
            if (clockwise) {
                this.shape[i].setX(SIZE - 1 - this.shape[i].getY());
                this.shape[i].setY(this.shape[i].getX());
            } else {
                this.shape[i].setX(this.shape[i].getY());
                this.shape[i].setY(SIZE - 1 - this.shape[i].getX());
            }
        }
        this.rotation += ((clockwise ? 1 : -1) + SIZE) % SIZE;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Position> iterator() {
        // No point implementing a whole class for something only used once
        return new Iterator<Position>() {
            private int count = 0;

            // No need to have constructor which takes MyClass, (non-static) inner class has access to instance members
            public boolean hasNext() {
                return count < SIZE;
            }
            public Position next() {
                return shape[count++];
            }

            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
}
