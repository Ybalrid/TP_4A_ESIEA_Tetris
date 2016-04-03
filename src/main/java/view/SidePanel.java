package view;

import game.Game;
import game.ScoreObserver;

import javax.swing.*;

/**
 * Created by Tenma on 10/03/16.
 */
public class SidePanel extends JPanel implements ScoreObserver {

    private Game game;

    public SidePanel(Game game) {
        this.game = game;
        this.add(new JLabel("Score"));
    }

    @Override
    public void scoreChanged() {
        this.repaint();
    }
}
