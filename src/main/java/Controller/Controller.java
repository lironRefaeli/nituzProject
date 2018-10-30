package Controller;

import Model.IModel;
import Model.Model;
import View.AView;
import View.ViewController;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Queue;
import java.util.Vector;

public class Controller {
    IModel model = new Model();
    AView mainView;

    public Controller(IModel model ,AView mainView){
        this.model = model;
        this.mainView=mainView;

    }

    public void Create(String usernameS, String passwordS, String confirmS, String firstS, String lastS, String dateS, String cityS) {
        if (usernameS.length() == 0 || passwordS.length() == 0 || confirmS.length() == 0 ||
                firstS.length() == 0 || lastS.length() == 0 || cityS.length() == 0 || dateS.length() == 0) {
            //if one or more deails aren't filled
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("At least one of the fields are empty.\nFill all fields and try again ");
//            errorAlert.showAndWait();
            mainView.setAlert(errorAlert);
        } else {
            //date test - bigger than 18
            int year = Integer.parseInt(dateS.substring(6, 10));
            int month = Integer.parseInt(dateS.substring(3, 5));
            int day = Integer.parseInt(dateS.substring(0, 2));
            LocalDate birthday = LocalDate.of(year, month, day);
            LocalDate today = LocalDate.now();
            Period p = Period.between(birthday, today);
            int yeardif = p.getYears();
            if (yeardif < 18) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("You are not old enough!");
                errorAlert.setContentText("You need to be 18 or more to use the website!");
                mainView.setAlert(errorAlert);
            }
            else{

            if (!passwordS.equals(confirmS)) {
                //if passwords dont match
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Input not valid");
                errorAlert.setContentText("Passwords doesn't match.\nPlease try again.");
                mainView.setAlert(errorAlert);

            } else {
                boolean flag = model.Create(usernameS, passwordS, firstS, lastS, dateS, cityS);
                if (flag) {
                    Alert success = new Alert(Alert.AlertType.CONFIRMATION);
                    success.setHeaderText("Action Succeeded");
                    success.setContentText("New user created successfuly! ");
//                    success.showAndWait();
                    mainView.setAlert(success);
                } else {
                    Alert fail = new Alert(Alert.AlertType.ERROR);
                    fail.setHeaderText("Action Failed");
                    fail.setContentText("Username already taken.\nPlease choose different one and try again ");
//                    fail.showAndWait();
                    mainView.setAlert(fail);

                }
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
            mainView.setAlert(errorAlert);

        } else {
            boolean flag = model.Delete(DeleteUserNameOutput, DeletePasswordOutput);
            if (flag) {
                Alert success = new Alert(Alert.AlertType.CONFIRMATION);
                success.setHeaderText("Action Succeeded");
                success.setContentText("User was deleted successfuly! ");
//                    success.showAndWait();
                mainView.setAlert(success);


            }
            else
            {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Action failed");
                errorAlert.setContentText("Username or Password are incorrect.\n Try again ");
                mainView.setAlert(errorAlert);

            }

        }
    }


    public void Delete2(String DeleteUserNameOutput) {
        if (DeleteUserNameOutput.length() == 0 ) {
              //do nothing.
        } else {
            model.Delete2(DeleteUserNameOutput);
        }
    }

    public void update(String usernameS, String passwordS,String confirmS, String firstS, String lastS, String dateS, String cityS) {
        if (usernameS.length() == 0 || passwordS.length() == 0 ||
                firstS.length() == 0 || lastS.length() == 0 || cityS.length() == 0 || dateS.length() == 0) {
            //if one or more deails aren't filled
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("At least one of the fields are empty.\nFill all fields and try again ");
//            errorAlert.showAndWait();
            mainView.setAlert(errorAlert);

//        } else {
//            if (!passwordS.equals(confirmS)) {
//                //if passwords dont match
//                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
//                errorAlert.setHeaderText("Input not valid");
//                errorAlert.setContentText("Passwords doesn't match.\nPlease try again.");
////                errorAlert.showAndWait();
//                return errorAlert;



            //check over 18

            } else {
            //date test - bigger than 18
            int year = Integer.parseInt(dateS.substring(6, 10));
            int month = Integer.parseInt(dateS.substring(3, 5));
            int day = Integer.parseInt(dateS.substring(0, 2));
            LocalDate birthday = LocalDate.of(year, month, day);
            LocalDate today = LocalDate.now();
            Period p = Period.between(birthday, today);
            int yeardif = p.getYears();
            if (yeardif < 18) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("date not valid!");
                errorAlert.setContentText("You need to be 18 or more to use the website!");
                mainView.setAlert(errorAlert);
            } else {
            if (!passwordS.equals(confirmS)) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("password not match!");
                errorAlert.setContentText("the passwords dont match.\n Please try again");
                mainView.setAlert(errorAlert);
            }
            else{
                boolean flag = model.Update(usernameS, passwordS, firstS, lastS, dateS, cityS);
                if (flag) {
                    Alert success = new Alert(Alert.AlertType.CONFIRMATION);
                    success.setHeaderText("Action Succeeded");
                    success.setContentText("User updated successfuly! ");
//                    success.showAndWait();
                    mainView.setAlert(success);

                } else {
                    Alert fail = new Alert(Alert.AlertType.ERROR);
                    fail.setHeaderText("Action Failed");
                    fail.setContentText("Username already taken.\nPlease choose different one and try again ");//todo what failed exactly?
//                    fail.showAndWait();
                    mainView.setAlert(fail);

                }
            }
        }
        }
    }


