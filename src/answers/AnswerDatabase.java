package answers;

import Entry.EntryDatabase;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class AnswerDatabase {

    public static int saveAnswer(Statement statement, Answer input) {
        try {
            int entryId = EntryDatabase.saveEntry(statement, input);
            if (entryId == -1) {
                throw new SQLDataException();
            }

            statement.execute("INSERT INTO Answer (likes,dislikes,acceptedAnswer,labels,entryId) VALUES" +

                "(" + input.likes + "," + input.dislikes + "," + (input.acceptedAnswer ? 1 : 0) + ",'" + input.labels + "', " + entryId
                + ");");
            //return id
            String queryLastRowInserted = "SELECT last_insert_rowid() AS id";
            statement.execute(queryLastRowInserted);
            ResultSet rs = statement.getResultSet();
            rs.next();
            int generatedID = rs.getInt("id");
            return generatedID;


        } catch (SQLDataException exception2) {
            System.out.println("This was not possible to save. Because the Entry was not already saved.");
        } catch (SQLException exception) {
            System.out.println("This was not possible to save.");
        }

        return -1;

    }

    public static Answer getAnswer(Statement statement, int id) {
        try {
            statement.execute("SELECT * FROM Answer WHERE id = " + id + ";");
            ResultSet rs = statement.getResultSet();
            rs.next();

            Answer output = new Answer(id);
            int entryId = rs.getInt("entryId");
            output.likes = rs.getInt("likes");
            output.dislikes = rs.getInt("dislikes");
            output.acceptedAnswer = rs.getInt("acceptedAnswer") == 1;
            output.labels = rs.getString("labels");

            EntryDatabase.selectEntry(statement, entryId, output);

            return output;
        } catch (SQLException exception) {
            System.out.println("This was not possible to retrieve.");
        }
        return null;
    }

}
