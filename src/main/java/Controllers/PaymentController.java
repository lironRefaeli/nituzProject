package Controllers;

import Model.PaymentModel;
import Model.Vacation;
import Model.VacationModel;
import View.AView;
import javafx.scene.control.Alert;

public class PaymentController extends AController{

    boolean isConnected;
    String username;
    PaymentModel paymentModel;
    AView paymentView;


    public PaymentController(String username,  PaymentModel paymentModel, AView paymentView) {
        this.username = username;
        if(username!=null) {
            if (username.equals(""))
                isConnected = false;
            else {
                isConnected = true;
                this.username=username;
            }
        }
        this.paymentModel = paymentModel;
        this.paymentView = paymentView;
    }


    public void pay(String username, String password, String seller, String buyer, String amountOfMoney)
    {
        paymentModel.pay(username,password,seller, buyer, amountOfMoney);
    }

}
