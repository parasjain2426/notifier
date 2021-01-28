package com.parasjain.notifier.Repositories;

import com.parasjain.notifier.PojoClasses.Notebook;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NotebookRepository extends CrudRepository<Notebook,String> {
    
    @Query("Select notebook from Notebook notebook where notebook.userId=:userId")
    Iterable<Notebook>fetchNotebooksbyUserId(@Param(value = "userId")String userId);
}
