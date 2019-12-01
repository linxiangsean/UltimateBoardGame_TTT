package model.modelToView;

/**
 * This TTTCommand class implements Icommand interface. A concrete solution of printing command for TTT Game
 */
public class TTTCommand implements ICommand {
    public void setTokenAt(int row, int col, int player) {
        System.out.println("Player " + player + " set token at: "+ row + ", " + col);
    }

    public void clearTokenAt(int row, int col) {
    }

    public void setMessage(String s) {
    }
}
