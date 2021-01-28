package com.parasjain.notifier.Services;

import java.util.List;

import com.parasjain.notifier.PojoClasses.Notes;

public interface NoteService {
    List<Notes> fetchNotesbyNotebookId(String notebookId);
	void save(Notes notes);
	void save(String noteName, String notebookId, String start, String end, String reminder, String tag, String status,
			String description);
	void deletebyNotebookId(String notebookId);
	List<Notes> fetchNotesbyUserId(String userId);
	void deletebyId(String noteId);
	String fetchNotebookIdbyId(String noteId);
	void edit(String noteId, String noteName, String start, String end, String reminder, String tag, String status,
			String description);
	List<Notes> fetchReminder(String userId);
	Notes fetchNotebyId(String noteId);		
}
