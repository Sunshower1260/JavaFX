package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Validation;

public class LoginController implements Initializable {

    @FXML
    TextField accountNumTextField, passwordTextField;
    @FXML
    Label accountNumLabel, passwordLabel, loginLabel;
    @FXML
    Button submitButton;

    ResourceBundle bundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        Validation validation = new Validation();

        bundle = ResourceBundle.getBundle("resources/en"); 
        try {
            boolean isVietnamese = readLanguageChoice();
            if (isVietnamese) {
                bundle = ResourceBundle.getBundle("resources/vi");
            }

            loginLabel.setText(bundle.getString("LOGIN"));
            accountNumTextField.setPromptText(bundle.getString("ENTER_ACCOUNT_NUMBER"));
            passwordTextField.setPromptText(bundle.getString("ENTER_PASSWORD"));
            submitButton.setText(bundle.getString("LOGIN"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean readLanguageChoice() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileIn = new FileInputStream("language.properties");
        properties.load(fileIn);
        fileIn.close();
        return Boolean.parseBoolean(properties.getProperty("isVietnamese", "false"));
    }

    public void checkLogin(ActionEvent event) throws Exception {
        boolean isVietnamese = readLanguageChoice();
    
        String accountNum = accountNumTextField.getText();
        String password = passwordTextField.getText();
    
        Validation validation = new Validation();
    
        if (!validation.checkAccountNum(accountNum)) {
            showErrorMessage(accountNumLabel, "account_number_error", isVietnamese);
        } else if (!validation.checkPassword(password)) {
            showErrorMessage(passwordLabel, "password_error", isVietnamese);
        }
    
        if (validation.checkAccountNum(accountNum) && validation.checkPassword(password)) {
            validation.sceneSwitch(event, "/View/CapchaScreen.fxml");
        }
    }
    
    private void showErrorMessage(Label label, String propertyName, boolean isVietnamese) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileIn = new FileInputStream("language.properties");
        properties.load(fileIn);
        fileIn.close();
    
        String errorMessage = properties.getProperty(propertyName);
        if (isVietnamese) {
            label.setText(errorMessage);
        } else {
        
            String[] messages = errorMessage.split(",");
            label.setText(messages[0]); 
        }
        label.setTextFill(Color.RED);
    }
}

