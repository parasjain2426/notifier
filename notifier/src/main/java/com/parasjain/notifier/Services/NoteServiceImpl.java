package com.parasjain.notifier.Services;

import java.util.List;

import com.parasjain.notifier.PojoClasses.Notes;
import com.parasjain.notifier.Repositories.NotesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NotesRepository notesRepository;

    @Override
    public List<Notes> fetchNotesbyNotebookId(String notebookId) {
        return (List<Notes>)notesRepository.fetchAllbyNotebookId(notebookId);
    }

    @Override
    public void save(Notes notes) {
        notesRepository.save(notes);
    }

    @Override
    public void save(String noteName, String notebookId, String startDate, String endDate, String reminderDate, String tag,
            String status, String description) {
        Notes notes = new Notes();
        notes.setNoteName(noteName);
        notes.setNotebookId(notebookId);
        notes.setStartDate(startDate);
        notes.setEndDate(endDate);
        notes.setReminderDate(reminderDate);
        notes.setTag(tag);
        notes.setStatus(status);
        notes.setDescription(description);
        notesRepository.save(notes);
    }

    @Override
    public void deletebyNotebookId(String notebookId) {
        notesRepository.deleteNotesbyNotebookId(notebookId);
    }

    @Override
    public List<Notes> fetchNotesbyUserId(String userId) {
        return (List<Notes>)notesRepository.fetchAllbyUserId(userId);
    }

    @Override
    public void deletebyId(String noteId) {
       notesRepository.deleteById(noteId);

    }

    @Override
    public String fetchNotebookIdbyId(String noteId) {
        return notesRepository.fetchNotebookIdbyId(noteId);
    }

    @Override
    public void edit(String noteId, String noteName, String startDate, String endDate, String reminderDate, String tag, String status,
            String description) {
        Notes note = notesRepository.findById(noteId).get();
        note.setDescription(description);
        note.setStartDate(startDate);
        note.setEndDate(endDate);
        note.setReminderDate(reminderDate);
        note.setStatus(status);
        note.setTag(tag);
        note.setNoteName(noteName);
        notesRepository.save(note);
    }

    @Override
    public List<Notes> fetchReminder(String userId) {
        return (List<Notes>)notesRepository.fetchNotesbyReminder(userId);
    }

    @Override
    public Notes fetchNotebyId(String noteId) {
        return notesRepository.findById(noteId).get();
    }
    
}
