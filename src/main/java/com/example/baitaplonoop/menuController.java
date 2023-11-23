package com.example.baitaplonoop;

import com.example.baitaplonoop.HelloApplication;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import java.io.IOException;

public class menuController implements Initializable {

    @FXML
    private Button gameButton;

    @FXML
    private Button dictionaryButton;

    @FXML
    private ImageView ship;

    TranslateTransition transition = new TranslateTransition();

    @FXML
    public void showDictionary(MouseEvent event) throws IOException {
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Stage stage = (Stage) dictionaryButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dictionary.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dictionary");
        stage.setScene(scene);
        transition.setToX(138);
        transition.setToY(219);
        transition.setDuration(Duration.millis(1000));
        transition.play();
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.insertFromFile();
    }

    @FXML
    public void showGame(MouseEvent event) throws IOException{
        try {
            Thread.sleep(2100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Stage stage = (Stage) dictionaryButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Game");
        stage.setScene(scene);
        transition.setToX(395);
        transition.setToY(197);
        transition.setDuration(Duration.millis(2000));
        transition.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(ship);
    }
}
