package Controllers;

import Services.PlayerLibrary;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class ShowPlayersController{
    public Button btnExit;
    public TextArea txtShowPlayers;
    PlayerLibrary playerLibrary;

    public void showPlayersButtonAction(ActionEvent actionEvent) {

        if (txtShowPlayers.getText().isEmpty())
        {
            Map<String, Integer[]> players = playerLibrary.getInstance().getPlayers();

            if (players.size() == 0)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("No players to show");
                alert.show();
            }
            else {
                for (Map.Entry<String, Integer[]> entry : players.entrySet()){
                    String key = entry.getKey();
                    Integer[] value = entry.getValue();
                    txtShowPlayers.appendText("Player Name: " + key + "\n");
                    txtShowPlayers.appendText("'Numbers: " + Arrays.toString(value).replaceAll("\\[|\\]|,|\\s", " ") + "\n");
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
