package com.example.demo;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class LogInController {

    public LogInController() {

    }

    @FXML
    private Button login_button, signup_button;
    @FXML
    private Label login_error;
    @FXML
    private TextField username, password;


    public void onLoginButtonClicked(ActionEvent event) throws IOException {
        Account account = Model.checkLogin(username.getText(), password.getText());
        if (account == null) {
            login_error.setText("Wrong username | password");
        } else if (Objects.equals(account.getPassword(), "admin")
                && Objects.equals(account.getUsername(), "admin")) {
            login_error.setText("Success!!");
            Model.account = account;
            HelloApplication.changeScene(
                    (Stage) login_button.getScene().getWindow(),
                    "adminMainPage.fxml"
            );
        } else {
            login_error.setText("Success!!");
            Model.account = account;
            HelloApplication.changeScene(
                    (Stage) login_button.getScene().getWindow(),
                    "userMainPage.fxml"
            );
        }
    }

    public void onSignUpButtonClicked(ActionEvent event) throws IOException {
        HelloApplication.changeScene(
                (Stage)signup_button.getScene().getWindow(),
                "signUpPage.fxml"
        );
    }

}
