package TTTGame;

import model.modelToView.IRejectCommand;

/**
 * This TTTReject class implements IRejectCommand interface. A concrete solution of printing invalid move for TTT Game
 */
public class TTTReject implements IRejectCommand {
    public void execute() {
        System.out.println("Move is not valid!");
    }
}
