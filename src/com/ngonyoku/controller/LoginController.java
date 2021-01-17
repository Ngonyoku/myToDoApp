package com.ngonyoku.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField loginUsername;

    @FXML
    private JFXPasswordField loginPassword;

    @FXML
    private JFXButton loginLogInBtn;

    @FXML
    private JFXButton loginSignUpBtn;

    @FXML
    void initialize() {
        String username = loginUsername.getText().trim();
        String password = loginPassword.getText().trim();

        loginSignUpBtn.setOnAction(e -> {
            //Will take the user to the Sign Up Screen
            loginSignUpBtn.getScene().getWindow().hide(); //The Login Window will be hidden
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/ngonyoku/view/signup.fxml"));//Load the SignUp window
            try {
                loader.load();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        loginLogInBtn.setOnAction(e -> {
            if (!username.equals("") || !loginPassword.equals("")) {
                loginUser(username, password);
            } else {
                System.out.println("Please Fill in all the Fields");
            }
        });
    }

    private void loginUser(String username, String password) {
    }
}
