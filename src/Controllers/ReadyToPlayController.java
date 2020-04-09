package Controllers;

import Services.LotteryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class ReadyToPlayController {
    public Button btnExit;
    public Button btnGenerateRandomNumbers;
    public Button btnCheck;
    public TextField txtNumber1;
    public TextField txtNumber2;
    public TextField txtNumber3;
    public TextField txtNumber4;
    public TextField txtNumber5;
    public TextField txtNumber6;
    LotteryService lotteryService;
    int[] unsortedRandomNumbers;
    int[] sortedRandomNumbers;

    public void exitButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    public void generateRandomNumbersButtonAction(ActionEvent actionEvent) {
        if (!txtNumber1.getText().isEmpty())
        {
            // Do another message box
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog with Custom Actions");
            alert.setHeaderText(null);

            // Ask user if they are sure to reset the numbers
            alert.setContentText("Are you sure you want to reset the numbers?");
            ButtonType buttonTypeYes = new ButtonType("Yes");
            ButtonType buttonTypeNo = new ButtonType("No");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();

            // if yes then do another randomise
            if (result.get() == buttonTypeYes)
            {
                int[] newUnsortedRandomNumbers;
                int[] newSortedRandomNumbers;
                txtNumber1.setText("");
                txtNumber2.setText("");
                txtNumber3.setText("");
                txtNumber4.setText("");
                txtNumber5.setText("");
                txtNumber6.setText("");

                newUnsortedRandomNumbers = lotteryService.getInstance().generateRandomNumbers();//randomNumberGenerator.getInstance().generate();

                // Sort random numbers then put to text boxes
                newSortedRandomNumbers = lotteryService.getInstance().sortNumbers(newUnsortedRandomNumbers);//selectionSort.getInstance().sort(unsortedRandomNumbers);

                txtNumber1.appendText(Integer.toString(newSortedRandomNumbers[0]));
                txtNumber2.appendText(Integer.toString(newSortedRandomNumbers[1]));
                txtNumber3.appendText(Integer.toString(newSortedRandomNumbers[2]));
                txtNumber4.appendText(Integer.toString(newSortedRandomNumbers[3]));
                txtNumber5.appendText(Integer.toString(newSortedRandomNumbers[4]));
                txtNumber6.appendText(Integer.toString(newSortedRandomNumbers[5]));
            }
            // if not then exit
            else if(result.get() == buttonTypeNo)
            {
                alert.close();
            }
            else {
                alert.close();
            }
        }
        else{
            unsortedRandomNumbers = lotteryService.getInstance().generateRandomNumbers();//randomNumberGenerator.getInstance().generate();

            // Sort random numbers then put to text boxes
            sortedRandomNumbers = lotteryService.getInstance().sortNumbers(unsortedRandomNumbers);//selectionSort.getInstance().sort(unsortedRandomNumbers);

            txtNumber1.appendText(Integer.toString(sortedRandomNumbers[0]));
            txtNumber2.appendText(Integer.toString(sortedRandomNumbers[1]));
            txtNumber3.appendText(Integer.toString(sortedRandomNumbers[2]));
            txtNumber4.appendText(Integer.toString(sortedRandomNumbers[3]));
            txtNumber5.appendText(Integer.toString(sortedRandomNumbers[4]));
            txtNumber6.appendText(Integer.toString(sortedRandomNumbers[5]));
        }
    }

    public void checkButtonAction(ActionEvent actionEvent) throws IOException {

        /*
        Only have to check one text box because .....
         */
        if (txtNumber1.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("You must generate numbers first");

            alert.showAndWait();
        }
        else{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../layout/app_inputPlayerNumbers.fxml"));
            Parent checkViewParent = loader.load();

            Scene checkViewScene = new Scene(checkViewParent);

            InputPlayerNumbersController controller = loader.getController();
            controller.initData(sortedRandomNumbers);

            Stage stage = new Stage();
            stage.setTitle("Check your numbers");
            stage.setScene(checkViewScene);
            stage.show();
        }
    }
}
