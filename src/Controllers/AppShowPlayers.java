package Controllers;

import Models.Player;
import Services.PlayerLibrary;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AppShowPlayers {
    public Button btnExit;
    public TextArea txtShowPlayers;
    PlayerLibrary playerLibrary;

    public void showPlayersButtonAction(ActionEvent actionEvent) {
        Player[] players = playerLibrary.getInstance().getPlayers();

        for (Player p : players)
        {
            txtShowPlayers.appendText("Player Name: " + p.getPlayerName() + "\n");
            txtShowPlayers.appendText( p.getPlayerName() + "'s Numbers: " + p.getPlayerNumbers() + "\n");
            txtShowPlayers.appendText( "\n");
        }
    }

    public void exitButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}
