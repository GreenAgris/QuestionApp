package questions;

import Entry.EntryDatabase;
import answers.Answer;
import answers.AnswerDatabase;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuestionDatabase {

    public static ArrayList<Question> getQuestionList(Statement statement) {
        ArrayList<Question> qlist = new ArrayList();
        try {
            statement.execute("SELECT id FROM Question ;");
            ResultSet rs = statement.getResultSet();
            ArrayList<Integer> idList = new ArrayList<>();
            while (rs.next()) {
                int checkable = rs.getInt("id");
                idList.add(checkable);
            }

            for (Integer id : idList){
                qlist.add(getQuestion(statement, id));
            }

        } catch (SQLException exception) {
            System.out.println("This was not possible to retrieve.");
        }

        return qlist;
    }

    public static Question getQuestion(Statement statement, int id) {
        try {
            statement.execute("SELECT * FROM Question WHERE id = " + id + ";");
            ResultSet rs = statement.getResultSet();
            rs.next();

            Question output = new Question("", "");
            output.score = rs.getShort("score");
            int entryId = rs.getInt("entryId");
            EntryDatabase.selectEntry(statement, entryId, output);
            statement.execute("SELECT Answer.id FROM Answer INNER JOIN Entry ON  Answer.entryId = Entry.id WHERE Entry.questionIdentifier = '"
                + output.getIdentifier() + "';");
            rs = statement.getResultSet();


            ArrayList<Integer> answerList = new ArrayList();

            while (rs.next()) {
                int checkable = rs.getInt("id");
                answerList.add(checkable);
            }

            for (Integer ansId : answerList){
                output.getAnswer().put(ansId, AnswerDatabase.getAnswer(statement, ansId));
            }

            return output;
        } catch (SQLException exception) {
            System.out.println("This Question was not possible to retrieve.");
        }
        return null;
    }

    public static int saveQuestion(Statement statement,Question input) {
        try {
            int entryId = EntryDatabase.saveEntry(statement, input);
            if (entryId == -1) {
                throw new SQLDataException();
            }

            statement.execute("INSERT INTO Question (score,entryId) VALUES" +
                "(" + input.score + "," + entryId + ");");

            String queryLastRowInserted = "SELECT last_insert_rowid() AS id";
            statement.execute(queryLastRowInserted);
            ResultSet rs = statement.getResultSet();
            rs.next();
            int generatedID = rs.getInt("id");

            for (Answer ans : input.getAnswer().values()) {
                AnswerDatabase.saveAnswer(statement, ans);
            }
            return generatedID;


        } catch (SQLDataException exception2) {
            System.out.println("This was not possible to save. Because the Entry was not already saved.");
        } catch (
            SQLException exception) {
            System.out.println("This was not possible to save.");
        }
        return -1;
    }
}
