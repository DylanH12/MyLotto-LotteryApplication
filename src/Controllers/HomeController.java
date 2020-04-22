package Controllers;

import Models.Player;
import Services.LotteryService;
import Services.PlayerLibrary;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    public TextField txtPlayerName;
    public TextField txtNumber1;
    public TextField txtNumber2;
    public TextField txtNumber3;
    public TextField txtNumber4;
    public TextField txtNumber5;
    public TextField txtNumber6;
    public Button btnExit;
    public Button btnReadyToPlay;
    Boolean hasDuplicates = false;

    Player player;
    Integer[] numbers;
    PlayerLibrary playerLibrary;

    public void addPlayerNumberButtonAction(ActionEvent actionEvent) {
        if (txtPlayerName.getText().isEmpty() ||
                txtNumber1.getText().isEmpty()||
                txtNumber2.getText().isEmpty()||
                txtNumber3.getText().isEmpty()||
                txtNumber4.getText().isEmpty()||
                txtNumber5.getText().isEmpty()||
                txtNumber6.getText().isEmpty())
        {
            // Throw an alert box saying that your missing a value
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Please ensure you enter a name and 6 numbers");

            alert.show();
        }
        else if(Integer.parseInt(txtNumber1.getText()) >= 1 && Integer.parseInt(txtNumber1.getText()) <= 59 &&
                Integer.parseInt(txtNumber2.getText()) >= 1 && Integer.parseInt(txtNumber2.getText()) <= 59 &&
                Integer.parseInt(txtNumber3.getText()) >= 1 && Integer.parseInt(txtNumber3.getText()) <= 59 &&
                Integer.parseInt(txtNumber4.getText()) >= 1 && Integer.parseInt(txtNumber4.getText()) <= 59 &&
                Integer.parseInt(txtNumber5.getText()) >= 1 && Integer.parseInt(txtNumber5.getText()) <= 59 &&
                Integer.parseInt(txtNumber6.getText()) >= 1 && Integer.parseInt(txtNumber6.getText()) <= 59) {

            numbers = new Integer[]{
                    Integer.parseInt(txtNumber1.getText()),
                    Integer.parseInt(txtNumber2.getText()),
                    Integer.parseInt(txtNumber3.getText()),
                    Integer.parseInt(txtNumber4.getText()),
                    Integer.parseInt(txtNumber5.getText()),
                    Integer.parseInt(txtNumber6.getText())};

            // Check for duplicates
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[i] == numbers[j]) {
                        hasDuplicates = true;
                    }
                }
            }

            if (!hasDuplicates)
            {
                player = new Player(txtPlayerName.getText(), numbers);

                playerLibrary.getInstance().addPlayer(player);
                System.out.println("Player Added");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Player has been added!");
                alert.show();

                txtPlayerName.setText("");
                txtNumber1.setText("");
                txtNumber2.setText("");
                txtNumber3.setText("");
                txtNumber4.setText("");
                txtNumber5.setText("");
                txtNumber6.setText("");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Please ensure there are no duplicate numbers");

                // Have to set back to false or it stays true throughout the lifetime of program
                hasDuplicates = false;
                alert.show();
            }
        }
        else{
            // Throw message box saying about numbers being inbetween
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Please ensure the numbers are between 1 and 59");

            alert.show();
        }
    }

    public void showPlayersButtonAction(ActionEvent actionEvent) {
        try {
            Parent show = FXMLLoader.load(getClass().getResource("../layout/app_showPlayers.fxml"));
            Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Show Players");
            stage.setScene(new Scene(show));
            stage.show();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exitButtonAction(ActionEvent actionEvent) {
        try {
            Parent hom_page = FXMLLoader.load(getClass().getResource("../layout/app_main.fxml"));
            Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(hom_page));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readyToPlayButtonAction(ActionEvent actionEvent) {
        try {
            Parent ready = FXMLLoader.load(getClass().getResource("../layout/app_readyToPlay.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Ready to Play?");
            stage.setScene(new Scene(ready));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
