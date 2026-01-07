package Controllers;

import Game.Features.ChessBoard;
import Game.Live.BoardInteractionHandler;
import Game.Live.LiveGame;
import Game.Pieces.Assets.Color;
import UI.Images.Gallery;
import UI.Model.BoardRenderer;
import UI.Model.GameCoordinator;
import UI.Model.LiveUIBinder;
import UI.Model.TwoWayChessBoard;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ChessGameController {

    @FXML private GridPane boardGrid;
    @FXML private Label whiteClockLabel;
    @FXML private Label blackClockLabel;
    @FXML private Label endResultLabel;
    @FXML private Text orientationStatus;

    private BoardRenderer boardRenderer;
    private BoardInteractionHandler interactionHandler;
    private GameCoordinator gameCoordinator;
    private LiveUIBinder liveUIBinder;

    public void initialize(Gallery gallery, Duration time) {

        ChessBoard board = new ChessBoard(gallery, time);
        TwoWayChessBoard twoWayBoard = new TwoWayChessBoard(board, Color.WHITE);
        LiveGame liveGame = new LiveGame(board);

        boardRenderer = new BoardRenderer(boardGrid, board, twoWayBoard);
        gameCoordinator = new GameCoordinator(twoWayBoard, liveGame, boardRenderer, endResultLabel, orientationStatus);
        interactionHandler = new BoardInteractionHandler(board, twoWayBoard, liveGame, boardRenderer, gameCoordinator);
        liveUIBinder = new LiveUIBinder(liveGame, time, whiteClockLabel, blackClockLabel, endResultLabel);

        board.initialize();
        boardRenderer.createGrid(interactionHandler);
        boardRenderer.updateUI();
        liveUIBinder.start();
    }

    @FXML
    public void handleFlipPOV() {
        gameCoordinator.flipPOV();
    }
}
