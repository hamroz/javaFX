package sample.MiniWebBrowser;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MiniWebBrowserController implements Initializable {
    String addressLink;
    WebEngine engine;
    boolean state = true;
    ArrayList<String> store = new ArrayList<String>();
    int pageNow;

    @FXML
    private Button backButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button refreshButton;
    @FXML
    private TextField addressTextField;
    @FXML
    private Button searchButton;
    @FXML
    private WebView myWebView;

    public void search() {
        addressLink = addressTextField.getText().trim();
        engine.load(addressLink);
        store.add(addressLink);
        backButton.setDisable(false);
        nextButton.setDisable(true);
        pageNow = store.size() - 1;

    }

    public void refreshButtonPressed() {
        addressLink = store.get(pageNow);
        engine.load("https://www.google.com/");
        engine.load(addressLink);


    }

    public void backButtonPressed() {
        engine.load(store.get(pageNow - 1));
        nextButton.setDisable(false);
        if (pageNow == 0) {
            backButton.setDisable(true);
        }
        pageNow -= 1;
        addressTextField.setText(store.get(pageNow));


    }

    public void nextButtonPressed() {
        engine.load(store.get(pageNow));
        backButton.setDisable(false);
        if (pageNow == store.size() - 1) {
            nextButton.setDisable(true);
        }
        pageNow += 1;
        addressTextField.setText(store.get(pageNow));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = myWebView.getEngine();
        engine.load("https://www.google.com/");
        nextButton.setDisable(true);
        backButton.setDisable(true);
        pageNow = 0;
        store.add("https://www.google.com/");

    }
}