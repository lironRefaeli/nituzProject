package View;

import Controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

public class UpdateController extends AView{
    @FXML
    private TextField usernameLogIn;
    @FXML
    private GridPane resultsView;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField conpassword;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField city;
    @FXML
    private TextField birthdate;
    @FXML
    private Label sorrymessage;


    @FXML
    private void FindUser(ActionEvent event) throws IOException {
        String usernameS;
        usernameS = usernameLogIn.getText();
        Vector<String> ans = controller.Read(usernameS);
        sorrymessage.setVisible(false);
        resultsView.setVisible(false);
        if (ans.size() != 0) {
            username.setText(ans.elementAt(0));
            password.setText(ans.elementAt(1));
            conpassword.setText(ans.elementAt(1));
            firstname.setText(ans.elementAt(2));
            lastname.setText(ans.elementAt(3));
            city.setText(ans.elementAt(4));
            birthdate.setText(ans.elementAt(5));
            resultsView.setVisible(true);
        } else {
            sorrymessage.setVisible(true);
        }
    }

    @FXML
    public void onEnter(ActionEvent ae){
        try {
            FindUser(ae);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(ActionEvent actionEvent) {
        String usernameS,passwordS,conpasswordS,firstnameS,lastnameS,birthdateS,cityS;

        usernameS=username.getText();
        passwordS=password.getText();
        conpasswordS = conpassword.getText();
        firstnameS=firstname.getText();
        lastnameS=lastname.getText();
        birthdateS=birthdate.getText();
        cityS=city.getText();


        if((usernameLogIn.getText()).equals(username.getText())) {
            controller.update(usernameS, passwordS, conpasswordS,firstnameS, lastnameS, birthdateS, cityS);
            this.ShowAlert();
        }
        else{
            controller.Delete2(usernameLogIn.getText());
            controller.Create(usernameS, passwordS,conpasswordS, firstnameS, lastnameS, birthdateS, cityS);
            if(alert.getAlertType().equals(Alert.AlertType.ERROR)||alert.getAlertType().equals(Alert.AlertType.WARNING)){
                this.ShowAlert();;

            }
            else{
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Action Succeeded");
                alert.setContentText("User updated successfully");
                alert.showAndWait();

            }
        }
    resultsView.setVisible(false);
    }
}
