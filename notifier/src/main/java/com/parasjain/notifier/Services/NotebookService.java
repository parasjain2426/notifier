package com.parasjain.notifier.Services;

import java.util.Optional;

import com.parasjain.notifier.PojoClasses.Notebook;

public interface NotebookService {
    Iterable<Notebook> fetchNotebooksbyUserId(String userId);

	void save(Notebook notebook);

	Optional<Notebook> findById(String notebookId);

	void deleteById(String notebookId);

	void updateCountbyId(String notebookId,int newCount);

	void save(String notebookName, String userId, int notesCount);
}
