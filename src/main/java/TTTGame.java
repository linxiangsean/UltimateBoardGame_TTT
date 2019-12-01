
import java.util.List;

import model.GameModel;
import model.modelToView.TTTViewManager;
import model.modelToView.TTTCommand;
import model.viewToModel.TTTTurnManager;


/**
 * This is the main function of the game entry.
 *
 * @author Dehu Kong, Xiang Lin, Jingwen Zhang
 */
public class TTTGame {
    public static void main(String[] args) {
        GameModel game = new GameModel(3, 3);
        game.setViewManager(new TTTViewManager(), new TTTTurnManager());
        game.setCommand(new TTTCommand());
        List<Object> players = game.getPlayers();
        game.setPlayers(players.get(0), players.get(1));
    }
}
