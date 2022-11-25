package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class SignUpController {

    @FXML
    public Label message;
    @FXML
    public TextField usernameInput, passwordInput, confirmPasswordInput;
    @FXML
    private Button signUpButton;

    public void onSignUpButtonClicked(ActionEvent event) throws IOException {
        Account checkedFlag = Model.checkLogin(usernameInput.getText(), passwordInput.getText());
        if (checkedFlag != null) {
            message.setText("This user already exist! ");
        } else {
            if (passwordInput.getText().equals(confirmPasswordInput.getText())) {
                Model.AddAccount(new Account(usernameInput.getText(), passwordInput.getText()));
                HelloApplication.changeScene((Stage)signUpButton.getScene().getWindow(), "loginPage.fxml");
            } else {
                message.setText("failed confirmation (passwords are not equal)");
            }
        }
    }
}
