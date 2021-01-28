package com.parasjain.notifier.PojoClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Notebook {
    
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    @Id
    private String notebookId;

    @Column(nullable = false)
    private String userId;
    private String notebookName; 
    private int notesCount;

    public int getNotesCount() {
        return this.notesCount;
    }

    public void setNotesCount(int notesCount) {
        this.notesCount = notesCount;
    }

    public void setNotebookId(String notebookId){
        this.notebookId = notebookId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public void setNotebookName(String notebookName){
        this.notebookName = notebookName;
    }

    public String getNotebookId(){
        return this.notebookId;
    }

    public String getUserId(){
        return this.userId;
    }

    public String getNotebookName(){
        return this.notebookName;
    }

}
