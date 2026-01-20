package com.chess.Position;

import com.chess.Pieces.Piece;

public class Position {
    private int xPosition;
    private int yPosition;
    private Piece pieceContained;

    public Position(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.pieceContained = null;
    }

//    public void setxPosition(int xPosition) {
//        if (0 < xPosition && xPosition < BOARD_SIZE) {
//            this.xPosition = xPosition;
//        }
//        else throw new IllegalArgumentException("The number must between 0-7.");
//    }
//
//    public void setyPosition(int yPosition) {
//        if (0 < yPosition && yPosition < BOARD_SIZE) {
//            this.yPosition = yPosition;
//        }
//        else throw new IllegalArgumentException("The number must between 0-7.");
//    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public Piece getPieceContained() {
        return pieceContained;
    }

    public void setPieceContained(Piece p) {
        this.pieceContained = p;
    }

    public void delPieceContained() {
        this.pieceContained = null;
    }


    @Override
    public String toString() {
        return String.format("%c%d", (char)(getyPosition() + 'a'), getxPosition() + 1);
    }
}

