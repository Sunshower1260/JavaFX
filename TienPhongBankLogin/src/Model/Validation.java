package Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.*;

public class Validation {
    public boolean checkAccountNum(String accountNum){
        try {
            int account = Integer.parseInt(accountNum);
        } catch (Exception e) {
            return false;
        }
        if(accountNum.length() != 10){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean checkPassword(String password){
        return password.length() >= 8 && password.length() <= 31 && password.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).*$");
    }
    
    public void sceneSwitch(ActionEvent event,String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent root = loader.load();
        
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setResizable(false);
            stage.setTitle("TP BANK");
            stage.getIcons().add(new Image("/Resources/unnamed.jpg"));
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String generateCapcha(){

        String chars = "0123456789qwertyuiopasdfghjklzxcvbnm";

        Random random = new Random();

        StringBuilder captcha = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(chars.length());
            captcha.append(chars.charAt(index));
        }
        return captcha.toString();
    }
}
