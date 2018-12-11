package View;

import Controllers.AController;
import Controllers.Controller;
import Controllers.LoginController;
import Controllers.PaymentController;
import Model.IModel;
import Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentViewController extends AView {

    @FXML
    private TextField user;

    @FXML TextField password;

    @FXML
    StackPane pane;

    public void login(ActionEvent actionEvent) {

        //todo sent Model,Controller

        PaymentController controller=(PaymentController)this.controller;

        //todo bring the data from the msg
        messageController msgController;
        String seller = msgController.get();
        String buyer = msgController.get();
        String amount = msgController.get();
        controller.pay(user, password, seller, buyer, amount);

        Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
        errorAlert.setHeaderText("The payment was paid successfully!");
        errorAlert.showAndWait();

    }
}
