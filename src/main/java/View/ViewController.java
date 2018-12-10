package View;

import Controllers.Controller;
import Controllers.LoginController;
import Controllers.VacationController;
import Model.IModel;
import Model.LoginModel;
import Model.Model;
import Model.VacationModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import javax.swing.text.View;

import java.io.IOException;

public class ViewController extends AView {


    String userName;


    public void setUserName(String userName) {
        this.userName = userName;
    }

    @FXML
    private void openReadForm(){
        IModel model = new Model();
        MainViewController mainview=new MainViewController();
        Controller controller = new Controller(model,mainview);
        mainview.setController(controller);
        try{
            Stage stage = new Stage();
            FXMLLoader fxmlLoader=new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("/Read.fxml").openStream());
            stage.setTitle("Vacation4U - Read");
            stage.setScene(new Scene(root, 500, 500));
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }



    /**
     *
     * @param event
     * the function opens the update form of the user
     */
    @FXML
    private void openUpdateForm(ActionEvent event){
        IModel model = new Model();
        MainViewController mainview=new MainViewController();
        Controller controller = new Controller(model,mainview);
        mainview.setController(controller);
        try{
            FXMLLoader fxmlLoader=new FXMLLoader();
            Parent root1 = fxmlLoader.load(getClass().getResource("/Update.fxml").openStream());
            UpdateController controller1=fxmlLoader.<UpdateController>getController();
            controller1.setUserName(userName);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Update User");
            stage.setScene(new Scene(root1));
            stage.show();
            controller1.start();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     *
     * @param event by choosing the delete option in view.fxml
     *              The function open new scene.
     */
    @FXML
    private void openDeleteForm(ActionEvent event) {
        IModel model = new Model();
        MainViewController mainview=new MainViewController();
        Controller controller = new Controller(model,mainview);
        mainview.setController(controller);
        try {
            FXMLLoader fxmlLoader=new FXMLLoader();
            Parent root1 = fxmlLoader.load(getClass().getResource("/Delete.fxml").openStream());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Delete Form");
            stage.setScene(new Scene(root1));
            stage.show();


        }
        catch(IOException e){
            e.printStackTrace();

        }
    }


    public void openSearchVacationForm(ActionEvent actionEvent) {
        VacationModel model = new VacationModel();
        SearchVacController view=new SearchVacController();
        VacationController controller = new VacationController(userName,model,view);
        view.setController(controller);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root1 = fxmlLoader.load(getClass().getResource("/SearchVacation.fxml").openStream());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Search For Vacation");
            stage.setScene(new Scene(root1));
            stage.show();
            System.out.println(userName);
        }
        catch (IOException e){

        }

    }
}
