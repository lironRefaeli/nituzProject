package View;

import Controllers.MessagesController;
import Model.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.List;

public class MessagesViewController extends AView {


    @FXML private AnchorPane pane;
    TableView<Message> tableView;


    String userNameReciever; //own- he is now the reciever


    public void setUserName(String reciever) {
        this.userNameReciever=reciever;
    }

    @FXML
    public void initialize(){

        /**
         *  private int id;
         private String sender;
         private String reciever;
         private int seen;//0 not seen. 1 seen and accepted. 2 seen and canceled.
         */
        TableColumn<Message,Integer> idCol=new TableColumn<>("Message ID");
        idCol.setMinWidth(200);
        idCol.setCellValueFactory(new PropertyValueFactory<Message,Integer>("id"));

        TableColumn<Message,String> senderCol=new TableColumn<>("Sender");
        idCol.setMinWidth(200);
        senderCol.setCellValueFactory(new PropertyValueFactory<Message,String>("sender"));

        TableColumn<Message,String> recieverCol=new TableColumn<>("Reciever");
        idCol.setMinWidth(200);
        recieverCol.setCellValueFactory(new PropertyValueFactory<Message,String>("reciever"));


        tableView=new TableView<>();
        tableView.setItems(getMessages(userNameReciever));
        tableView.getColumns().addAll(idCol,senderCol,recieverCol);

        pane.getChildren().add(tableView);
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
