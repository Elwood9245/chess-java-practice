package com.chess.Board;

import com.chess.Pieces.*;
import com.chess.Position.Position;
import com.chess.util.Color;

import static java.lang.Math.abs;
import static com.chess.util.ChessConstants.*;

public class Board {
    private Position[][] board;

    public Board (){
        this.board = new Position[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new Position(i, j);
            }
        }
        initPiecesOnBoard(this);
    }


    public void initPiecesOnBoard(Board b) {

        Class<?>[] backRowPieces = {
                Rook.class, Knight.class, Bishop.class, Queen.class,
                King.class, Bishop.class, Knight.class, Rook.class
        };

        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i][WHITE_PAWN_ROW].setPieceContained(new Pawn(Color.WHITE));

            try {
                Piece piece = (Piece) backRowPieces[i].getConstructor(Color.class).newInstance(Color.WHITE);
                board[i][WHITE_KING_ROW].setPieceContained(piece);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i][BLACK_PAWN_ROW].setPieceContained(new Pawn(Color.BLACK));

            try {
                Piece piece = (Piece) backRowPieces[i].getConstructor(Color.class)
                        .newInstance(Color.BLACK);
                board[i][BLACK_KING_ROW].setPieceContained(piece);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
