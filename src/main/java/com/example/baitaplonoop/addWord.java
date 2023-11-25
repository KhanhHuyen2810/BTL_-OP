package com.example.baitaplonoop;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class addWord extends dictionaryController implements Initializable  {

    @FXML
    private Button addButton;
    @FXML
    private TextField newWordInput;
    @FXML
    private TextField phonicInput;
    @FXML
    private TextField result;
    @FXML
    TextArea explanationInput = new TextArea();

//    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    TranslateTransition transition = new TranslateTransition();

    @FXML
    void goBack(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dictionary.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dictionary");
        stage.setScene(scene);
    }

    @FXML
    void add(MouseEvent event) {
        String newWord = newWordInput.getText();
        String phonic = phonicInput.getText();
        String explanation = explanationInput.getText();

        boolean res = true;
        for (int i = 0; i < dictionaryManagement.count; i++) {
            if(newWord.equals(dictionaryManagement.dictionaryFile.dictionary[i].getWordtarget())) {
                res = false;
                break;
            }
        }

        if (!res) {
            result.setText("word has already existed");
        } else {
            String explain = phonic + explanation;
            dictionaryManagement.dictionaryAddScene(newWord, explain);
            result.setText("Add successfully");
//            dictionaryController dictionarycontroller = new dictionaryController();
//            dictionarycontroller.listView.getItems().addAll(newWord);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dictionaryManagement.insertFromFile();
    }
}
