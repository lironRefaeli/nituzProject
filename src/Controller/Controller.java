package Controller;

import Model.IModel;
import Model.Model;
import View.ViewController;
import javafx.scene.control.Alert;

public class Controller {
    IModel model = new Model();
    ViewController viewController = new ViewController();

//    public Controller(IModel model){
//        this.model = model;
//    }

    public Alert Create(String usernameS,String passwordS, String confirmS,String firstS,String lastS,String dateS,String cityS){
        if (usernameS.length() == 0 || passwordS.length() == 0 || confirmS.length() == 0 ||
                firstS.length() == 0 || lastS.length() == 0 || cityS.length() == 0 || dateS.length() == 0) {
            //if one or more deails aren't filled
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("At least one of the fields are empty.\nFill all fields and try again ");
//            errorAlert.showAndWait();
            return errorAlert;
        } else{
            if(!passwordS.equals(confirmS)){
                //if passwords dont match
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Passwords doesn't match.\nPlease try again.");
//                errorAlert.showAndWait();
                return errorAlert;
            }
            else {
                boolean flag = model.Create(usernameS, passwordS, firstS, lastS, dateS, cityS);
                if (flag) {
                    Alert success = new Alert(Alert.AlertType.CONFIRMATION);
                    success.setHeaderText("Action Succeeded");
                    success.setContentText("New user created successfuly! ");
//                    success.showAndWait();
                    return success;
                } else {
                    Alert fail = new Alert(Alert.AlertType.ERROR);
                    fail.setHeaderText("Action Failed");
                    fail.setContentText("Username already taken.\nPlease choose different one and try again ");
//                    fail.showAndWait();
                    return fail;
                }
            }
        }
    }
}
