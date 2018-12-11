package View;

import Controllers.Controller;
import Controllers.LoginController;
import Model.Model;
import Model.IModel;
import Model.LoginModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {
    /**
     *
     * @param primaryStage
     * @throws
     * The function opens the view form.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{



        try {
            FXMLLoader fxmlLoader=new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("/Main.fxml").openStream());
            primaryStage.setTitle("Vacation4U");
            Scene scene=new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }






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



    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:Users.db";

        // SQL statement for creating a new table

        String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
                + "   user_name text PRIMARY KEY,\n"
                + "   password text NOT NULL,\n"
                + "   first_name text NOT NULL,\n"
                + "   last_name text NOT NULL,\n"
                + "   city text NOT NULL,\n"
                + "   birthdate text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewPaymentTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:Users.db";

        // SQL statement for creating a new table

        String sql = "CREATE TABLE IF NOT EXISTS Payments (\n"
                + "   user_name text PRIMARY KEY,\n"
                + "   password text NOT NULL,\n"
                + "   seller text NOT NULL,\n"
                + "   buyer text NOT NULL,\n"
                + "   amountOfMoney text NOT NULL,\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //
    public static void createNewVacationTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:Users.db";

        // SQL statement for creating a new table

        String sql = "CREATE TABLE IF NOT EXISTS Vacations (\n"
                + "   id text PRIMARY KEY,\n"
                + "   flight_company text ,\n"
                + "   departure_date text ,\n"
                + "   back_date text ,\n"
                + "   baggage_included text,\n"
                + "   country text,\n"
                + "   flight_back_included text,\n"
                + "   num_tickets_adult text,\n"
                + "   num_tickets_kid text,\n"
                + "   num_tickets_baby text,\n"
                + "   vacation_kind text,\n"
                + "   hotel_included text,\n"
                + "   rank_hotel text,\n"
                + "   user_name text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createNewMessageTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:Users.db";

        // SQL statement for creating a new table

        String sql = "CREATE TABLE IF NOT EXISTS Messages (\n"
                + "   id text PRIMARY KEY,\n"
                + "   sender text NOT NULL,\n"
                + "   reciever text NOT NULL,\n"
                + "   seen integer NOT NULL,\n"
                + "   vacation_ID integer NOT NULL\n"

                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }






    public static void main(String[] args) {
        connect();
        createNewDatabase("Users.db");
        createNewTable();
        createNewVacationTable();
        createNewPaymentTable();
        createNewMessageTable();
        launch(args);
    }
}