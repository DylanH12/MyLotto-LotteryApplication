package Controllers;

import Models.Player;
import Services.PlayerLibrary;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowPlayersController {
    public Button btnExit;
    public TextArea txtShowPlayers;
    PlayerLibrary playerLibrary;

    public void showPlayersButtonAction(ActionEvent actionEvent) {

        if (txtShowPlayers.getText().isEmpty())
        {
            Player[] players = playerLibrary.getInstance().getPlayers();

            if (players.length == 0)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("No players to show");
                alert.show();
            }
            else {
                for (Player p : players) {
                    txtShowPlayers.appendText("Player Name: " + p.getPlayerName() + "\n");
                    txtShowPlayers.appendText(p.getPlayerName() + "'s Numbers: " + p.getPlayerNumbers() + "\n");
                    txtShowPlayers.appendText("======================");
                    txtShowPlayers.appendText("\n");
                }
            }
        }
    }

    public void exitButtonAction(ActionEvent actionEvent) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../layout/app_home.fxml"));
            Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
