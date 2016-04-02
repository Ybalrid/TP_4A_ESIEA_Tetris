package view;

import game.Game;
import model.Grid;
import model.Position;
import model.TetrominoType;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kuro on 10/03/16.
 */
public class GridPanel extends JPanel {

    private Grid grid;
    private final static int CELL_SIZE = 25;
    private final static Color GRID_COLOR = Color.DARK_GRAY;
    /** T: purple, O: yellow, I: cyan, L: orange, J: blue, S: green, Z: red */
    private final static Color[] TETROMINO_COLORS = new Color[] {
    	new Color(150, 50, 150),
        new Color(200, 200, 0),
        new Color(50, 180, 180),
        new Color(230, 160, 0),
        new Color(50, 50, 230),
        new Color(80, 230, 20),
        new Color(220, 13, 25)};

    public GridPanel(Game game) {
        this.grid = game.getGrid();
        this.setPreferredSize(new Dimension(CELL_SIZE * this.grid.getWidth(), CELL_SIZE * (this.grid.getHeight() - 1)));
        this.grid.set(new Position(3,3), TetrominoType.Z.ordinal());
        this.grid.set(new Position(1,2), TetrominoType.I.ordinal());
        this.grid.set(new Position(1,4), TetrominoType.L.ordinal());
        this.grid.set(new Position(1,1), TetrominoType.O.ordinal());
        this.grid.set(new Position(4,5), TetrominoType.T.ordinal());
        this.grid.set(new Position(7,2), TetrominoType.S.ordinal());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int height = this.grid.getHeight()-1, width = this.grid.getWidth();

        g2.setColor(GRID_COLOR);
        for (int i = 0; i < width; i++)
            g2.drawLine(CELL_SIZE * i, 0, CELL_SIZE * i, height * CELL_SIZE);
        for (int i = 0; i < height; i++)
            g2.drawLine(0, CELL_SIZE * i, width * CELL_SIZE, CELL_SIZE * i);

        g2.setStroke(new BasicStroke(5));
        int val;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                val = this.grid.get(new Position(i, j));
                if (val > Grid.DEFAULT_GRID_VALUE) {
                    g2.setColor(TETROMINO_COLORS[val]);
                    g2.fillRect(CELL_SIZE * i + 1, CELL_SIZE * j + 1, CELL_SIZE - 1, CELL_SIZE - 1);
                }
            }
        }

        g2.dispose();
    }
}
