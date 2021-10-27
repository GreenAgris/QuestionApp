package answers;

import Comment.Comment;
import Entry.Entry;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Answer extends Entry {

    private static int answerID = 0;
    private String[] allLabels = {"SameAuthor", "Spoiler", "Edited", "Archived", "Humorous"};
    ArrayList<Comment> comments = new ArrayList<>();
    final int id;
    int likes;
    int dislikes;
    boolean acceptedAnswer;

    String labels; // "SameAuthor, Archived"

    public Answer(int id) {
        super("", "", LocalDateTime.now(), "");
        this.id = id;
    }

    public Answer(String text, String user, String questionIdentifier) {
        super(text.strip(), user.strip(), LocalDateTime.now(), questionIdentifier);
        this.user = user.strip();
        this.likes = 0;
        this.dislikes = 0;
        this.acceptedAnswer = false;
        this.id = answerID++;
        this.labels = "";
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(final String labels) {
        // "SameAuthor, archived"
        String[] testableArray = labels.split(",");
        boolean isItInLabels = true;
        for (String testableString : testableArray) {
            boolean isthisOneLabelFound = false;
            for (String definedLabel : allLabels) {
                if ((testableString.strip()).equalsIgnoreCase(definedLabel)) {
                    isthisOneLabelFound = true;
                }
            }
            if (!isthisOneLabelFound) {
                isItInLabels = false;
            }
        }
        if (isItInLabels) {
            this.labels = labels;
        } else {
            System.out.println("This label was not allowed");
        }
    }


    public boolean addComment(String text, final String user) {
        Comment comment = new Comment(text.strip(), user, LocalDateTime.now(), this.questionIdentifier, id + "");
        this.comments.add(comment);
        return true;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        if (likes >= 0) {
            this.likes = likes;
        }
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        if (dislikes >= 0) {
            this.dislikes = dislikes;
        }
    }

    public boolean isAcceptedAnswer() {
        return acceptedAnswer;
    }

    public void setAcceptedAnswer(boolean acceptedAnswer) {
        this.acceptedAnswer = acceptedAnswer;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Answer{" +
            "id='" + id + '\'' +
            "text='" + text + '\'' +
            ", creationDate=" + super.creationDateTime +
            ", user='" + user + '\'' +
            ", likes=" + likes +
            ", dislikes=" + dislikes +
            ", acceptedAnswer=" + acceptedAnswer +
            ", questionIdentifier='" + questionIdentifier + '\'' +
            '}';
    }
}
