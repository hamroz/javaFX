package sample.EnhancedTipCalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EnhancedTipCalculator extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("EnhancedTipCalculator.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setTitle("Enhanced Tip Calculator");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}