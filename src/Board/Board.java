package src.Board;

import src.Pieces.Pawn;
import src.Position.Position;
import src.assets.Color;

import static java.lang.Math.abs;
import static src.ChessConstants.BLACK_PAWN_ROW;
import static src.ChessConstants.BOARD_SIZE;
import static src.ChessConstants.WHITE_PAWN_ROW;

public class Board {
    private Position[][] board;

    public Board (){
        this.board = new Position[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new Position(i, j);
            }
        }
        // initPiecesOnBoard();
    }


    public void initPiecesOnBoard(Board b) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i][WHITE_PAWN_ROW].setPieceContained(new Pawn(Color.WHITE));
            board[i][BLACK_PAWN_ROW].setPieceContained(new Pawn(Color.BLACK));
        }
    }

    /**
     * To check if there is a piece between two squares on board.
     * @param startPosition
     * @param targetPosition
     * @return boolean
     */
    public boolean hasPieceBetween(Position startPosition, Position targetPosition) {
        int startRow = startPosition.getxPosition();
        int startCol = startPosition.getyPosition();
        int targetRow = targetPosition.getxPosition();
        int targetCol = targetPosition.getyPosition();

        if (startRow == targetRow && startCol == targetCol){
            return false;
        }

        if (startRow == targetRow || 
            startCol == targetCol || 
            abs(targetRow - startRow) == abs(targetCol - startCol)){
            int rowStep =  Integer.compare(targetRow, startRow);
            int colStep = Integer.compare(targetCol, startCol);
            int currRow = startRow + rowStep;
            int currCol = startCol + colStep;

            while (targetCol != currCol || targetRow != currRow) {
                if (board[currRow][currCol].getPieceContained() != null){
                    return true;
                }
                currRow += rowStep;
                currCol += colStep;
            }
            return false;
        }
        return true;
    }

}
