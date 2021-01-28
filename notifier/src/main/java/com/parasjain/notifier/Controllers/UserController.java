package com.parasjain.notifier.Controllers;

import java.util.List;
import java.util.Optional;

import com.parasjain.notifier.PojoClasses.Notebook;
import com.parasjain.notifier.PojoClasses.Notes;
import com.parasjain.notifier.PojoClasses.User;
import com.parasjain.notifier.Services.NoteService;
import com.parasjain.notifier.Services.NotebookService;
import com.parasjain.notifier.Services.UserService;
import com.parasjain.notifier.Validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    NotebookService notebookService;

    @Autowired
    NoteService noteService;

    private Validator validator = new Validator();

    @GetMapping("/signIn/{status}")
    public ModelAndView signIn(@PathVariable(value = "status") String status) {
        ModelAndView mav = new ModelAndView("signIn");
        if (status.length() > 10) {
            mav.addObject("error", status);
        }
        return mav;
    }

    @PostMapping("/validate")
    public String validate(@RequestParam(value = "username", defaultValue = "") String username,
            @RequestParam(value = "password", defaultValue = "") String password) {
        if (validator.isValidate(password, username, userService)) {
            String userId = userService.fetchId(username, password);
            if (validator.isLogged(userId, userService)) {
                userService.updateEnable(false,userId);
                return "redirect:/signIn/Signed out from previous session. Now SignIn again!";
            }
            userService.updateEnable(true,userId);
            return "redirect:/homepage/" + userId;
        }
        return "redirect:/signIn/Invalid Username or Password";
    }

    @GetMapping("/signUp")
    public ModelAndView signUp() {
        ModelAndView mav = new ModelAndView("signUp");
        mav.addObject("error", "");
        return mav;
    }

    @PostMapping("/validateSignUp")
    public ModelAndView validateSignUp(@RequestParam(value = "username", defaultValue = "") String username,
            @RequestParam(value = "mobileno", defaultValue = "") String mobileno,
            @RequestParam(value = "email", defaultValue = "") String email,
            @RequestParam(value = "password", defaultValue = "") String password,
            @RequestParam(value = "cpassword", defaultValue = "") String cpassword) {
        ModelAndView mav = null;
        switch (validator.isValidForm(username, password, cpassword, mobileno)) {
            case USERNAME_GREATER_THAN_ONE:
                mav = new ModelAndView("signUp");
                mav.addObject("error", "Username should be greater than one");
                return mav;
            case PASSWORD_AND_CONFIRMPASSWORD_NOT_MATCH:
                mav = new ModelAndView("signUp");
                mav.addObject("error", "Password and Confirm Password didnot matched");
                return mav;
            case PASSWORD_GREATER_THAN_FIVE:
                mav = new ModelAndView("signUp");
                mav.addObject("error", "Password length should be greater than five");
                return mav;
            case TEN_DIGIT_MOBILENO:
                mav = new ModelAndView("signUp");
                mav.addObject("error", "Mobile number should be ten digit long");
                return mav;
            case NUMERIC_MOBILENO:
                mav = new ModelAndView("signUp");
                mav.addObject("error", "Invalid Mobile No");
                return mav;
            case VALID:
                User user = new User();
                user.setUsername(username);
                user.setMobileNo(mobileno);
                user.setEmail(email);
                user.setPassword(password);
                user.setEnabled(false);
                userService.save(user);
                mav = new ModelAndView("signIn");
                mav.addObject("success", "Succesfully Signed In");
                return mav;
            default:
                mav = new ModelAndView("signUp");
                mav.addObject("error", "Unknown Error Caused");
                return mav;
        }
    }

    @GetMapping("/homepage/{userId}")
    public ModelAndView homepage(@PathVariable(value = "userId") String userId) {
        ModelAndView mav;
        if(validator.isLogged(userId, userService)){
            mav = new ModelAndView("homepage");
            Optional<User> user = userService.findById((userId));
            List<Notebook> listOfNotebooks = (List<Notebook>) notebookService
                    .fetchNotebooksbyUserId((userId));
            if(listOfNotebooks.isEmpty()){
                        mav.addObject("msg", "No Notebook to display");
                    }        
            List<Notes> listOfNotes = noteService.fetchNotesbyUserId((userId));        
            List<Notes> listOfNotesbyReminder = noteService.fetchReminder((userId));
            mav.addObject("reminders", listOfNotesbyReminder);     
            mav.addObject("user", user.get());
            mav.addObject("notebooks", listOfNotebooks);
            mav.addObject("notes", listOfNotes);
            return mav;
        }
        mav = new ModelAndView("signIn");
        return mav;
    }

    @GetMapping("/logout/{userId}")
    public String logout(@PathVariable(value = "userId")String userId){
        userService.updateEnable(false,userId);
        return "redirect:/";
    }

    @PostMapping("/editUser/{userId}")
    public String edit(@PathVariable(value = "userId")String userId,
    @RequestParam(value = "username") String username,
    @RequestParam(value = "mobileNo") String mobileNo,
    @RequestParam(value = "email") String email,
    @RequestParam(value = "password") String password){
        //implement validator for details...
        User user = userService.findById((userId)).get();
        user.setUsername(username);
        user.setEmail(email);
        user.setMobileNo(mobileNo);
        user.setPassword(password);
        userService.save(user);
        return "redirect:/homepage/"+userId;
    }

}
