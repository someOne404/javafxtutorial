package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Button button;
    public void handleButtonClick(){
        System.out.println("run some code the user doesn't see");
        button.setText("Stop touching me");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Loading user data...");
    }
}
