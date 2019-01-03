package Model;

public class Message {

    private int id;
    private int kind;//0-cash,1-change
    private String sender;
    private String reciever;
    private int seen;
    // 0 not seen.
    // 1 seen and replace accepted by reciever.
    // 2 seen and replace canceled by reciever.
    // 3 seen and accepted cash invite but still waiting for payment.
    // 4
    private String isOpended;
    private static int NumOfMessages=0;
    private int vacationIDSource;
    private int vacationIDDest;


    public Message(String sender, String reciever,int seen,int vacationIdSource,int vacationIdDest, int kind) {
        this.sender = sender;
        this.reciever = reciever;
        this.vacationIDSource=vacationIdSource;
        this.vacationIDDest=vacationIdDest;
        this.kind=kind;
        id=NumOfMessages;
        this.seen=seen;
        if(seen==0||seen==3)
            isOpended="Unread";
        else{
            isOpended="Read";
        }
        NumOfMessages+=1;
    }

    public int getKind() {
        return kind;
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

    public int getVacationIDSource() {
        return vacationIDSource;
    }

    public int getVacationIDDest() {
        return vacationIDDest;
    }

    public static int getNumOfMessages() {
        return NumOfMessages;
    }
}
