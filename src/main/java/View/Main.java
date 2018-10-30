package View;

import Controller.Controller;
import Model.Model;
import Model.IModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.text.View;
import java.sql.*;
import java.time.LocalDate;

public class Main extends Application {
    /**
     *
     * @param primaryStage
     * @throws Exception
     * The function opens the view form.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
      IModel model = new Model();
      ViewController mainview=new ViewController();
      Controller controller = new Controller(model,mainview);
      mainview.setController(controller);
        try {
//            System.out.println(this.getClass().getClassLoader());
            FXMLLoader fxmlLoader=new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("/View.fxml").openStream());
            primaryStage.setTitle("Vacation4U");
            Scene scene=new Scene(root, 500, 500);
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



    public static void main(String[] args) {
       // connect();
       // createNewDatabase("Users.db");
       // createNewTable();

        launch(args);
    }
}