package src.Pieces;

import src.Position.Position;
import src.assets.Color;

import static src.ChessConstants.BOARD_SIZE;

import java.util.ArrayList;

public class King extends Piece {
    public King(Color color) {
        super(color);
    }

    /**
     * Calculate all possible moves for the King.
     * King can move exactly one square in any direction:
     * - Four straight directions: Up, Down, Left, Right
     * - Four diagonal directions: Top-right, Top-left, Bottom-right, Bottom-left
     * 
     * Note: This does not include castling, which is a special move.
     * 
     * @param current The current position of the King
     * @return ArrayList of all possible positions the King can move to
     */
    @Override
    public ArrayList<Position> possibleMove(Position current) {
        ArrayList<Position> moves = new ArrayList<>();
        
        int currentX = current.getxPosition();
        int currentY = current.getyPosition();
        
        // Eight directions: {dx, dy}
        // King moves one square in any direction
        int[][] directions = {
            {1, 0},   // Up
            {-1, 0},  // Down
            {0, 1},   // Right
            {0, -1},  // Left
            {1, 1},   // Top-right diagonal
            {-1, 1},  // Top-left diagonal
            {1, -1},  // Bottom-right diagonal
            {-1, -1}  // Bottom-left diagonal
        };
        
        // For each direction, move only one square
        for (int[] dir : directions) {
            int x = currentX + dir[0];
            int y = currentY + dir[1];
            
            // Check if the position is within board boundaries
            if (x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE) {
                moves.add(new Position(x, y));
            }
        }
        
        return moves;
    }

}
