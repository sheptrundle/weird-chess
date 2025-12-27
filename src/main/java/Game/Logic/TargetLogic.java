package Game.Logic;

import Game.Features.Position;
import Game.Pieces.Piece;

import java.util.List;

public class TargetLogic {

    // Todo: implement this entire class

    public List<Position> getTargetsForPiece(Piece piece) {
        switch (piece.getType()) {
            case PAWN:

            case BISHOP:

            case ROOK:

            case KNIGHT:

            case QUEEN:

            case KING:

            // Null piece
            default:
                throw new IllegalArgumentException("Invalid piece type to get targets for: " +  piece.getType());
        }
    }
}
