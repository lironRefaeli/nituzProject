package View;

import Controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

public class ReadController {
    @FXML
    private TextField username;
    @FXML
    private GridPane resultsView;
    @FXML
    private TextField username_just4view;
    @FXML
    private TextField password_just4view;
    @FXML
    private TextField firstname_just4view;
    @FXML
    private TextField lastname_just4view;
    @FXML
    private TextField city_just4view;
    @FXML
    private TextField birthdate_just4view;
    @FXML
    private Label sorrymessage;

    private Controller controller = new Controller();

    @FXML
    private void ReadUser(ActionEvent event) throws IOException {
        String usernameS;
        usernameS = username.getText();
        Vector<String> ans = controller.Read(usernameS);
        sorrymessage.setVisible(false);
        resultsView.setVisible(false);
        if (ans.size() != 0) {
            username_just4view.setText(ans.elementAt(0));
            firstname_just4view.setText(ans.elementAt(2));
            lastname_just4view.setText(ans.elementAt(3));
            city_just4view.setText(ans.elementAt(4));
            birthdate_just4view.setText(ans.elementAt(5));
            resultsView.setVisible(true);
        } else {
            sorrymessage.setVisible(true);
        }
    }

    @FXML
    public void onEnter(ActionEvent ae){
        try {
            ReadUser(ae);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
