package com.parasjain.notifier.PojoClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Notes {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    @Id
   private String noteId;
   
   private String notebookId;
   private String noteName;
   private String description;
   private String startDate;
   private String endDate;
   private String reminderDate;
   private String tag;
   private String status;

   public String getNoteId() {
       return this.noteId;
   }

   public void setNoteId(String noteId) {
       this.noteId = noteId;
   }

   public String getNotebookId() {
       return this.notebookId;
   }

   public void setNotebookId(String notebookId) {
       this.notebookId = notebookId;
   }

   public String getNoteName() {
       return this.noteName;
   }

   public void setNoteName(String noteName) {
       this.noteName = noteName;
   }

   public String getDescription() {
       return this.description;
   }

   public void setDescription(String description) {
       this.description = description;
   }

   public String getStartDate() {
       return this.startDate;
   }

   public void setStartDate(String startDate) {
       this.startDate = startDate;
   }

   public String getEndDate() {
       return this.endDate;
   }

   public void setEndDate(String endDate) {
       this.endDate = endDate;
   }

   public String getReminderDate() {
       return this.reminderDate;
   }

   public void setReminderDate(String reminderDate) {
       this.reminderDate = reminderDate;
   }

   public String getTag() {
       return this.tag;
   }

   public void setTag(String tag) {
       this.tag = tag;
   }

   public String getStatus() {
       return this.status;
   }

   public void setStatus(String status) {
       this.status = status;
   }

   
}
