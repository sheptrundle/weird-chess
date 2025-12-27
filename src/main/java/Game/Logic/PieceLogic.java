package Game.Logic;

import Game.Pieces.Assets.Color;

public class PieceLogic {

    public Color getOppositeColor(Color color) {
        return switch (color) {
            case WHITE -> Color.BLACK;
            case BLACK -> Color.WHITE;
        };
    }
}
