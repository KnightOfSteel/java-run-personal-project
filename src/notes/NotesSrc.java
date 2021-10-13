package notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class NotesSrc {
    private final List<Note> notes;

    public NotesSrc(List<Note> notes) {
        this.notes = notes;
    }

    public NotesSrc(Note... notes) {
        this.notes = Arrays.asList(notes);
    }

    public List<Note> getNotesList() {
        return notes;
    }

    public List<Note> searchBy(String findString) {
        List<Note> notes = getNotesList();
        List<Note> result = new ArrayList<>();
        for (Note note : notes) {
            if (note.getTitle().toLowerCase().contains(findString)) {
                result.add(note);
            }
        }
        return result;
    }

}
