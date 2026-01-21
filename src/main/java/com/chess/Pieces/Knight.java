package com.chess.Pieces;

import com.chess.Position.Position;
import com.chess.util.Color;

import static com.chess.util.ChessConstants.BOARD_SIZE;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    /**
     * Calculate all possible L-shaped moves for the Knight.
     * Knight moves in an L-shape: 2 squares in one direction and 1 square perpendicular.
     * This results in 8 possible moves:
     * - (+2, +1), (+2, -1), (-2, +1), (-2, -1) - Two squares vertical, one horizontal
     * - (+1, +2), (+1, -2), (-1, +2), (-1, -2) - One square vertical, two horizontal
     * 
     * Knight is the only piece that can "jump over" other pieces.
     * 
     * @param current The current position of the Knight
     * @return ArrayList of all possible positions the Knight can move to
     */
    @Override
    public ArrayList<Position> possibleMove(Position current) {
        ArrayList<Position> moves = new ArrayList<>();
        
        int currentX = current.getxPosition();
        int currentY = current.getyPosition();
        
        // Eight possible L-shaped moves: {dx, dy}
        int[][] knightMoves = {
            {2, 1},   // 2 up, 1 right
            {2, -1},  // 2 up, 1 left
            {-2, 1},  // 2 down, 1 right
            {-2, -1}, // 2 down, 1 left
            {1, 2},   // 1 up, 2 right
            {1, -2},  // 1 up, 2 left
            {-1, 2},  // 1 down, 2 right
            {-1, -2}  // 1 down, 2 left
        };
        
        // Check each possible L-shaped move
        for (int[] move : knightMoves) {
            int x = currentX + move[0];
            int y = currentY + move[1];
            
            // Check if the position is within board boundaries
            if (x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE) {
                moves.add(new Position(x, y));
            }
        }
        
        return moves;
    }
    
}
