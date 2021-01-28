package com.parasjain.notifier.Validator;
import com.parasjain.notifier.Services.UserService;

public class Validator {
    public enum IsValidForm{
        USERNAME_GREATER_THAN_ONE,
        PASSWORD_GREATER_THAN_FIVE,
        PASSWORD_AND_CONFIRMPASSWORD_NOT_MATCH,
        TEN_DIGIT_MOBILENO,
        NUMERIC_MOBILENO,
        VALID;
    }

    public boolean isValidate(String password,String username,UserService userService){ 
        String id = userService.fetchId(username, password);
        if(id!=null){
            return true;
        }
        return false;
    }

    public boolean isLogged(String userId,UserService userService){
        String id = (userId);
       if(userService.fetchEnabled(id)){
           return true;
       }
        return false;
    }

    public IsValidForm isValidForm(String username,String password,String cpassword,String mobileno){
        if(username.length()<=1){
            return IsValidForm.USERNAME_GREATER_THAN_ONE;
        }
        else if(password.length()<=5){
            return IsValidForm.PASSWORD_GREATER_THAN_FIVE;
        }
        else if(!password.equals(cpassword)){
            return IsValidForm.PASSWORD_AND_CONFIRMPASSWORD_NOT_MATCH;
        }
        else if(mobileno.length()<10){
            return IsValidForm.TEN_DIGIT_MOBILENO;
        }
        else if(!mobileno.matches("([1-9]){1,1}([0-9]){9,9}")){
            return IsValidForm.NUMERIC_MOBILENO;
        }
        return IsValidForm.VALID;
    }
}
