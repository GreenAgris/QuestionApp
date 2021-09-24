package questions;

import answers.Answer;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Question {

    String text;
    String user;
    LocalDateTime creationDateTime;
    short score;
    public String identifier;

    Answer[] answer = new Answer[3];
    int numberOfAnswers;

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

    public Answer getAnswer(int index) {
        return answer[index];
    }

    public Answer[] getAnswer() {
        return this.answer;
    }

    public void setAnswer(Answer answer) {
        if (answer != null && numberOfAnswers < this.answer.length){
            this.answer[numberOfAnswers] = answer;
            numberOfAnswers++;
        }else {
            System.out.println("The answers for this question is full. Apologies.");
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
            ", answer=" + Arrays.toString(answer) +
            '}';
    }
}
