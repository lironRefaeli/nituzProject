package Model;


import java.sql.ResultSet;
import java.util.Vector;

public interface IModel {
    boolean Create(String userName,String password,String firstName,String lastName,String birthday,String city);
    Vector<String> Read(String userName);
    boolean Update(String userName,String password,String firstName,String lastName,String birthday,String city);
    boolean Delete(String userName, String Password);

    boolean Delete2(String userName);
}
