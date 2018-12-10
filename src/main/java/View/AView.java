package View;

import Controllers.Controller;
import javafx.scene.control.Alert;

public class AView {
    protected static Controllers.AController controller;
    protected static Alert alert;

    public AView() {

    }
    public void setController(Controllers.AController controller2){
        controller=controller2;
    }

    public void setAlert(Alert alert2){
        alert=alert2;
    }
    public void ShowAlert(){
        alert.showAndWait();
    }

}
