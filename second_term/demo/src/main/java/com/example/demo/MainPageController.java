package com.example.demo;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class MainPageController implements Initializable {
    private final String kFileName = "products.txt";

    @FXML
    private Button addProductButton, logout_button;
    @FXML
    private TextField
            nameField, priceField, amountField, weightField;

    @FXML
    private TableView<Product> table_with_products;

    @FXML
    private TableColumn<Product, String>
            nameColumn, priceColumn, amountColumn, weightColumn;

    ObservableList<Product> productObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productObservableList = FXCollections.observableArrayList(Reader.ReadFromFile(kFileName));

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));

        table_with_products.setItems(productObservableList);
    }

    public void onLogOutButtonClicked(ActionEvent event) throws IOException {
        HelloApplication.changeScene(
                (Stage)logout_button.getScene().getWindow(),
                "loginPage.fxml"
        );
        Reader.WriteIntoFile(new ArrayList<>(productObservableList), kFileName);
    }

    public void onAddButtonClicked(ActionEvent event) throws IOException {
        productObservableList.add(
                new Product(
                        nameField.getText(),
                        priceField.getText(),
                        amountField.getText(),
                        weightField.getText()
                )
        );

        Model.Notify();
        table_with_products.setItems(productObservableList);
    }
}
