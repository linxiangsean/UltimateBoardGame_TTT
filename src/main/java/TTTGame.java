package main.java;

import java.util.List;

import java.model.GameModel;
import main.java.model.modelToView.CheckersViewManager;
import main.java.model.modelToView.Command;
import main.java.model.viewToModel.CheckersTurnManager;

public class CheckersGame {
    public static void main(String[] args) {
        GameModel game = new GameModel(3, 3);
        game.setViewManager(new CheckersViewManager(), new CheckersTurnManager());
        game.setCommand(new Command());
        List<Object> players = game.getPlayers();
        game.setPlayers(players.get(0), players.get(1));
    }
}
