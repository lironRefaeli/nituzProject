package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageModel {

    //connection function
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:Users.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public boolean Create(Message message) {
        String sql = "INSERT INTO Messages(id, sender, reciever ,seen, vacation_ID) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, String.valueOf(message.getId()));
            pstmt.setString(2, message.getSender());
            pstmt.setString(3, message.getReciever());
            pstmt.setString(4, String.valueOf(message.getSeen()));
            pstmt.setString(5, String.valueOf(message.getVacationID()));
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Message> searchByReciever(String reciever) {

        String sql = "SELECT id, sender, reciever,seen ,vacation_ID FROM Messages Where reciever = ? ";//all messages
        List<Message> msgs = new ArrayList<Message>();
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, reciever);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
               // String id=rs.getString(1);
                String sender= rs.getString(2);
                String reciever_=rs.getString(3);
               String seen=rs.getString(4);//0
               String Vacation=rs.getString(5);
               Message message=new Message(sender,reciever,Integer.valueOf(seen),Integer.valueOf(Vacation));
               msgs.add(message);
            }
            return msgs;
        }
        catch (Exception e){

        }
        return msgs;
    }

    public boolean UpdateSeen(int id,int seen) {//seen=1/2
        String sql = "UPDATE Messages SET seen = "
                +seen+" WHERE id = "+id;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            //pstmt.setString(1, String.valueOf(seen));
            //pstmt.setString(2, String.valueOf(id));

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("why");
            return false;
        }
        return true;
    }
}
