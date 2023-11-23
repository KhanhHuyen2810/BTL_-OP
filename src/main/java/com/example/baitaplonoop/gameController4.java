package com.example.baitaplonoop;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class gameController4 {
    @FXML
    private ImageView correctImage;

    @FXML
    private ImageView incorrectImage;

    @FXML
    private Button correctAnswer;

    @FXML
    private Button goBackButton;

    @FXML
    private Button nextButton;

    @FXML
    void showImage(MouseEvent event) {
        incorrectImage.setVisible(false);
        correctImage.setVisible(true);
    }

    @FXML
    void showImage2(MouseEvent event) {
        correctImage.setVisible(false);
        incorrectImage.setVisible(true);
    }

    @FXML
    void showImage3(MouseEvent event) {
        correctImage.setVisible(false);
        incorrectImage.setVisible(true);
    }

    @FXML
    void showImage4(MouseEvent event) {
        correctImage.setVisible(false);
        incorrectImage.setVisible(true);
    }

    @FXML
    void goBack(MouseEvent event) throws IOException {
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Game");
        stage.setScene(scene);
    }

    @FXML
    void goNext(MouseEvent event) throws IOException {
        Stage stage = (Stage) nextButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game5.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Game");
        stage.setScene(scene);
    }
}
