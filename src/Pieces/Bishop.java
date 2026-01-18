package src.Pieces;

import src.Position.Position;
import src.assets.Color;

import static src.ChessConstants.BOARD_SIZE;

import java.util.ArrayList;

public class Bishop extends Piece{

    public Bishop (Color color) {
        super(color);
    }

    /**
     * Calculate all possible diagonal moves for the Bishop.
     * Bishop moves diagonally in four directions: 
     * - Top-right (++x, ++y)
     * - Top-left (--x, ++y)
     * - Bottom-right (++x, --y)
     * - Bottom-left (--x, --y)
     * 
     * @param current The current position of the Bishop
     * @return ArrayList of all possible positions the Bishop can move to
     */
    @Override
    public ArrayList<Position> possibleMove(Position current) {
        ArrayList<Position> moves = new ArrayList<>();
        
        int currentX = current.getxPosition();
        int currentY = current.getyPosition();
        
        // Four diagonal directions: {dx, dy}
        int[][] directions = {
            {1, 1},   // Top-right
            {-1, 1},  // Top-left
            {1, -1},  // Bottom-right
            {-1, -1}  // Bottom-left
        };
        
        // For each diagonal direction
        for (int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];
            
            // Move along the diagonal until reaching the board edge
            int x = currentX + dx;
            int y = currentY + dy;
            
            while (x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE) {
                moves.add(new Position(x, y));
                x += dx;
                y += dy;
            }
        }
        
        return moves;
    }
}
