package Controllers;

import Model.Message;
import Model.PaymentModel;
import Model.Vacation;
import Model.VacationModel;
import View.AView;
import View.MessagesViewController;
import View.PaymentViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

public class PaymentController extends AController{


    PaymentModel paymentModel;
    AView paymentView;


    public PaymentController(PaymentModel paymentModel, AView paymentView) {

        this.paymentModel = paymentModel;
        this.paymentView = paymentView;
    }


    public void pay(String username, String password, String seller, String buyer, String amountOfMoney) {
        paymentModel.pay(username,password, seller, buyer, amountOfMoney);

    }



}
