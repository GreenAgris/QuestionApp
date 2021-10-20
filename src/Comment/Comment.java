package Comment;

import Entry.Entry;
import java.time.LocalDateTime;

public class Comment extends Entry {
    String answerIdentifier;

    public Comment(String text, String user, LocalDateTime creationDateTime, String questionIdentifier) {
        super(text, user, creationDateTime, questionIdentifier);
    }

    public Comment(String text, String user, LocalDateTime creationDateTime, String questionIdentifier, String answerIdentifier) {
        super(text, user, creationDateTime, questionIdentifier);
        this.answerIdentifier = answerIdentifier;
    }

    public Comment() {
        super("text", "user", LocalDateTime.now(), "questionIdentifier");
    }
}
