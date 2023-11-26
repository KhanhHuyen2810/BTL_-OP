package com.example.baitaplonoop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.scene.web.*;

public class dictionaryController implements Initializable {

    @FXML
    private Button searchButton;
    @FXML
    private TextField englishInput;
    @FXML
    private Button goBackButton;
    @FXML
    private Button goNextButton;
    @FXML
    private Button addNewWordButton;
    @FXML
    private Button editWordButton;
    @FXML
    private Button deleteWordButton;
    @FXML
    private Button speechTextButton;
    @FXML
    public ListView<String> listView;
    @FXML
    private Pane somePane;
    @FXML
    private WebView definitionView;
    WebEngine engine;

    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    @FXML
    void setSearchButton(MouseEvent event) {
        String wordLookup = englishInput.getText();
        boolean res = false;
        for (int i = 0; i < dictionaryManagement.count; i++) {
            if(wordLookup.equals(dictionaryManagement.dictionaryFile.dictionary[i].getWordtarget())) {
                res = true;
                break;
            }
        }

        if (res == true) {

            String s = dictionaryManagement.dictionaryLookupScene(wordLookup); // Gọi phương thức dictionaryLookup từ đối tượng DictionaryManagement
            String meaning = "";
            String[] fragments = s.split("(?=\\*|-|=)");

            for (String fragment : fragments) {
                meaning = meaning + "<br>" + fragment.trim();
            }
            engine = definitionView.getEngine();
            engine.setUserStyleSheetLocation("data:,body { font: 14px Arial; }");
            engine.loadContent(meaning);

            listView.getItems().clear();
            ArrayList<String> wordsSearch = new ArrayList<>();
            wordsSearch = dictionaryManagement.dictionarySearcherScene(wordLookup);
            listView.getItems().addAll(wordsSearch);
        } else {
            engine = definitionView.getEngine();
            engine.setUserStyleSheetLocation("data:,body { font: 14px Arial; }");
            engine.loadContent("Word doesn't exist, please try again!");
        }
    }

    ArrayList<String> words = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.getItems().clear();
        engine = definitionView.getEngine();
        engine.setUserStyleSheetLocation("data:,body { font: 16px Arial; }");
        engine.loadContent("Explanation");
        dictionaryManagement.insertFromFile();
        for (int i=0; i<dictionaryManagement.count; i++){
            words.add(dictionaryManagement.dictionaryFile.dictionary[i].getWordtarget());
        }
        listView.getItems().addAll(words);
    }

    @FXML
    void goBack(MouseEvent event) throws IOException{
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("English Learning Application");
        stage.setScene(scene);
    }

    @FXML
    void goNext(MouseEvent event) throws IOException {
        Stage stage = (Stage) goNextButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("empty scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dictionary");
        stage.setScene(scene);
    }

    @FXML
    void addNewWord(MouseEvent event) throws IOException {
        Stage stage = (Stage) addNewWordButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addWord.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Add New Word");
        stage.setScene(scene);
    }

    @FXML
    void deleteWord(MouseEvent event) {
        String wordDeletetarget = englishInput.getText();
        boolean res = false;
        for (int i = 0; i < dictionaryManagement.count; i++) {
            if(wordDeletetarget.equals(dictionaryManagement.dictionaryFile.dictionary[i].getWordtarget())) {
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
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this word ?", agree, no);
            alert.setTitle("Notification");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == agree){
                dictionaryManagement.dictionaryRemoveScence(wordDeletetarget);
                listView.getItems().remove(wordDeletetarget);
                engine = definitionView.getEngine();
                engine.setUserStyleSheetLocation("data:,body { font: 16px Arial; }");
                engine.loadContent("Explanation");
                englishInput.setText("");
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "Delete successfully");
                alert2.setTitle("Notification");
                alert2.setHeaderText(null);
                alert2.showAndWait();
            }
        }
    }

    @FXML
    void editWord(MouseEvent event) throws IOException {
        Stage stage = (Stage) editWordButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("editWord.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Edit Word");
        stage.setScene(scene);
    }

    @FXML
    void speechText(MouseEvent event) {

    }
}


