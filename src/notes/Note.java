package notes;

import java.time.LocalDateTime;

public class Note {
    private final String title;
    private final String content;
    private final LocalDateTime creationDate;


    public Note(String title, String content, LocalDateTime creationDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

}
