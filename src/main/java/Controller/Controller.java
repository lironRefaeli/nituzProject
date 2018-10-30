package Controller;

import Model.IModel;
import Model.Model;
import View.AView;
import View.ViewController;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Vector;

public class Controller {
    IModel model = new Model();
    AView create;
    AView delete;
    AView update;
    AView read;

    public Controller(IModel model, AView create,AView delete,AView update, AView read){
        this.model = model;
        this.create=create;
        this.delete=delete;
        this.update=update;
        this.read=read;

    }

    public void Create(String usernameS, String passwordS, String confirmS, String firstS, String lastS, String dateS, String cityS) {
        if (usernameS.length() == 0 || passwordS.length() == 0 || confirmS.length() == 0 ||
                firstS.length() == 0 || lastS.length() == 0 || cityS.length() == 0 || dateS.length() == 0) {
            //if one or more deails aren't filled
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("At least one of the fields are empty.\nFill all fields and try again ");
//            errorAlert.showAndWait();
            create.ShowAlert(errorAlert);
        } else {
            if (!passwordS.equals(confirmS)) {
                //if passwords dont match
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Passwords doesn't match.\nPlease try again.");
//                errorAlert.showAndWait();
                create.ShowAlert(errorAlert);
            } else {
                boolean flag = model.Create(usernameS, passwordS, firstS, lastS, dateS, cityS);
                if (flag) {
                    Alert success = new Alert(Alert.AlertType.CONFIRMATION);
                    success.setHeaderText("Action Succeeded");
                    success.setContentText("New user created successfuly! ");
//                    success.showAndWait();
                    create.ShowAlert(success);
                } else {
                    Alert fail = new Alert(Alert.AlertType.ERROR);
                    fail.setHeaderText("Action Failed");
                    fail.setContentText("Username already taken.\nPlease choose different one and try again ");
//                    fail.showAndWait();
                    create.ShowAlert(fail);
                }
            }
        }
    }


    public Vector<String>Read(String username) {
        return model.Read(username);
}

    public void Delete(String DeleteUserNameOutput, String DeletePasswordOutput) {
        if (DeleteUserNameOutput.length() == 0 || DeletePasswordOutput.length() == 0) {
            //if one or more deails aren't filled
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("At least one of the fields are empty.\nFill all fields and try again ");
            delete.ShowAlert(errorAlert);
        } else {


            boolean flag = model.Delete(DeleteUserNameOutput, DeletePasswordOutput);
            if (flag) {
                Alert success = new Alert(Alert.AlertType.CONFIRMATION);
                success.setHeaderText("Action Succeeded");
                success.setContentText("User was deleted successfuly! ");
//                    success.showAndWait();
                delete.ShowAlert(success);

            }
            else
            {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Action failed");
                errorAlert.setContentText("Username or Password are incorrect.\n Try again ");
                delete.ShowAlert(errorAlert);
            }

        }
    }

    public void update(String usernameS, String passwordS, String firstS, String lastS, String dateS, String cityS) {
        if (usernameS.length() == 0 || passwordS.length() == 0 ||
                firstS.length() == 0 || lastS.length() == 0 || cityS.length() == 0 || dateS.length() == 0) {
            //if one or more deails aren't filled
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("At least one of the fields are empty.\nFill all fields and try again ");
//            errorAlert.showAndWait();
            update.ShowAlert(errorAlert);
//        } else {
//            if (!passwordS.equals(confirmS)) {
//                //if passwords dont match
//                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
//                errorAlert.setHeaderText("Input not valid");
//                errorAlert.setContentText("Passwords doesn't match.\nPlease try again.");
////                errorAlert.showAndWait();
//                return errorAlert;
            } else {
                boolean flag = model.Update(usernameS, passwordS, firstS, lastS, dateS, cityS);
                if (flag) {
                    Alert success = new Alert(Alert.AlertType.CONFIRMATION);
                    success.setHeaderText("Action Succeeded");
                    success.setContentText("User updated successfuly! ");
//                    success.showAndWait();
                    update.ShowAlert(success);
                } else {
                    Alert fail = new Alert(Alert.AlertType.ERROR);
                    fail.setHeaderText("Action Failed");
                    fail.setContentText("Username already taken.\nPlease choose different one and try again ");//todo what failed exactly?
//                    fail.showAndWait();
                    update.ShowAlert(fail);
                }
            }
        }
    }


