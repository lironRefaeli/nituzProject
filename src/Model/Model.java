package Model;

import java.sql.*;
import java.util.Queue;
import java.util.Vector;


public class Model implements IModel {

    public Model() {

    }

    @Override
    public boolean Create(String userName, String password, String firstName, String lastName, String birthday, String city) {
        String sql = "INSERT INTO Users(user_name,password,first_name,last_name,city,birthdate) VALUES(?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, city);
            pstmt.setString(6, birthday);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Vector<String> Read(String userName) {
        String sql = "SELECT user_name, password, first_name, last_name, city, birthdate FROM Users WHERE user_name = ? ";
        Vector<String> ans = new Vector<>();
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, userName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                for (int i = 1; i <=6  ; i++) {
                    ans.add(rs.getString(i));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }


        /**        String sql = "SELECT user_name FROM Users WHERE user_name=?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setString(1, userName);

            System.out.println("dfdf "+pstmt.getResultSet().getString("user_name")+"Sdsf");
            return "";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "----";
        }**/
//    }


    /**
     * the function updates the details of an exists user
     * @param userName
     * @param password
     * @param firstName
     * @param lastName
     * @param birthday
     * @param city
     */
    @Override
    public void Update(String userName, String password, String firstName, String lastName, String birthday, String city) {
        String sql = "UPDATE Users SET user_name = ? , " + "password = ? " + "first_name = ?" + "last_name = ?" +
                "city = ?" + "birthdate = ?" +"WHERE username = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, birthday);
            pstmt.setString(6, city);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   /**
     * Connect to the Users.db database
     *
     * @return the Connection object
     */

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:Users.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("connect");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
/**
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
 **/
    @Override
    /**
     * Delete function get the strings username and password.
     * It checks if the username exists, and also if the password is match.
     * if user was deleted, success alert is shown. if not, the user get error alert.
     */
    public void Delete(String userName, String Password) {

            //String sql = "DELETE FROM Users WHERE user_name =" + userName + " AND password =" + Password;
            String sql = "DELETE FROM Users WHERE user_name = liron";
        System.out.println("HI");
            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // set the username param
               // pstmt.setString(1, userName);
                // set the password param
                //pstmt.setString(2, Password);
                // execute the delete statement

                System.out.print(sql);
                pstmt.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
