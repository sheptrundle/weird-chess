package GameSetup.Pieces;

import GameSetup.Pieces.Features.Color;
import GameSetup.Position;

import java.util.List;

public class NullPiece implements Piece {
    Position position;

    public NullPiece(Position position) {
        this.position = position;
    }

    public Color getColor() {throw new NullPointerException("Cannot get color of null piece at " + position);}
    public Position getPosition() {return position;}
    public void setPosition(Position position) {this.position = position;}
    public List<Position> getValidMoves() {throw new NullPointerException("Cannot get valid moves of null piece at " + position);}
    public boolean exists() {return false;}
}

