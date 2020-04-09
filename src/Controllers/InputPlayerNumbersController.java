package Controllers;

import Services.LotteryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    public void checkButtonAction(ActionEvent actionEvent) {
        playersNumbers = new int[]{
                Integer.parseInt(txtPlayN1.getText()),
                Integer.parseInt(txtPlayN2.getText()),
                Integer.parseInt(txtPlayN3.getText()),
                Integer.parseInt(txtPlayN4.getText()),
                Integer.parseInt(txtPlayN5.getText()),
                Integer.parseInt(txtPlayN6.getText())
        };

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
        // Create a pop up scene with a message to say if win or not
        // Ensure the labels on the pop up take a title and a message with an ok button
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
