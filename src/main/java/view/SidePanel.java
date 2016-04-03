package view;

import game.Game;

import javax.swing.*;

/**
 * Created by kuro on 10/03/16.
 */
public class SidePanel extends JPanel {

    private Game game;

    public SidePanel(Game game) {
        this.game = game;
        this.add(new JLabel("Score"));
    }
}
