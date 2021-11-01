package Entry;

import static util.Utility.GREEN;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;


public class EntryDatabase {

    public static Entry selectEntry(Statement statement,int id, Entry entry) {
        try {
            statement.execute("SELECT * FROM Entry WHERE id=" + id + ";");

            ResultSet rs = statement.getResultSet();
            rs.next();

            entry.text = rs.getString("entryText");
            entry.user = rs.getString("userName");
            entry.creationDateTime = LocalDateTime.parse(rs.getString("creationDateTime"));
            entry.questionIdentifier = rs.getString("questionIdentifier");

        } catch (SQLException exception) {
            System.out.println("This Entry was not possible to retrieve.");
        }

        return entry;
    }

    public static int saveEntry(Statement statement, Entry entry) {
        try {
            System.out.println(GREEN + "Connection done");
            String executable = "INSERT INTO Entry ( entryText, userName, creationDateTime, questionIdentifier) VALUES" +
                "('" + entry.text + "','" + entry.user + "','" + entry.creationDateTime.toString() + "','" + entry.questionIdentifier
                + "');";
            System.out.println(GREEN + "Statement will be :");
            System.out.println(executable);
            statement.execute(executable);

            //return id
            System.out.println(GREEN + "insertion");
            String queryLastRowInserted = "SELECT last_insert_rowid() AS id";
            statement.execute(queryLastRowInserted);
            System.out.println(GREEN + "id retrieved ");
            ResultSet rs = statement.getResultSet();
            rs.next();
            int generatedID = rs.getInt("id");
            System.out.println(GREEN + "id -> " + generatedID);
            return generatedID;
        } catch (SQLException exception) {
            System.out.println("This was not possible to save.");
        }

        return -1;
    }

}
