package src.main.java.com.chess.Pieces;

import src.main.java.com.chess.Position.Position;
import src.main.java.com.chess.util.Color;

import static src.main.java.com.chess.util.ChessConstants.BOARD_SIZE;

import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(Color color) {
        super(color);
    }
    
    /**
     * Calculate all possible moves for the Queen.
     * Queen combines the movement of Rook and Bishop, moving in eight directions:
     * - Four straight lines: Up, Down, Left, Right (like Rook)
     * - Four diagonals: Top-right, Top-left, Bottom-right, Bottom-left (like Bishop)
     * 
     * @param current The current position of the Queen
     * @return ArrayList of all possible positions the Queen can move to
     */
    @Override
    public ArrayList<Position> possibleMove(Position current) {
        ArrayList<Position> moves = new ArrayList<>();
        
        int currentX = current.getxPosition();
        int currentY = current.getyPosition();
        
        // Eight directions: {dx, dy}
        // Straight lines (Rook-like) + Diagonals (Bishop-like)
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
        
        // For each direction
        for (int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];
            
            // Move along the direction until reaching the board edge
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
