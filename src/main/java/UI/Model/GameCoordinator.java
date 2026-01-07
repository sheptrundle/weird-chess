package UI.Model;

import Game.Features.ChessBoard;
import Game.Live.LiveGame;
import Game.Logic.PieceLogic;
import Game.Pieces.Assets.Piece;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.HashSet;

public class GameCoordinator {

    private final TwoWayChessBoard twoWayBoard;
    private final LiveGame liveGame;
    private final BoardRenderer renderer;
    private final Label endResultLabel;
    private final Text orientationText;

    public GameCoordinator(TwoWayChessBoard twoWayBoard,
                           LiveGame liveGame,
                           BoardRenderer renderer,
                           Label endResultLabel,
                           Text orientationText
    ) {
        this.twoWayBoard = twoWayBoard;
        this.liveGame = liveGame;
        this.renderer = renderer;
        this.endResultLabel = endResultLabel;
        this.orientationText = orientationText;
    }

    // Flips POV of Board and updates UI
    public void flipPOV() {
        twoWayBoard.switchPOV();
        renderer.clearAllOverlays();
        renderer.updateUI();

        // Set up highlighted piece again if needed
        Piece highlightedPiece = renderer.getHighlightedPiece();
        if (highlightedPiece != null) {
            renderer.highlightPiece(highlightedPiece, "limegreen");
            renderer.highlightMoves(new HashSet<>(highlightedPiece.getValidMoves(true)), highlightedPiece);
            renderer.updateUI();
        }

        updateLabels();
    }

    // Sets the text of current turn label based on liveGame
    public void updateLabels() {
        // Update current turn label
        endResultLabel.setText("Current Turn = " + PieceLogic.colorToString(liveGame.getCurrentTurn()));

        // Update correct orientation label
        if (correctOrientation()) {
            orientationText.setText("Correct");
            orientationText.setFill(Paint.valueOf("limegreen"));
        } else {
            orientationText.setText("Incorrect");
            orientationText.setFill(Paint.valueOf("red"));
        }
    }

    // Checks to see if the orientation of POV is correct for the player
    public boolean correctOrientation() {
        return twoWayBoard.getPOV() == liveGame.getCurrentTurn();
    }
}
