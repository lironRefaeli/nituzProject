package View;

import Controllers.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.awt.*;

public class LoginViewController extends AView{

    @FXML
    private TextField user;

    @FXML TextField password;


    public void login(ActionEvent actionEvent) {

        LoginController loginController=(LoginController)this.controller;
        if(user.getText().length()==0||password.getText().length()==0){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error!");
            errorAlert.setContentText("One or more of the fields are'nt filled.\n Fill all fields and try again.");

        }
        else {
          //  boolean flag = loginController.login(); todo
        }

    }

}
