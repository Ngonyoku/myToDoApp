package com.ngonyoku.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.util.ResourceBundle;

import com.ngonyoku.database.DatabaseHandler;
import com.ngonyoku.model.Users;
import javafx.fxml.FXML;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField signUpFirstName;

    @FXML
    private JFXTextField signUpLastName;

    @FXML
    private JFXTextField signUpUsername;

    @FXML
    private JFXCheckBox signUpCheckboxMale;

    @FXML
    private JFXCheckBox signUpCheckboxFemale;

    @FXML
    private JFXCheckBox signUpCheckboxOther;

    @FXML
    private JFXTextField signUpLocation;

    @FXML
    private JFXPasswordField signUpPassword;
    @FXML
    private JFXButton signUpUserBtn;

    @FXML
    void initialize() {
        signUpUserBtn.setOnAction(e -> {
            createUser();
        });
    }

    private void createUser() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        String gender = "";
        if (signUpCheckboxMale.isSelected()) {
            gender = "Male";
        } else if (signUpCheckboxFemale.isSelected()) {
            gender = "Female";
        } else {
            gender = "Other";
        }

        databaseHandler.signUpUser(
                new Users(
                        signUpFirstName.getText(),
                        signUpLastName.getText(),
                        signUpUsername.getText(),
                        signUpPassword.getText(),
                        signUpLocation.getText(),
                        gender)
        );
    }
}
