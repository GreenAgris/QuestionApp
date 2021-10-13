package questions;

import Entry.Entry;
import answers.Answer;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Question extends Entry {

    private static int idCounter = 0;
    short score;

    Answer[] answer = new Answer[3];
    int numberOfAnswers;

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

    public Answer getAnswer(int index) {
        return answer[index];
    }

    public Answer[] getAnswer() {
        return this.answer;
    }

    public void setAnswer(Answer answer) {
        if (answer != null && numberOfAnswers < this.answer.length) {
            this.answer[numberOfAnswers] = answer;
            numberOfAnswers++;
        } else {
            System.out.println("The answers for this question is full. Apologies.");
        }
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
            ", answer=" + Arrays.toString(answer) +
            '}';
    }
}
