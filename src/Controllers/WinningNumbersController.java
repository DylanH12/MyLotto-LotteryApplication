package Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.List;

public class WinningNumbersController {
    public Button btnExit;
    public TextArea txtWinningNumbers;

    public void exitButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    public void initData(List<String> list)
    {
        for (String s : list)
        {
            txtWinningNumbers.appendText(s + "\n");
        }
    }
}
