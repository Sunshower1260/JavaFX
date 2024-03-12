package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CapchaCheckController implements Initializable{
    @FXML
    Button submitButton;
    @FXML
    Label label;
    @FXML
    TextField textField;

    Validation validation = new Validation();
    String capcha = validation.generateCapcha();

    public void submit(ActionEvent event){        

        if(textField.getText().equals(capcha)){
            validation.sceneSwitch(event, "/View/LoadingScreen.fxml");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(capcha);
    }
}
