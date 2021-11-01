package Comment;

import Entry.EntryDatabase;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class CommentDatabase {


    public static int saveComment(Statement statement, Comment comment) {
        try {
            int entryId = EntryDatabase.saveEntry(statement, comment);
            if (entryId == -1) {
                throw new SQLDataException();
            }


            statement.execute("INSERT INTO Comment (answerIdentifier, entryId) VALUES" +

                "(" + comment.answerIdentifier + "," + entryId + ");");

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


    public static Comment getComment(Statement statement, int id) {
        try {

            statement.execute("SELECT * FROM Comments WHERE id = " + id + ";");
            ResultSet rs = statement.getResultSet();
            rs.next();

            Comment comment = new Comment();
            int entryId = rs.getInt("entryId");
            comment.answerIdentifier = rs.getString("answerIdentifier");
            EntryDatabase.selectEntry(statement, entryId, comment);

            return comment;
        } catch (SQLException exception) {
            System.out.println("This was not possible to retrieve.");
        }
        return null;
    }

}
