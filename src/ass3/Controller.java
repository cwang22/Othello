

package ass3;

import java.awt.Point;

/**
 *
 * @author wang w
 */
class Controller extends CellMatrix{
    private boolean playerOneCanMove = true, playerTwoCanMove = true;
    
    Controller(){
        
    }
    
    public void tryMove() //Checks each square until a legal move is found
    {

        playerOneCanMove = false;
        playerTwoCanMove = false;

        for (int row = 0; row < 8; row++) {

            for (int column = 0; column < 8; column++) {

                if (getPieceCell(row, column) != 0) {
                    continue;
                } else {

                    if (!playerOneCanMove) {
                        playerOneCanMove = getValidMove(row, column, Black, false);
                    }

                    if (!playerTwoCanMove) {
                        playerTwoCanMove = getValidMove(row, column, White, false);
                    }

                }

                if (playerOneCanMove && playerTwoCanMove)
                {
                    break;
                }

            }

            if (playerOneCanMove && playerTwoCanMove) {
                break;
            }

        }

    }
    
    public boolean playerOneCanMove() {
        return playerOneCanMove;
    }

    public boolean playerTwoCanMove() {
        return playerTwoCanMove;
    }
    
    
    public String finalResult(String namePlayer1, String namePlayer2) {

        int Black = 0;
        int White = 0;
        int currentCell = 0;

        for (int row = 0; row < 8; row++) {

            for (int column = 0; column < 8; column++) {

                currentCell = pieceMatrix[row][column];

                if (currentCell == 0) {
                    continue;
                } else if (currentCell == 1) {
                    Black++;
                } else {
                    White++;
                }

            }

        }

        if (Black > White) {
            return namePlayer1 + " with black has won, with a score of " + Black + ". " + namePlayer2 + " with white got " + White;
        } else if (White > Black) {
            return namePlayer2 + " with white has won, with a score of " + White + ". " + namePlayer1 + " with black got " + Black;
        } else {
            return "this game was a draw with both players getting a score of " + Black;
        }

    }
    
    @Override
     public boolean getValidMove(int placedRow, int placedColumn, int currentColor, boolean actualMove) {
        boolean legalMove = false;
        int enemyColor;

        if (currentColor == player1.color) {
            enemyColor = player2.color;
        } else {
            enemyColor = player1.color;
        }
        //Each possible direction is tested and any over takes possible are done. If at least one over take is possible, the move is legal
        if (checkNorthRoute(placedRow, placedColumn, currentColor, enemyColor, actualMove)) {
            legalMove = true;
        }

        if (checkNorthWestRoute(placedRow, placedColumn, currentColor, enemyColor, actualMove)) {
            legalMove = true;
        }

        if (checkWestRoute(placedRow, placedColumn, currentColor, enemyColor, actualMove)) {
            legalMove = true;
        }

        if (checkSouthWestRoute(placedRow, placedColumn, currentColor, enemyColor, actualMove)) {
            legalMove = true;
        }

        if (checkSouthRoute(placedRow, placedColumn, currentColor, enemyColor, actualMove)) {
            legalMove = true;
        }

        if (checkSouthEastRoute(placedRow, placedColumn, currentColor, enemyColor, actualMove)) {
            legalMove = true;
        }

        if (checkEastRoute(placedRow, placedColumn, currentColor, enemyColor, actualMove)) {
            legalMove = true;
        }

        if (checkNorthEastRoute(placedRow, placedColumn, currentColor, enemyColor, actualMove)) {
            legalMove = true;
        }

        return legalMove;
    }
    
}
