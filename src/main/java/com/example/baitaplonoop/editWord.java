package com.example.baitaplonoop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class editWord extends dictionaryController {

    @FXML
    private Button saveChange;
    @FXML
    private TextField wordInput;
    @FXML
    private TextField editedPhonicInput;
    @FXML
    TextArea editedExplanationInput = new TextArea();
    @FXML
    void goBack(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dictionary.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dictionary");
        stage.setScene(scene);
    }

    @FXML
    void saveChange(MouseEvent event) {
        String wordEdittarget = wordInput.getText();
        boolean res = false;
        for (int i = 0; i < dictionaryManagement.count; i++) {
            if(wordEdittarget.equals(dictionaryManagement.dictionaryFile.dictionary[i].getWordtarget())) {
                res = true;
                break;
            }
        }

        if (res == false) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Word doesn't exist!");
            alert.setTitle("Notification");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            ButtonType agree = new ButtonType("Có", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("Không", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to edit this word ?", agree, no);
            alert.setTitle("Notification");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == agree){
                String editText = editedPhonicInput.getText();
                dictionaryManagement.dictionaryReplaceScence(wordEdittarget, editText);
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "Save change successfully");
                alert2.setTitle("Notification");
                alert2.setHeaderText(null);
                alert2.showAndWait();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dictionaryManagement.insertFromFile();
    }

}
