package Controllers;

import Services.LotteryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class InputPlayerNumbersController {
    public TextField txtPlayN1;
    public TextField txtPlayN2;
    public TextField txtPlayN3;
    public TextField txtPlayN4;
    public TextField txtPlayN5;
    public TextField txtPlayN6;
    public Button btnCheck;
    public Button btnExit;
    LotteryService lotteryService;
    int[] playersNumbers;
    int[] lotteryNumbers;
    boolean hasDuplicates;

    public void checkButtonAction(ActionEvent actionEvent) {

        if(txtPlayN1.getText().isEmpty()||
                txtPlayN2.getText().isEmpty()||
                txtPlayN3.getText().isEmpty()||
                txtPlayN4.getText().isEmpty()||
                txtPlayN5.getText().isEmpty()||
                txtPlayN6.getText().isEmpty())
        {
            // Throw an alert box saying that your missing a value
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Please ensure you enter 6 numbers");

            alert.show();
        }else if(Integer.parseInt(txtPlayN1.getText()) >= 1 && Integer.parseInt(txtPlayN1.getText()) <= 59 &&
                Integer.parseInt(txtPlayN2.getText()) >= 1 && Integer.parseInt(txtPlayN2.getText()) <= 59 &&
                Integer.parseInt(txtPlayN3.getText()) >= 1 && Integer.parseInt(txtPlayN3.getText()) <= 59 &&
                Integer.parseInt(txtPlayN4.getText()) >= 1 && Integer.parseInt(txtPlayN4.getText()) <= 59 &&
                Integer.parseInt(txtPlayN5.getText()) >= 1 && Integer.parseInt(txtPlayN5.getText()) <= 59 &&
                Integer.parseInt(txtPlayN6.getText()) >= 1 && Integer.parseInt(txtPlayN6.getText()) <= 59)
        {
            playersNumbers = new int[]{
                    Integer.parseInt(txtPlayN1.getText()),
                    Integer.parseInt(txtPlayN2.getText()),
                    Integer.parseInt(txtPlayN3.getText()),
                    Integer.parseInt(txtPlayN4.getText()),
                    Integer.parseInt(txtPlayN5.getText()),
                    Integer.parseInt(txtPlayN6.getText())
            };

            // Check for duplicates
            for (int i = 0; i < playersNumbers.length; i++){
                for (int j = i + 1; j < playersNumbers.length; j++){
                    if (playersNumbers[i] == playersNumbers[j]){
                        hasDuplicates = true;
                    }
                }
            }

            if (!hasDuplicates)
            {
                int[] sortedPlayerNumbers = lotteryService.getInstance().sortNumbers(playersNumbers);
                List<String> response = lotteryService.getInstance().checkNumbersForMatches(lotteryNumbers, sortedPlayerNumbers);

                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("../layout/app_winningNumbers.fxml"));
                    Parent checkViewParent = loader.load();

                    Scene checkViewScene = new Scene(checkViewParent);

                    WinningNumbersController controller = loader.getController();
                    controller.initData(response);

                    Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
                    stage.setTitle("Winning Numbers");
                    stage.setScene(checkViewScene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        else {
            // Throw message box saying about numbers being inbetween
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Please ensure the numbers are between 1 and 59");

            alert.show();
        }
    }

    /*
    Method for passing the data from another scene
     */
    public void initData(int[] arr)
    {
        lotteryNumbers = arr;
    }

    public void exitButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}
