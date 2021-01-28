package com.parasjain.notifier.Services;

import java.util.Optional;

import com.parasjain.notifier.PojoClasses.Notebook;
import com.parasjain.notifier.Repositories.NotebookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    NotebookRepository notebookRepository;

    @Override
    public Iterable<Notebook> fetchNotebooksbyUserId(String userId) {
        return notebookRepository.fetchNotebooksbyUserId(userId);
    }

    @Override
    public void save(Notebook notebook) {
       notebookRepository.save(notebook);

    }

    @Override
    public Optional<Notebook> findById(String Id) {
        return notebookRepository.findById(Id);
    }

    @Override
    public void deleteById(String Id) {
        notebookRepository.deleteById(Id);

    }

    @Override
    public void updateCountbyId(String notebookId,int newCount) {
        Notebook notebook = notebookRepository.findById(notebookId).get();
        int count = notebook.getNotesCount();
        notebook.setNotesCount(count+newCount);
        notebookRepository.save(notebook);
    }

    @Override
    public void save(String notebookName, String userId, int notesCount) {
       Notebook notebook = new Notebook();
       notebook.setNotebookName(notebookName);
       notebook.setUserId(userId);
       notebook.setNotesCount(notesCount);
       notebookRepository.save(notebook);
    }
    
}
