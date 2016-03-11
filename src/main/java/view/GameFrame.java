package view;

import game.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kuro on 10/03/16.
 */
public class GameFrame extends JFrame {

    private JPanel gamePanel;

    public GameFrame(Game game) throws HeadlessException {
        super("Tetris");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.gamePanel = new JPanel();
        this.gamePanel.add(new GridPanel(game));
        this.gamePanel.add(new SidePanel(game));
        this.add(this.gamePanel);

        this.setVisible(true);
        this.pack();
    }
}
