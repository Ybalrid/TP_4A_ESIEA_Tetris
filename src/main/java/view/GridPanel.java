package view;

import game.Game;
import model.Grid;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kuro on 10/03/16.
 */
public class GridPanel extends JPanel {

    private Grid grid;

    public GridPanel(Game game) {
        //this.grid = game.getGrid();
        this.add(new JButton("Hello"));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.dispose();
    }
}
