package TTTGame;

import model.modelToView.IViewManager;

/**
 * This TTTViewManager class implements IViewManager interface.
 * A concrete solution of printing game ending messages.
 */

public class TTTViewManager implements IViewManager {

    public void draw() {
        System.out.println("Draw");
    }

    public void win(int player) {
        System.out.println("Player " + player + " wins!");
    }

    public void reset() {
        System.out.println("Game resetted");
    }
}
