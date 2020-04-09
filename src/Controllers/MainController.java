package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MainController {
    public Button btnStartApplication;
    public Button btnExit;

    public void startApplicationButtonAction(ActionEvent actionEvent) {
        try {
            Parent hom_page = FXMLLoader.load(getClass().getResource("../layout/app_home.fxml"));
            Stage app = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            app.setScene(new Scene(hom_page, 700, 310));
            app.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void exitButtonAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("You are leaving the application");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
        }
    }
}
