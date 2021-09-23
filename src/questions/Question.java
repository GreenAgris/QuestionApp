package questions;

import answers.Answer;
import java.time.LocalDateTime;

public class Question {

    String text;
    String user;
    LocalDateTime creationDateTime;
    short score;
    public String identifier;

    Answer answer;

    public Question(String text, String user) {
        this.text = text;
        this.user = user;
        this.score = 0;
        this.creationDateTime = LocalDateTime.now();
        this.identifier = "identifier";
    }

    public Question(String text, String user, String identifier) {
        this.text = text;
        this.user = user;
        this.score = 0;
        this.creationDateTime = LocalDateTime.now();
        this.identifier = identifier;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        if (answer != null) {
            this.answer = answer;
        }
    }

    @Override
    public String toString() {
        return "Question{" +
            "text='" + text + '\'' +
            ", user='" + user + '\'' +
            ", creationDateTime=" + creationDateTime +
            ", score=" + score +
            ", identifier='" + identifier + '\'' +
            ", answer=" + answer +
            '}';
    }
}
