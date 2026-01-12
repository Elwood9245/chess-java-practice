package src.Pieces;

import src.Position.Position;
import src.assets.Color;

import static src.ChessConstants.BOARD_SIZE;

import java.util.ArrayList;

public class Bishop extends Piece{

    public Bishop (Color color) {
        super(color);
    }

    @Override
    public ArrayList<Position> possibleMove(Position current) {
        ArrayList<Position> moves = new ArrayList<>();

        for (int i = -7; i < BOARD_SIZE; ++i){
            if (i == 0) continue;

            int xTemp = current.getxPosition() + i;
            int yTemp = current.getyPosition() + i;

            if (xTemp < 0 || yTemp < 0 || xTemp > 7 || yTemp > 7){
                continue;
            }
            moves.add(new Position(xTemp, yTemp));
        }

        for (int i = -7; i < BOARD_SIZE; ++i){
            if (i == 0) continue;

            int xTemp = current.getxPosition() + i;
            int yTemp = current.getyPosition() - i;

            if (xTemp < 0 || yTemp < 0 || xTemp > 7 || yTemp > 7){
                continue;
            }
            moves.add(new Position(xTemp, yTemp));
        }

        return moves;
    }
}
