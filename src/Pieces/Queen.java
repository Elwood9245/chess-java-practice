package src.Pieces;

import src.Position.Position;
import src.assets.Color;

import static src.ChessConstants.BOARD_SIZE;

import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(Color color) {
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

        for (int x = 0; x < BOARD_SIZE; ++x){
            if (x != current.getxPosition()){
                moves.add(new Position(x, current.getyPosition()));
            }
        }

        for (int y = 0; y < BOARD_SIZE; ++y){
            if (y != current.getyPosition()){
                moves.add(new Position(current.getxPosition(), y));
            }
        }
        return moves;
    }


}
