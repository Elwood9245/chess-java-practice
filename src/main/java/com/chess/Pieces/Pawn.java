package src.main.java.com.chess.Pieces;

import src.main.java.com.chess.Position.Position;
import src.main.java.com.chess.util.Color;

import static src.main.java.com.chess.util.ChessConstants.*;

import java.util.ArrayList;

public class Pawn extends Piece{

    public Pawn(Color color){
        super(color);
    }

    /**
     * Calculate all possible moves for the Pawn.
     * 
     * Forward Movement:
     * - White pawns move up (x increases), Black pawns move down (x decreases)
     * - Can move 1 square forward if target square is empty
     * - Can move 2 squares forward from starting position if both squares are empty
     * 
     * Capture Movement:
     * - Can capture diagonally forward (one square diagonally)
     * - Left-forward and right-forward diagonal
     * 
     * Special rules (handled separately):
     * - En Passant: Capture a pawn that just moved 2 squares
     * - Promotion: When reaching the opposite end of the board
     * 
     * Note: The actual validation (empty square for forward move, enemy piece for capture)
     * should be done in the Board's isValidMove method.
     * 
     * @param current The current position of the Pawn
     * @return ArrayList of all possible positions the Pawn can move to
     */
    @Override
    public ArrayList<Position> possibleMove(Position current) {
        ArrayList<Position> moves = new ArrayList<>();
        
        int currentX = current.getxPosition();
        int currentY = current.getyPosition();
        
        // Determine direction based on color
        // White moves up (x increases), Black moves down (x decreases)
        int direction = (getColor() == Color.WHITE) ? 1 : -1;
        
        // Forward move: one square
        int forwardX = currentX + direction;
        if (forwardX >= 0 && forwardX < BOARD_SIZE) {
            moves.add(new Position(forwardX, currentY));
        }
        
        // Forward move: two squares (only if pawn hasn't moved)
        if (!getHasMoved()) {
            int startRow = (getColor() == Color.WHITE) ? WHITE_PAWN_ROW : BLACK_PAWN_ROW;
            if (currentX == startRow) {
                int doubleForwardX = currentX + (2 * direction);
                if (doubleForwardX >= 0 && doubleForwardX < BOARD_SIZE) {
                    moves.add(new Position(doubleForwardX, currentY));
                }
            }
        }
        
        // Diagonal captures: left-forward and right-forward
        int captureX = currentX + direction;
        if (captureX >= 0 && captureX < BOARD_SIZE) {
            // Left diagonal
            int leftY = currentY - 1;
            if (leftY >= 0) {
                moves.add(new Position(captureX, leftY));
            }
            
            // Right diagonal
            int rightY = currentY + 1;
            if (rightY < BOARD_SIZE) {
                moves.add(new Position(captureX, rightY));
            }
        }
        
        return moves;
    }

}
