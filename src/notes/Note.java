package notes;

import java.time.LocalDateTime;

public class Note {
    private String title;
    private String content;
    private LocalDateTime creationDate;

    public Note() {
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        creationDate = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
