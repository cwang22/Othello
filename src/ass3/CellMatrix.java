
package ass3;

/**
 *
 * @author wang w
 */
public class CellMatrix {
    protected int[][] pieceMatrix = new int[8][8]; 
	protected int Black = 1;
        protected int White = 2;
        protected Player player1;
        protected Player player2;
        
	CellMatrix ()
	{
            player1 = new Player(Black, "Player1");
            player2 = new Player(White, "Player2");
	}
	
     
        public void print() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieceMatrix[i][j] == 1) {
                    System.out.print("X ");
                } else if (pieceMatrix[i][j] == 2) {
                    System.out.print("O ");
                } else {
                    System.out.print("- ");
                }

            }
            System.out.println();
        }
    }
        
        public int getPieceCell(int row, int column) {
        return pieceMatrix[row][column];
    }

    public void setPieceCell(int row, int column, int piece) {
        pieceMatrix[row][column] = piece;
    }


        
	
   
      public boolean getValidMove(int placedRow, int placedColumn, int currentColor, boolean actualMove) {
        boolean legalMove = false;
       
        return legalMove;
    }
 
    

    protected boolean checkNorthRoute(int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove) {

        int currentPiece = 0, squaresTakeOver = 0; 
        int row = placedRow - 1; 
        boolean pairCoinFound = false; 

        while (row >= 0 && !pairCoinFound) 
        {

            currentPiece = getPieceCell(row, placedColumn);	

            if (currentPiece == 0) 
            {
                return false;
            } else if (currentPiece == enemy)
            {
                squaresTakeOver++;
            } else 
            {
                pairCoinFound = true;
            }

            row--; 

        }

        if (pairCoinFound && squaresTakeOver > 0) 
        {
            if (actualMove) {

                do 
                {

                    placedRow--; 
                    squaresTakeOver--; 
                    setPieceCell(placedRow, placedColumn, currentPlayer); //Change the current cell into the current player's coin

                } while (squaresTakeOver > 0);
            }
            return true; //Move was legal

        } else {
            return false;
        }

    }

    protected boolean checkNorthWestRoute(int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove) 
    {

        int currentPiece = 0, squaresTakeOver = 0;
        int row = placedRow - 1;
        int column = placedColumn - 1;
        boolean pairCoinFound = false;

        while (row >= 0 && column >= 0 && !pairCoinFound) {

            currentPiece = getPieceCell(row, column);

            if (currentPiece == 0) {
                return false;
            } else if (currentPiece == enemy) {
                squaresTakeOver++;
            } else {
                pairCoinFound = true;
            }

            row--;
            column--;

        }

        if (pairCoinFound && squaresTakeOver > 0) {
            if (actualMove) {
                do {

                    placedRow--;
                    placedColumn--;
                    squaresTakeOver--;
                    setPieceCell(placedRow, placedColumn, currentPlayer);

                } while (squaresTakeOver > 0);
            }
            return true;

        } else {
            return false;
        }

    }

    protected boolean checkWestRoute(int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove)
    {

        int currentPiece = 0, squaresTakeOver = 0;
        int column = placedColumn - 1;
        boolean pairCoinFound = false;

        while (column >= 0 && !pairCoinFound) {

            currentPiece = getPieceCell(placedRow, column);

            if (currentPiece == 0) {
                return false;
            } else if (currentPiece == enemy) {
                squaresTakeOver++;
            } else {
                pairCoinFound = true;
            }

            column--;

        }

        if (pairCoinFound && squaresTakeOver > 0) {
            if (actualMove) {
                do {

                    placedColumn--;
                    squaresTakeOver--;
                    setPieceCell(placedRow, placedColumn, currentPlayer);

                } while (squaresTakeOver > 0);
            }
            return true;

        } else {
            return false;
        }

    }

    protected boolean checkSouthWestRoute(int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove) 
    {

        int currentPiece = 0, squaresTakeOver = 0;
        int row = placedRow + 1;
        int column = placedColumn - 1;
        boolean pairCoinFound = false;

        while (row <= 7 && column >= 0 && !pairCoinFound) {

            currentPiece = getPieceCell(row, column);

            if (currentPiece == 0) {
                return false;
            } else if (currentPiece == enemy) {
                squaresTakeOver++;
            } else {
                pairCoinFound = true;
            }

            row++;
            column--;

        }

        if (pairCoinFound && squaresTakeOver > 0) {
            if (actualMove) {
                do {

                    placedRow++;
                    placedColumn--;
                    squaresTakeOver--;
                    setPieceCell(placedRow, placedColumn, currentPlayer);

                } while (squaresTakeOver > 0);
            }
            return true;

        } else {
            return false;
        }

    }

    protected boolean checkSouthRoute(int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove) 
    {

        int currentPiece = 0, squaresTakeOver = 0;
        int row = placedRow + 1;
        boolean pairCoinFound = false;

        while (row <= 7 && !pairCoinFound) {

            currentPiece = getPieceCell(row, placedColumn);

            if (currentPiece == 0) {
                return false;
            } else if (currentPiece == enemy) {
                squaresTakeOver++;
            } else {
                pairCoinFound = true;
            }

            row++;

        }

        if (pairCoinFound && squaresTakeOver > 0) {
            if (actualMove) {
                do {

                    placedRow++;
                    squaresTakeOver--;
                    setPieceCell(placedRow, placedColumn, currentPlayer);

                } while (squaresTakeOver > 0);
            }
            return true;

        } else {
            return false;
        }

    }

    protected boolean checkSouthEastRoute(int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove)
    {

        int currentPiece = 0, squaresTakeOver = 0;
        int row = placedRow + 1;
        int column = placedColumn + 1;
        boolean pairCoinFound = false;

        while (row <= 7 && column <= 7 && !pairCoinFound) {

            currentPiece = getPieceCell(row, column);

            if (currentPiece == 0) {
                return false;
            } else if (currentPiece == enemy) {
                squaresTakeOver++;
            } else {
                pairCoinFound = true;
            }

            row++;
            column++;

        }

        if (pairCoinFound && squaresTakeOver > 0) {
            if (actualMove) {
                do {

                    placedRow++;
                    placedColumn++;
                    squaresTakeOver--;
                    setPieceCell(placedRow, placedColumn, currentPlayer);

                } while (squaresTakeOver > 0);
            }
            return true;

        } else {
            return false;
        }

    }

    protected boolean checkEastRoute(int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove) 
    {

        int currentPiece = 0, squaresTakeOver = 0;
        int column = placedColumn + 1;
        boolean pairCoinFound = false;

        while (column <= 7 && !pairCoinFound) {

            currentPiece = getPieceCell(placedRow, column);

            if (currentPiece == 0) {
                return false;
            } else if (currentPiece == enemy) {
                squaresTakeOver++;
            } else {
                pairCoinFound = true;
            }

            column++;

        }

        if (pairCoinFound && squaresTakeOver > 0) {
            if (actualMove) {
                do {

                    placedColumn++;
                    squaresTakeOver--;
                    setPieceCell(placedRow, placedColumn, currentPlayer);

                } while (squaresTakeOver > 0);
            }
            return true;

        } else {
            return false;
        }

    }

    protected boolean checkNorthEastRoute(int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove) 
    {

        int currentPiece = 0, squaresTakeOver = 0;
        int row = placedRow - 1;
        int column = placedColumn + 1;
        boolean pairCoinFound = false;

        while (row >= 0 && column <= 7 && !pairCoinFound) {

            currentPiece = getPieceCell(row, column);

            if (currentPiece == 0) {
                return false;
            } else if (currentPiece == enemy) {
                squaresTakeOver++;
            } else {
                pairCoinFound = true;
            }

            row--;
            column++;

        }

        if (pairCoinFound && squaresTakeOver > 0) {
            if (actualMove) {
                do {

                    placedRow--;
                    placedColumn++;
                    squaresTakeOver--;
                    setPieceCell(placedRow, placedColumn, currentPlayer);

                } while (squaresTakeOver > 0);
            }
            return true;

        } else {
            return false;
        }

    }
	
	
}
