package com.chess.Pieces;

import com.chess.Position.Position;
import com.chess.util.Color;

import java.util.ArrayList;

public abstract class Piece {

    private Color color;
    private boolean hasMoved;


    public Piece(Color color){
        this.color = color;
        this.hasMoved = false;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public boolean isWhite (Piece piece) {
        return piece.getColor() == Color.WHITE;
    }

    public boolean isSameColor (Piece other) {
        return this.getColor() == other.color;
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }


    public ArrayList<Position> possibleMove(Position current) {
        return new ArrayList<>();
    }
}
