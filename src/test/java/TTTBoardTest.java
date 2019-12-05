import model.GameModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class TTTBoardTest {

    GameModel game = new GameModel(3, 3);

    @Test
    public void moveTest(){
        assertTrue(game.getBoardModel().isValidMove(1,0,1));
        assertFalse(game.getBoardModel().isValidMove(1,3,3));
    }

    @Test
    public void resetTest(){

        game.getBoardModel().reset();
        int count = 0 ;
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++){
                if(game.getBoardModel().getCells()[i][j] == 0){
                    count++;
                }
            }
        }

        assertEquals(9,count);
    }

}
