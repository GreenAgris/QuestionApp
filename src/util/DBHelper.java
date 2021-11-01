package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

    private Statement statement;
    private   Connection connection;

    public DBHelper() {
        try {
           connection = DriverManager.getConnection(
                "jdbc:sqlite:/Users/agris.traskovs/code/QuestionApp/sql/QuestionDB.db");
            statement = connection.createStatement();
        } catch (
            SQLException exception) {
            System.out.println("There was an issue when creating a connection");
        }
    }

    public Statement getStatment() {
        try {
            statement = this.connection.createStatement();
        return statement;
        } catch (
            SQLException exception) {
            System.out.println("There was an issue when creating a statement");
        }
        return null;
    }
}
