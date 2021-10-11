package notes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Notes {
    private final Note passNote = new Note("Пароли", "А их тут нет", LocalDateTime.now());
    private final Note notPassNote = new Note("Неа", "Неа", LocalDateTime.now());
    private final Note notPassNote1 = new Note("Ну нет", "Нет", LocalDateTime.now());
    private final Note notPassNote2 = new Note("Мои пароли", "Нет", LocalDateTime.now());

    public List<Note> getNotesList() {
        List<Note> notes = new ArrayList<>();
        notes.add(passNote);
        notes.add(notPassNote);
        notes.add(notPassNote1);
        notes.add(notPassNote2);
        return notes;
    }

}
