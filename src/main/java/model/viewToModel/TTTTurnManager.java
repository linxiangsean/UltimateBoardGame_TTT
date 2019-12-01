package model.viewToModel;

import model.modelToView.IRejectCommand;
import model.modelToView.TTTReject;
import java.util.Scanner;

/**
 * This TTTTurnManager class implements ITurnManager interface.
 * A concrete solution of managing player turns.
 */
public class TTTTurnManager implements ITurnManager {

    IRejectCommand reject;
    static Scanner sc;

    /**
     * Constructor of turnmanager
     */
    public TTTTurnManager() {
        super();
        reject = new TTTReject();
    }

    /**
     * Allows the Human player to select a piece and a location to move said piece
     * @param requestor: The requester used by the view to communicate which move it wishes to try
     */
    public void takeTurn(IViewRequestor requestor) {
        int rowVal, colVal;
        String row, col;
        sc = new Scanner(System.in);

        System.out.println("Player, enter your choice of row from (0, 1, 2)");
        while(true) {
            try {
                row = sc.nextLine();
                rowVal = Integer.parseInt(row);
                break;
            } catch (Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
        System.out.println("Player, enter your chocie of col from (0, 1, 2)");
        while(true) {
            try{
                col = sc.nextLine();
                colVal = Integer.parseInt(col);
                break;
            }catch(Exception e) {
                System.out.println("Please enter an integer.");
            }
        }

        requestor.setTokenAt(rowVal, colVal, reject);
    }


}
