package model.board;

import gameIO.IGameModel;

import model.move.IBoardStatusVisitor;
import model.move.ICheckMoveVisitor;
import model.move.IUndoMove;


import java.util.ArrayList;

import java.util.List;
import java.util.Random;



/**
 * This Class is a concrete game implementation of Tic Tac Toe Game.
 * It extends the ABoardModel.
 *
 * @author Dehu Kong, Xiang Lin, Jingwen Zhang
 */
public class TTTBoard extends ABoardModel {

    /**
     * This is TTTBoard constructor
     * @param n extension param from abstract class
     * @param n2 extension param from abstract class
     * @param host extension param from abstract class
     */
    public TTTBoard(int n, int n2, IGameModel host) {
        super(n, n2, host);
        this.reset();
    }

    /**
     * This method checks each move of players and returns the game state.
     * A concrete implementation of abstract class
     *
     * @param row input row
     * @param col input column
     * @param player which player's turn
     * @param p3 check if the move is valid
     * @param p4 check game state
     * @return return null
     */
    @Override
    public IUndoMove makeMove(int row, int col, int player, ICheckMoveVisitor p3, IBoardStatusVisitor p4) {
        if (isValidMove(player, row, col)) {

            p3.validMoveCase();
            if (winGame(1)) {
                System.out.println("player0 win");
                displayBoard();
                p4.player0WonCase(this, this);
                this.reset();
            } else if (winGame(2)) {
                System.out.println("player1 win");
                displayBoard();
                p4.player1WonCase(this, this);
                this.reset();
            } else if (checkDraw()) {
                System.out.println("Draw");
                displayBoard();
                p4.drawCase(this, this);
                this.reset();
            } else {
                System.out.println("NO WINNER");
                displayBoard();
                p4.noWinnerCase(this, this);
            }
        } else {
            System.out.println("Invalid move!");
            p3.invalidMoveCase();
        }
        return null;
    }

    /**
     * This method check if the move is valid.
     *
     * @param row input row
     * @param col input column
     * @param player which player's turn
     * @return return true if the move is valid else false
     */
    public boolean isValidMove(int player, int row, int col){
        if(row < 0 || row > 2 || col < 0 || col > 2 ){
            return false;
        }
        if (cells[row][col] == 0) {
            if (player == 1){
                cells[row][col] =1;
                return true;
            }
            else{ //for computer
                List<int[]> ls = new ArrayList<int[]>();
                for(int i = 0; i < 3 ; i++){
                    for(int j = 0; j < 3;j ++) {
                        if(cells[i][j]==0){
                            ls.add(new int[]{i,j});
                        }
                    }
                }
                if(ls.size()==0){
                    return false;
                }
                Random rand = new Random();
                int idx = rand.nextInt(ls.size());
                cells[ls.get(idx)[0]][ls.get(idx)[1]]=2;
                return true;
            }

        }

        return false;
    }


    /**
     * This method print the board onto the console
     */
    private void displayBoard() {
        System.out.print("    ");
        for(int i =0; i < cells.length; ++i) {
            System.out.print(" " +i + "   ");
        }
        // Print Board separators and pieces:
        System.out.println("\n   ----------------");
        for (int i = 0; i < cells.length; i++) {
            System.out.print(i);
            for (int j = 0; j < cells.length; j++) {
                if(cells[i][j] == 1 )System.out.print(  "   \u25EF  ");
                else if (cells[i][j] == 2){
                    System.out.print(  "   *  ");
                }
                else{
                    System.out.print(  "   _  ");
                }
            }
            System.out.println("\n   ----------------");
        }
    }


    /**
     * This method checks the win condition for the game.
     *
     * @param player which player's turn
     * @return return true if the player won
     */
    public boolean winGame(int player){
        for (int i = 0; i < 3; i++) {
            if(cells[i][0] == cells[i][1] && cells[i][0] == cells[i][2] && cells[i][0] ==player){//roweise
                return true;
            }
            if(cells[0][i] == cells[1][i] && cells[0][i] == cells[2][i] && cells[0][i] ==player){//colwise
                return true;
            }
            if(cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2] && cells[2][2] == player) {//diagonal
                return true;
            }
            if(cells[2][0] == cells[1][1] && cells[1][1] == cells[0][2] && cells[0][2] == player){//offdiagonal
                return true;
            }
        }
        return false;
    }

    /**
     * This method reset the board
     *
     */
    public void reset() {
        super.reset();
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++){
                cells[i][j]  =0 ;
            }
        }
    }

    /**
     * This method checks if the game is in draw condition
     *
     * @return true if the game is draw
     */
    private boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j< 3 ; j++) {
                if(cells[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
