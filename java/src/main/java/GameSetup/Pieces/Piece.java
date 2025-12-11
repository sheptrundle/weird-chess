package GameSetup.Pieces;

import GameSetup.Pieces.Features.Color;
import GameSetup.Pieces.Features.PieceType;
import GameSetup.Position;

import java.util.List;

public interface Piece {
    // Returns the color of piece
    public Color getColor();

    // Returns position of the piece
    public Position getPosition();

    // Sets new position of the piece
    public void setPosition(Position position);

    // Returns a set of valid moves from given position
    public List<Position> getValidMoves();

    // Returns false if Piece is NullPiece, otherwise true
    public boolean exists();

    // Returns what the piece is
    public PieceType getType();

}
