package Controllers;

import Model.Message;
import Model.MessageModel;
import Model.Vacation;
import Model.VacationModel;
import View.AView;
import javafx.scene.control.Alert;

import java.util.List;

public class MessagesController extends AController {



    MessageModel messageModel;
    AView view;

    public MessagesController(MessageModel model, AView view) {
        this.messageModel = model;
        this.view = view;
    }

    public boolean Create(String sender, String reciever,int seen,int vacationIdSource, int vacationIdDest, int kind) {
            Message message=new Message(sender,reciever,seen,vacationIdSource,vacationIdDest,kind);
            return messageModel.Create(message);
    }

    public void updateSeenToMessage(int id, int seen){
        messageModel.UpdateSeen(id,seen);
    }

    public List<Message> getMessagesForReciever(String reciever){
        return messageModel.searchByReciever(reciever);
    }

    public void changeVacations(Message clickedRow) {
        messageModel.changeVacations(clickedRow);
    }
}
