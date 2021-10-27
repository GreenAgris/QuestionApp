package Entry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;


public class EntryDatabase {

    public static Entry selectEntry(int id, Entry entry){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/agris.traskovs/code/QuestionApp/sql/QuestionDB.db");
            Statement statement = connection.createStatement();

            statement.execute("SELECT * FROM Entry WHERE id="+id+";");

            ResultSet rs = statement.getResultSet();
            rs.next();

            entry.text = rs.getString("text");
            entry.user = rs.getString("user");
            entry.creationDateTime = LocalDateTime.parse(rs.getString("creationDateTime"));
            entry.questionIdentifier = rs.getString("questionIdentifier");

        }catch (SQLException exception){
            System.out.println("This was not possible to retrieve.");
        }

        return entry;
    }

    public static int saveEntry (Entry entry){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/agris.traskovs/code/QuestionApp/sql/QuestionDB.db");
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO Entry (\"text\",\"user\",creationDateTime,questionIdentifier) VALUES" +
            "('"+entry.text+"','"+entry.user+"','"+entry.creationDateTime.toString()+"','"+ entry.questionIdentifier+"');");
            //return id
            String queryLastRowInserted = "SELECT last_insert_rowid() AS id";
            statement.execute(queryLastRowInserted);
            ResultSet rs = statement.getResultSet();
            rs.next();
            int generatedID = rs.getInt("id");
            return generatedID;
        }catch (SQLException exception){
            System.out.println("This was not possible to save.");
        }

        return -1;
    }

}
