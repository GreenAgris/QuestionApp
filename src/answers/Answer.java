package answers;

import java.time.LocalDateTime;

public class Answer {

    String text;
    LocalDateTime creationDate;
    String user;
    int likes;
    int dislikes;
    boolean acceptedAnswer;
    String questionIdentifier;

    public Answer(String text, String user, String questionIdentifier) {
        this.text = text;
        this.creationDate = LocalDateTime.now();
        this.user = user;
        this.likes = 0;
        this.dislikes = 0;
        this.acceptedAnswer = false;
        this.questionIdentifier = questionIdentifier;
    }

    @Override
    public String toString() {
        return "Answer{" +
            "text='" + text + '\'' +
            ", creationDate=" + creationDate +
            ", user='" + user + '\'' +
            ", likes=" + likes +
            ", dislikes=" + dislikes +
            ", acceptedAnswer=" + acceptedAnswer +
            ", questionIdentifier='" + questionIdentifier + '\'' +
            '}';
    }
}
