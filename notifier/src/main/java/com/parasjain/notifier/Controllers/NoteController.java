package com.parasjain.notifier.Controllers;

import java.util.List;
import java.util.Map;

import com.parasjain.notifier.PojoClasses.Notes;
import com.parasjain.notifier.Services.NoteService;
import com.parasjain.notifier.Services.NotebookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {
    @Autowired
    NotebookService notebookService;

    @Autowired
    NoteService noteService;

     @PostMapping("/addNote/{userId}/{notebookId}")
     public String addNote(@PathVariable Map<String,String> pathVarsMap,@RequestParam(value="notename",defaultValue="")String noteName,@RequestParam(value="start",defaultValue="")String start,@RequestParam(value = "end",defaultValue="")String end,@RequestParam(value = "reminder",defaultValue="")String reminder,@RequestParam(value = "tag",defaultValue="")String tag,@RequestParam(value = "status",defaultValue="")String status,@RequestParam(value = "description",defaultValue="")String description){
         String userId = pathVarsMap.get("userId");
         String notebookId = pathVarsMap.get("notebookId");
         noteService.save(noteName,(notebookId),start,end,reminder,tag,status,description);
         notebookService.updateCountbyId((notebookId),1);
         return "redirect:/homepage/"+userId;
     }

     @GetMapping("/delete/note/{userId}/{noteId}")
     public String deleteNote(@PathVariable Map<String,String> pathVarsMap){
        String userId = pathVarsMap.get("userId");
        String noteId = pathVarsMap.get("noteId");
        String notebookId = noteService.fetchNotebookIdbyId((noteId));
        noteService.deletebyId((noteId));
        notebookService.updateCountbyId((notebookId),-1);
        return "redirect:/homepage/"+userId;
     }

     @PostMapping("/editNote/{userId}/{noteId}")
     public String editNote(@PathVariable Map<String,String> pathVarsMap,@RequestParam(value="notename",defaultValue="")String noteName,@RequestParam(value="start",defaultValue="")String start,@RequestParam(value = "end",defaultValue="")String end,@RequestParam(value = "reminder",defaultValue="")String reminder,@RequestParam(value = "tag",defaultValue="")String tag,@RequestParam(value = "status",defaultValue="")String status,@RequestParam(value = "description",defaultValue="")String description){
         String userId = pathVarsMap.get("userId");
         String noteId = pathVarsMap.get("noteId");
         noteService.edit((noteId),noteName,start,end,reminder,tag,status,description);
         return "redirect:/homepage/"+userId;
     }
     
     @GetMapping("/notesDisplay/{userId}/{notebookId}")
     public ModelAndView showNotebookNotes(@PathVariable Map<String,String> pathVarsMap){
        String userId = pathVarsMap.get("userId");
        String notebookId = pathVarsMap.get("notebookId");
        ModelAndView mav = new ModelAndView("displayNotebookNotes");
        List<Notes> listOfNotes = noteService.fetchNotesbyNotebookId((notebookId));
        mav.addObject("userId", userId);
        mav.addObject("notes", listOfNotes);
        return mav;
     }

     @GetMapping("/noteDisplay/{noteId}")
     public ModelAndView noteDisplay(@PathVariable(value = "noteId")String noteId){
         Notes note = noteService.fetchNotebyId((noteId));
         ModelAndView mav = new ModelAndView("displayNoteDetails");
         mav.addObject("note", note);
         return mav;
     }

}
