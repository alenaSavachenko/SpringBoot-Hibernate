package springBoot.jpa.SpringBoot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testConnection {


    public static void main(String[] args) {

        try {
            Connection conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "nochsvetla");

            System.out.println("connection succesfull");
        } catch ( SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
