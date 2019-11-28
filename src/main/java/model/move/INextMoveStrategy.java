package model.move;



import gameIO.IGameModel;
import model.utility.*;

/**
 *	Algorithm to calculate the next move
 *  Strategy Design Pattern
 */
public interface INextMoveStrategy {

	/**
	 * 
	 * @param context : The IModel being used.
	 * @param player : The player whose move is being calculated.
	 * @return : Calculates the next move as a Point (x = column, y = row).
	 */
	public abstract model.utility.Point getNextMove(IGameModel context, int player);
	
}

