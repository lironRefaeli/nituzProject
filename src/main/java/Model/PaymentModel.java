package Model;

import java.sql.*;
import java.util.Vector;

public class PaymentModel {

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

    public boolean pay(String userName, String password, String seller, String buyer, String amountOfMoney) {
        String sql = "INSERT INTO Payments(user_name, password, seller, buyer, amountOfMoney) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.setString(3, seller);
            pstmt.setString(4, buyer);
            pstmt.setString(5, amountOfMoney);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
        }

}
