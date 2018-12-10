package Model;

public class Message {

    private int id;
    private String sender;
    private String reciever;
    private int seen;//0 not seen. 1 seen and accepted. 2 seen and canceled.
    private static int NumOfMessages=0;

    public Message(String sender, String reciever) {
        this.sender = sender;
        this.reciever = reciever;
        id=NumOfMessages;
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

    public static int getNumOfMessages() {
        return NumOfMessages;
    }
}
