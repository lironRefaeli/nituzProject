package View;

import Controllers.MessagesController;
import Controllers.PaymentController;
import Model.Message;
import Model.MessageModel;
import Model.PaymentModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;
import java.util.Optional;

public class MessagesViewController extends AView {


    @FXML private AnchorPane pane;
    @FXML private Button msg;
    TableView<Message> tableView;
    PaymentViewController controller1;


    String userNameReciever; //own- he is now the reciever
    String payed="false";
    boolean need_to_update=false;
    int id_to_update;

    public void setUserName(String reciever) {
        this.userNameReciever=reciever;
    }

    public void setPayed(String payed){
        this.payed=payed;
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
    public void setMsg(){
        TableColumn<Message,String> senderCol=new TableColumn<>("Sender");
        senderCol.setMinWidth(200);
        senderCol.setCellValueFactory(new PropertyValueFactory<Message,String>("sender"));

        TableColumn<Message,String> seenCol=new TableColumn<>("Read/Unread");
        seenCol.setMinWidth(200);
        seenCol.setCellValueFactory(new PropertyValueFactory<Message,String>("isOpended"));

        TableColumn<Message,Integer> vacId=new TableColumn<>("Vacation");
        vacId.setMinWidth(200);
        vacId.setCellValueFactory(new PropertyValueFactory<Message,Integer>("vacationID"));
        if(tableView==null){
            tableView=null;
        }
        tableView=new TableView<>();
        tableView.setItems(getMessages(userNameReciever));
        tableView.getColumns().addAll(senderCol,seenCol,vacId);
        tableView.setRowFactory(tv -> {
            TableRow<Message> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                Message clickedRow = row.getItem();
                if(clickedRow.getSeen()==0){//need to open confirmation to vacation request. updates only if user confirmed or denied request!!
                    Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
                    confirmation.setHeaderText("Confirm");
                    confirmation.setContentText("Do you want to approve request from " + clickedRow.getSender()+ " ?\n Click OK to approve, cancel to dent and x to exit.");
                    Optional<ButtonType> result= confirmation.showAndWait();
                    MessagesController msgs=(MessagesController)controller;
                    if (result.get() == ButtonType.OK){
                        msgs.Create(clickedRow.getReciever(),clickedRow.getSender(),1,clickedRow.getVacationID());
                        msgs.updateSeenToMessage(clickedRow.getId(),3);

                    } else {
                        msgs.Create(clickedRow.getReciever(),clickedRow.getSender(),2,clickedRow.getVacationID());
                        msgs.updateSeenToMessage(clickedRow.getId(),3);

                    }
                }
                else if(clickedRow.getSeen()==1){
                    PaymentModel model = new PaymentModel();
                    PaymentViewController view=new PaymentViewController ();
                    PaymentController controller = new PaymentController(model,view);
                    view.setController(controller);
                    Stage stage = new Stage();
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        Parent root1 = fxmlLoader.load(getClass().getResource("/PaymentView.fxml").openStream());
                        controller1=fxmlLoader.<PaymentViewController>getController();
                        controller1.setBuyer(clickedRow.getReciever());
                        controller1.setSeller(clickedRow.getSender());
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setTitle("Pay!");
                        stage.setScene(new Scene(root1));
                        stage.show();
                    }
                    catch(Exception e){

                    }
                    need_to_update=true;
                    id_to_update=clickedRow.getId();

                }
                else if(clickedRow.getSeen()==2){
                    Alert error = new Alert(Alert.AlertType.INFORMATION);
                    error.setHeaderText("Sorry");
                    error.setContentText("Vacation request were denied by user.");
                    error.showAndWait();
                    MessagesController msgs=(MessagesController)controller;
                    msgs.updateSeenToMessage(clickedRow.getId(),3);
                }

                else{//alreadyseen
                    Alert error = new Alert(Alert.AlertType.INFORMATION);
                    error.setHeaderText("Seen Message");
                    error.setContentText("You already checked this message.");
                    error.showAndWait();
                }
            });

            return row ;
        });


        pane.getChildren().add(tableView);
        msg.setVisible(false);
    }

    public void seeMsg(ActionEvent actionEvent) {
        setMsg();
    }

    public void update_message(){
        MessagesController msgs = (MessagesController) controller;
        msgs.updateSeenToMessage(id_to_update, 3);
        //setMsg();

    }
}
