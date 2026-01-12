package src.Pieces;

import src.Position.Position;
import src.assets.Color;

import java.util.ArrayList;

public class Rook extends Piece{
    public Rook (Color color) {
        super(color);
    }

    @Override
    public ArrayList<Position> possibleMove(Position current) {
        ArrayList<Position> moves = new ArrayList<>();

        for (int x = 0; x < 8; ++x){
            if (x != current.getxPosition()){
                moves.add(new Position(x, current.getyPosition()));
            }
        }

        for (int y = 0; y < 8; ++y){
            if (y != current.getyPosition()){
                moves.add(new Position(current.getxPosition(), y));
            }
        }
        return moves;
    }
}
