package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import Model.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LanguageChoiceController {

    @FXML
    Button vietnamese, english, exit;

    public void LanguageChoice(ActionEvent event) throws IOException {
        Button sourceButton = (Button) event.getSource();
        boolean isVietnamese = false;
        if (sourceButton == vietnamese) {
            isVietnamese = true;
        }

        storeLanguageChoice(isVietnamese);

        Validation validation = new Validation();
        validation.sceneSwitch(event, "/View/LoginScene.fxml");
    }

    private void storeLanguageChoice(boolean isVietnamese) {
        try {
            Properties properties = new Properties();
            properties.setProperty("isVietnamese", String.valueOf(isVietnamese));
            File file = new File("language.properties");
            FileOutputStream fileOut = new FileOutputStream(file);
            properties.store(fileOut, "Language Choice");
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exitOp(ActionEvent event){
        System.exit(0);
    }
}