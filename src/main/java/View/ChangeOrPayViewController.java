package View;

import Controllers.ChangeOrPayController;
import Model.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ChangeOrPayViewController extends AView {
    @FXML
    private Button payButton;
    @FXML
    private Button changeButton;

    private String buyer;

    private String seller;

    private ChangeOrPayController changeOrPayController;


    public void setBuyerName(String userName){
        this.buyer=userName;
    }

    public void setSellerName(String userName){
        this.buyer=userName;
    }

    @FXML
    private void PayCash(ActionEvent event) throws IOException {
        //Message message = new Message();//kind-0
        //changeOrPayController.PayCash(message);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("A message send to the seller");
        alert.showAndWait();
    }

    @FXML
    private void ChangeVacation(ActionEvent event) throws IOException {
        //Message message = new Message();//kind-1
        //changeOrPayController.ChangeVacation(message);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("A message send to the seller");
        alert.showAndWait();
    }
}
