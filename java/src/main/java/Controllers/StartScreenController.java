package Controllers;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenController {
    @FXML private Label errorLabel;

    @FXML
    public void handleStartGame(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(StartScreenController.class.getResource("/FX/chess-board.fxml"));
            Parent root = loader.load();
            ChessGameController controller = loader.getController();
            controller.setUp();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Chess");
            stage.show();
        } catch (IOException e) {
            errorLabel.setText(e.getMessage());
            errorLabel.setVisible(true);
        }
    }
}
