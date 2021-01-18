package com.ngonyoku.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.ngonyoku.animations.Shaker;
import com.ngonyoku.database.DatabaseHandler;
import com.ngonyoku.model.Users;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
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
    private JFXButton loginBtn;

    @FXML
    private JFXButton loginSignUpBtn;

    private DatabaseHandler databaseHandler;

    @FXML
    void initialize() {

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

        loginBtn.setOnAction(e -> {
            databaseHandler = new DatabaseHandler();

            String username = loginUsername.getText().trim();
            String password = loginPassword.getText().trim();

            if (!username.equals("") || !loginPassword.equals("")) {
                ResultSet userRow = databaseHandler.getUser(new Users(username, password));
                int counter = 0;

                try {
                    while (userRow.next()) {
                        counter++;
                    }

                    if (counter == 1) {
                        System.out.println("Successfully Logged In");
                    } else {
                        new Shaker(loginUsername).shake();
                        new Shaker(loginPassword).shake();
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            } else {
                System.out.println("Please Fill in all the Fields");
            }
        });
    }
}
