package View;

import Controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class DeleteController extends AView{

     @FXML
     private TextField DeleteUserNameOutput;
     @FXML
     private PasswordField DeletePasswordOutput;


     /**
     * @param event - by choosing "delete" in Delete.fxml
     *              this function connect controller and model.
     */
     @FXML
     private void deleteUser(ActionEvent event)
     {
         controller.Delete(DeleteUserNameOutput.getText(), DeletePasswordOutput.getText());
         this.ShowAlert();

     }

}
