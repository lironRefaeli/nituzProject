package View;

import Controllers.*;
import Model.IModel;
import Model.Model;
import Model.MessageModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentViewController extends AView {

    @FXML
    private TextField user;

    @FXML TextField password;

    @FXML TextField amount;

@FXML
    AnchorPane thePane;

    String seller;
    String buyer;
    boolean buy=false;
    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public boolean isBuy() {
        return buy;
    }

    public void login(ActionEvent actionEvent) {



        String money=amount.getText();
        String userName=user.getText();
        String amount_=amount.getText();
        if((money==null||money.equals(""))||(user==null||user.equals(""))||(amount_==null||amount_.equals(""))){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Action Failed");
            errorAlert.setContentText("Please fill up all fields and try again.");
            errorAlert.showAndWait();
        }
        else {
            boolean number = true;
            for (int i = 0; i < money.length(); i++) {
                if (!Character.isDigit(money.charAt(i)))
                    number = false;
            }
            if (!number) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Action Failed");
                errorAlert.setContentText("Please Insert on amount number only!");
                errorAlert.showAndWait();
            } else {
                PaymentController controller = (PaymentController) this.controller;
                controller.pay(user.getText(), password.getText(), seller, buyer, amount.getText());
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    Parent root1 = fxmlLoader.load(getClass().getResource("/Messages.fxml").openStream());
                    MessagesViewController controller1 = fxmlLoader.<MessagesViewController>getController();
                    controller1.setPayed("true");
                } catch (Exception e) {

                }
                Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
                errorAlert.setHeaderText("Success");
                errorAlert.setContentText("You just bought a vacation!");
                errorAlert.showAndWait();
                buy = true;


            }
        }


        if (buy) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                Parent root1 = fxmlLoader.load(getClass().getResource("/Messages.fxml").openStream());
                MessagesViewController controller1 = fxmlLoader.<MessagesViewController>getController();
                MessageModel model = new MessageModel();
                MessagesViewController view=new MessagesViewController ();
                MessagesController controller = new MessagesController(model,view);
                view.setController(controller);
                controller1.update_message();
                Stage stage=(Stage)thePane.getScene().getWindow();
                stage.hide();
            } catch (Exception e) {

            }
        }
    }

    public void exit(ActionEvent actionEvent) {
        Stage stage=(Stage)thePane.getScene().getWindow();
        stage.hide();
        MessageModel model = new MessageModel();
        MessagesViewController view=new MessagesViewController ();
        MessagesController controller = new MessagesController(model,view);
        view.setController(controller);
    }
}
