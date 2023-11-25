package com.example.baitaplonoop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.control.TextArea;

public class emptySceneController implements Initializable {
    @FXML
    private Button goBackButton;
    @FXML
    TextArea targetText = new TextArea();
    @FXML
    TextArea explainText = new TextArea();
    @FXML
    private Button translateButton;
    @FXML
    private Button translateButton1;

    @FXML
    void setTranslateButton(MouseEvent event) throws IOException {
        translateAPI translateText = new translateAPI();
        String text = translateText.translate("en", "vi", targetText.getText());
        explainText.setText(text);
    }
    @FXML
    void setTranslateButton1(MouseEvent event) throws IOException {
        translateAPI translateText = new translateAPI();
        String text = translateText.translate("vi", "en", targetText.getText());
        explainText.setText(text);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
//        targetText.setText("Enter a text to translate\n(Nhập văn bản)");
//        explainText.setText("Meaning (Bản dịch)");
    }

    @FXML
    void goBack(MouseEvent event) throws IOException {
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dictionary.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dictionary");
        stage.setScene(scene);
    }


}
