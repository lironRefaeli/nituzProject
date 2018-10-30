package View;

import Controller.Controller;
import javafx.scene.control.Alert;

public class AView {
    static Controller controller;

    public AView() {

    }
    public void setController(Controller controller2){
        controller=controller2;
    }

    public void ShowAlert(Alert alert){
        alert.showAndWait();
    }
}
