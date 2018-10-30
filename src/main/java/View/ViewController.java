package View;

import Model.Model;
import Model.IModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import javax.swing.text.html.ImageView;
import java.io.IOException;

public class ViewController extends AView {



     /**
     * @param event
     * @throws IOException
     * opens the form to make new user
     */
@FXML
    private void openCreateForm(ActionEvent event){
        try{
            FXMLLoader fxmlLoader=new FXMLLoader();
            Parent root1 = fxmlLoader.load(getClass().getResource("/Create.fxml").openStream());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Create User");
            stage.setScene(new Scene(root1,500,500));
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }


  
    @FXML
    private void openReadForm(){
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
        try{
            FXMLLoader fxmlLoader=new FXMLLoader();
            Parent root1 = fxmlLoader.load(getClass().getResource("/Update.fxml").openStream());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Update User");
            stage.setScene(new Scene(root1));
            stage.show();
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
        try {
            FXMLLoader fxmlLoader=new FXMLLoader();
            Parent root1 = fxmlLoader.load(getClass().getResource("/Delete.fxml").openStream());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("DeleteForm");
            stage.setScene(new Scene(root1));
            stage.show();


        }
        catch(IOException e){
            e.printStackTrace();

        }


    }



}
