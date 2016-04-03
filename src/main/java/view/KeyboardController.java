package view;

import game.Game;
import model.Position;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Tenma on 10/03/16.
 */
public class KeyboardController {

    private final JComponent guiComponent;
    private final Game game;

    public KeyboardController (JComponent comp, Game game) {

        this.guiComponent = comp;
        this.game = game;

        // Global input map
        InputMap inputMap = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = comp.getActionMap();

        // Ctrl+C: copy
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "MoveLeft");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "MoveRight");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "Fall");
        inputMap.put(KeyStroke.getKeyStroke("S"), "RotateAntiClockwise");
        inputMap.put(KeyStroke.getKeyStroke("D"), "RotateClockwise");

        actionMap.put("MoveLeft", new MoveLeftAction());
        actionMap.put("MoveRight", new MoveRightAction());
        actionMap.put("MoveDown", new MoveDownAction());
        actionMap.put("RotateAntiClockwise", new RotateAntiClockwiseAction());
        actionMap.put("RotateClockwise", new RotateClockwiseAction());
    }

    private class MoveLeftAction extends AbstractAction {
        @Override public void actionPerformed(ActionEvent evt) {
            game.getActiveTetromino().move(-1, 0);

        }
    }

    private class MoveRightAction extends AbstractAction {
        @Override public void actionPerformed(ActionEvent evt) {
            game.getActiveTetromino().move(1, 0);
        }
    }

    private class MoveDownAction extends AbstractAction {
        @Override public void actionPerformed(ActionEvent evt) {
            game.getActiveTetromino().move(0, 1);
        }
    }

    private class RotateAntiClockwiseAction extends AbstractAction {
        @Override public void actionPerformed(ActionEvent evt) {
            game.getActiveTetromino().rotate(false);
        }
    }

    private class RotateClockwiseAction extends AbstractAction {
        @Override public void actionPerformed(ActionEvent evt) {
            game.getActiveTetromino().rotate(true);
        }
    }
}
