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


import java.io.IOException;

public class ViewController  {



     /**
     * @param event
     * @throws IOException
     * opens the form to make new user
     */
    @FXML
    private void openCreateForm(ActionEvent event){
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Create.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Create User");
        stage.setScene(new Scene(root1));
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
            Parent root = FXMLLoader.load(this.getClass().getResource("Read.fxml"));
            stage.setTitle("Vacation4U - Read");
            stage.setScene(new Scene(root, 300, 500));
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
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Update.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Delete.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("DeleteForm");
            stage.setScene(new Scene(root1));
            stage.show();


        }
        catch(IOException e){
            e.printStackTrace();

        }


    }



}
