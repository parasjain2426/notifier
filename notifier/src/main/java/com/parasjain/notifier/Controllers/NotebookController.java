package com.parasjain.notifier.Controllers;

import java.util.List;
import java.util.Map;

import com.parasjain.notifier.PojoClasses.Notebook;
import com.parasjain.notifier.Services.NoteService;
import com.parasjain.notifier.Services.NotebookService;
import com.parasjain.notifier.PojoClasses.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NotebookController {

    @Autowired
    NotebookService notebookService;

    @Autowired
    NoteService noteService;
    
    @PostMapping("/newNotebook/{userId}")
    public String newNotebook(@PathVariable(value = "userId")String userId,@RequestParam(value = "notebookName", defaultValue = "")String notebookName){
        notebookService.save(notebookName,(userId),0);
        return "redirect:/homepage/"+userId;
    }

    @GetMapping("/notebookDisplay/{notebookId}")
    public ModelAndView displayNotebook(@PathVariable(value = "notebookId")String notebookId){
        List<Notes> notes = (List<Notes>) noteService.fetchNotesbyNotebookId((notebookId));
        ModelAndView mav = new ModelAndView("displayNotebookNotes");
        mav.addObject("notebookNotes", notes);
        return mav;
    }

    @PostMapping("/editNotebook/{userId}/{notebookId}")
    public String editNotebook(@PathVariable Map<String,String> pathVarsMap,@RequestParam(value = "notebookNameEdit",defaultValue = "")String notebookNameEdit){
        String userId = pathVarsMap.get("userId");
        String notebookId = pathVarsMap.get("notebookId");
        Notebook notebook = notebookService.findById((notebookId)).get();
        notebook.setNotebookName(notebookNameEdit);
        notebookService.save(notebook);
        return "redirect:/homepage/"+userId;
    }

    @GetMapping("/delete/{userId}/{notebookId}")
    public String deleteNotebook(@PathVariable Map<String,String> pathVarsMap){
        String userId = pathVarsMap.get("userId");
        String notebookId = pathVarsMap.get("notebookId");
        noteService.deletebyNotebookId((notebookId));
        notebookService.deleteById((notebookId));
        return "redirect:/homepage/"+userId;
    }
}
