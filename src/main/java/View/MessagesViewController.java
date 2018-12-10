package View;

import Controllers.MessagesController;
import Model.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.util.List;

public class MessagesViewController extends AView {


    @FXML private AnchorPane pane;
    TableView<Message> tableView;

    String userNameSender;//own
    String userNameReciever; // to the seller or buyer from system


    public void setUserName(String sender, String reciever) {
        this.userNameReciever=reciever;
        this.userNameSender=sender;
    }

    @FXML
    public void initialize(){

        TableColumn<>

    }


    public ObservableList<Message> getMessages(String reciever){//reciever=userName
        ObservableList<Message> observableList= FXCollections.observableArrayList();
        MessagesController messagesController=(MessagesController)this.controller;
        List<Message> messages=messagesController.getMessagesForReciever(reciever);
        for(int i=0;i<messages.size();i++){
            observableList.add(messages.get(i));
        }
        return observableList;
    }
}
