package view;

import game.Game;
import model.Grid;
import model.Position;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kuro on 10/03/16.
 */
public class GridPanel extends JPanel {

    private Grid grid;
    private final Color[] tetrominoColors = new Color[7];

    public GridPanel(Game game) {
        this.grid = game.getGrid();
        this.add(new JButton("Hello"));
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
                //g2.setColor();
                g2.drawRect(10 * i, 10 * j, 10, 10);
            }

        }

        g2.dispose();
    }
}
