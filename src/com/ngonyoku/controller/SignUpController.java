package com.ngonyoku.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField signUpFirstName;

    @FXML
    private JFXTextField signUpFLastName;

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
    void initialize() {

    }
}
