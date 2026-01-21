package com.chess.Pieces;

import com.chess.Position.Position;
import com.chess.util.Color;

import static com.chess.util.ChessConstants.BOARD_SIZE;

import java.util.ArrayList;

public class Rook extends Piece{
    public Rook (Color color) {
        super(color);
    }

    /**
     * Calculate all possible horizontal and vertical moves for the Rook.
     * Rook moves in straight lines in four directions:
     * - Up (++x, same y)
     * - Down (--x, same y)
     * - Right (same x, ++y)
     * - Left (same x, --y)
     * 
     * @param current The current position of the Rook
     * @return ArrayList of all possible positions the Rook can move to
     */
    @Override
    public ArrayList<Position> possibleMove(Position current) {
        ArrayList<Position> moves = new ArrayList<>();
        
        int currentX = current.getxPosition();
        int currentY = current.getyPosition();
        
        // Four straight directions: {dx, dy}
        int[][] directions = {
            {1, 0},   // Up
            {-1, 0},  // Down
            {0, 1},   // Right
            {0, -1}   // Left
        };
        
        // For each straight direction
        for (int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];
            
            // Move along the line until reaching the board edge
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
