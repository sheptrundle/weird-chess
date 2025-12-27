package Game.Logic;

import Game.Features.Color;
import Game.Pieces.Piece;

public class PieceLogic {

    public Color getOppositeColor(Color color) {
        return switch (color) {
            case WHITE -> Color.BLACK;
            case BLACK -> Color.WHITE;
        };
    }
}
