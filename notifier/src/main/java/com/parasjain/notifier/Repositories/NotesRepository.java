package com.parasjain.notifier.Repositories;

import com.parasjain.notifier.PojoClasses.Notes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NotesRepository extends CrudRepository<Notes,String> {
    
@Query("Select note from Notes note where note.notebookId=:notebookId")
Iterable<Notes> fetchAllbyNotebookId(@Param("notebookId")String notebookId);

@Query("delete from Notes note where note.notebookId=:notebookId")
void deleteNotesbyNotebookId(@Param("notebookId")String notebookId);

@Query("Select note from Notes note where note.notebookId In (Select notebook.notebookId from Notebook notebook where notebook.userId=:userId)")
Iterable<Notes> fetchAllbyUserId(@Param("userId")String userId);

@Query("Select notebookId from Notes where noteId=:noteId")
String fetchNotebookIdbyId(@Param("noteId")String noteId);

@Query("Select note from Notes note where note.reminderDate=cast(now() as date) and note.notebookId In (Select notebook.notebookId from Notebook notebook where notebook.userId=:userId)")
Iterable<Notes> fetchNotesbyReminder(@Param("userId")String userId); 

}
