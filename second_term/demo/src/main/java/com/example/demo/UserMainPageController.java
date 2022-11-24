package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserMainPageController implements Initializable {
    private Account account;
    @FXML
    private Label amountLabel;
    @FXML
    private Button goBackButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.account = Model.account;
        amountLabel.setText(account.getAmount_of_products_in_shop().toString());
    }

    public void onBackButtonClicked() throws IOException {
        HelloApplication.changeScene(
                (Stage)goBackButton.getScene().getWindow(),
                "loginPage.fxml"
        );
    }
}
