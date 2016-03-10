package model;

/**
 * Created by kuro on 10/03/16.
 */
public class Tetromino {

    private Position position;
    private int rotation; //0 -> 0°; 1->90°; 2->180°; 3->240°
    private int[][] shape;

    /** Possible values for type are [L,J,T,O,I,S,Z] */
    public Tetromino(char type, Position position, int rotation) {
        this.position = position;
        this.rotation = rotation;
        switch (type){
            case 'L':
                this.shape = new int[][] {{0,0,0,0},{1,1,1,0},{1,0,0,0},{0,0,0,0}};
                break;
            case 'J':
                this.shape = new int[][] {{0,0,0,0},{1,1,1,0},{0,0,1,0},{0,0,0,0}};
                break;
            case 'T':
                this.shape = new int[][] {{1,1,1,0},{0,1,0,0},{0,0,0,0},{0,0,0,0}};
                break;
            case 'O':
                this.shape = new int[][] {{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
                break;
            case 'I':
                this.shape = new int[][] {{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,0,0,0}};
                break;
            case 'S':
                this.shape = new int[][] {{0,0,0,0},{0,1,1,0},{1,1,0,0},{0,0,0,0}};
                break;
            case 'Z':
                this.shape = new int[][] {{0,0,0,0},{1,1,0,0},{0,1,1,0},{0,0,0,0}};
                break;
        }
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

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }


    /** Optionnal*/
    public int[][] getShape() {
        return shape;
    }

    public void setShape(int[][] shape) {
        this.shape = shape;
    }


}
