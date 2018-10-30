package View;

import Controller.Controller;
import Model.Model;
import Model.IModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class CreateController extends AView{

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmpassword;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField city;
    @FXML
    private DatePicker birthdate ;



    /**
     *
     * @param event
     * @throws IOException
     * this function create user on the database
     */
    @FXML
    private void createUser(ActionEvent event) throws IOException {
        String usernameS, passwordS, confirmS, firstS, lastS, cityS, dateS;
        passwordS = password.getText();
        confirmS = confirmpassword.getText();
        usernameS = username.getText();
        firstS = firstname.getText();
        lastS = lastname.getText();
        cityS = city.getText();

        dateS = birthdate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.controller.Create(usernameS,passwordS,confirmS,firstS,lastS,dateS,cityS);



    }

}
