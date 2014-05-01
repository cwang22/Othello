
package ass3;

import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author wang w
 */
class GameState extends CellMatrix {

    Player currentPlayer;
    Player opponent;
    boolean hasWon;

    public GameState() {

        currentPlayer = player2;
        opponent = player1;
        hasWon = false;
    }

    public void newGame() {
        createBoardView();

    }

    public void createBoardView() {
        pieceMatrix[3][3] = 2;
        pieceMatrix[4][4] = 2;
        pieceMatrix[3][4] = 1;
        pieceMatrix[4][3] = 1;
        print();
        while (hasWon == false) {
            updateBoardView();

        }

    }
  

    void placeDisc(Player currentPlayer) {
        displayCurrentPlayer();
        Scanner s = new Scanner(System.in);
        int myRow = s.nextInt();
        int myCol = s.nextInt();
        int row = myRow - 1;
        int col = myCol - 1;
        if (pieceMatrix[row][col] == 1 || pieceMatrix[row][col] == 2) {
            System.out.println("this cell already has a disc, please try other cells");
            placeDisc(currentPlayer);
        }else
        resetMatrix(row, col, currentPlayer.color, true);

    }

    public void updateBoardView() {

        new Controller().tryMove();
        boolean playerOneMove = new Controller().playerOneCanMove();
        boolean playerTwoMove = new Controller().playerTwoCanMove();
        //playerOneCanMove();
        //playerTwoCanMove();
        System.out.println(playerOneMove);
        System.out.println(playerTwoMove);

        if (currentPlayer == player1 && playerTwoMove == true) {
            opponent = player1;
            currentPlayer = player2;

            // placeDisc(currentPlayer);
        } else if (currentPlayer == player2 && playerOneMove == true) {
            opponent = player2;
            currentPlayer = player1;

            // placeDisc(currentPlayer);
        } else if (currentPlayer == player1 && playerTwoMove == false) {
            currentPlayer = player1;

            // placeDisc(currentPlayer);
        } else if (currentPlayer == player2 && playerOneMove == false) {
            currentPlayer = player2;

            //placeDisc(currentPlayer);
        } else {
            hasWon = true;

        }
        placeDisc(currentPlayer);

    }

    public void resetMatrix(int row, int col, int currentColor, boolean actualMove) {

        if (getValidMove(row, col, currentColor, actualMove)) {

            print();
        } else {
            currentPlayer = opponent;
        }

    }

    public void displayCurrentPlayer() {
        System.out.println("it is " + currentPlayer.name + " turn");
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

        if (legalMove && actualMove) //If the move was legal
        {
            setPieceCell(placedRow, placedColumn, currentColor); //Keep the placed coin

        }

        return legalMove;
    }

 
}
