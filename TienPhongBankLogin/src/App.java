import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/LanguageChoice.fxml"));
        Scene scene = new Scene(root);
        String css = getClass().getResource("/View/Css/Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("TP BANK");
        stage.getIcons().add(new Image("/Resources/unnamed.jpg"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}

