package Entry;

import java.time.LocalDateTime;

public abstract class Entry {

    protected String text;
    protected String user;
    protected LocalDateTime creationDateTime;
    protected String questionIdentifier;

    protected Entry(String text, String user, LocalDateTime creationDateTime, String questionIdentifier) {
        this.text = text;
        this.user = user;
        this.creationDateTime = creationDateTime;
        this.questionIdentifier = questionIdentifier;
    }

}
