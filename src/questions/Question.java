package questions;

import Comment.Comment;
import Entry.Entry;
import answers.Answer;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;

public class Question extends Entry {

    private static int idCounter = 0;
    short score;
    Comment[] comments = new Comment[5];
    HashMap<Integer, Answer> answer = new HashMap<>();

    public Question(String text, String user) {
        super(text.strip(), user.strip(), LocalDateTime.now(), idCounter + "identifier");
        this.score = 0;
        idCounter++;
    }

    public Question(String text, String user, String identifier) {
        super(text.strip(), user.strip(), LocalDateTime.now(), idCounter + identifier);
        this.score = 0;
        idCounter++;
    }

    public Answer getAnswer(int id) {
        return answer.get(id);
    }

    public HashMap<Integer, Answer> getAnswer() {
        return this.answer;
    }

    public void setAnswer(Answer answer) {
        this.answer.put(answer.getId(), answer);
    }

    public String getIdentifier() {
        return super.questionIdentifier;
    }

    @Override
    public String toString() {
        return "Question{" +
            "text='" + text + '\'' +
            ", user='" + user + '\'' +
            ", creationDateTime=" + creationDateTime +
            ", score=" + score +
            ", identifier='" + questionIdentifier + '\'' +
            ", answer=" + Arrays.toString(answer.values().toArray()) +
            '}';
    }
}
