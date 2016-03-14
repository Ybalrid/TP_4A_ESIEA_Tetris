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
    private final static int CELL_SIZE = 20;
    /** T: purple, O: yellow, I: cyan, L: orange, J: blue, S: green, Z: red */
    private final Color[] tetrominoColors = new Color[] {
    	new Color(150, 50, 150),
        new Color(200, 200, 0),
        new Color(50, 180, 180),
        new Color(230, 160, 0),
        new Color(50, 50, 230),
        new Color(80, 230, 20),
        new Color(220, 13, 25)};

    public GridPanel(Game game) {
        this.grid = game.getGrid();
        this.setPreferredSize(new Dimension(CELL_SIZE * this.grid.getWidth(), CELL_SIZE * this.grid.getHeight()));
        //this.add(new JButton("Hello"));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int val;
        for (int i = 0; i < this.grid.getWidth(); i++) {
            for (int j = 0; j < this.grid.getHeight(); j++) {
                val = this.grid.get(new Position(i, j));
                g2.setColor(this.tetrominoColors[val]);
                g2.drawRect(CELL_SIZE * i, CELL_SIZE * j, CELL_SIZE, CELL_SIZE);
            }

        }

        g2.dispose();
    }
}
