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
        this.text = text.strip();
        this.creationDate = LocalDateTime.now();
        this.user = user.strip();
        this.likes = 0;
        this.dislikes = 0;
        this.acceptedAnswer = false;
        this.questionIdentifier = questionIdentifier;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        if (likes>=0) {
            this.likes = likes;
        }
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        if (dislikes>=0) {
            this.dislikes = dislikes;
        }
    }

    public boolean isAcceptedAnswer() {
        return acceptedAnswer;
    }

    public void setAcceptedAnswer(boolean acceptedAnswer) {
        this.acceptedAnswer = acceptedAnswer;
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
