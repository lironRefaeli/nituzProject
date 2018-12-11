package Model;

public class Message {

    private int id;
    private String sender;
    private String reciever;
    private int seen;//0 not seen. 1 seen and accepted by reciever. 2 seen and canceled by reciever. 3 nothing to do
    String isOpended;
    private static int NumOfMessages=0;
    int vacationID;


    public Message(String sender, String reciever,int seen,int vacationId) {
        this.sender = sender;
        this.reciever = reciever;
        this.vacationID=vacationId;
        id=NumOfMessages;
        this.seen=seen;
        if(seen==0||seen==1||seen==2)
            isOpended="Unread";
        else{
            isOpended="Read";
        }
        NumOfMessages+=1;
    }

    public int getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

    public int getSeen() {
        return seen;
    }

    public String getIsOpended() {
        return isOpended;
    }

    public int getVacationID() {
        return vacationID;
    }

    public static int getNumOfMessages() {
        return NumOfMessages;
    }
}
