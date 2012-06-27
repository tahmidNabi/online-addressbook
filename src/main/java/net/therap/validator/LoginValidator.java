package net.therap.validator;


import net.therap.command.LoginCmd;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/7/12
 * Time: 3:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginValidator implements Validator {

    public boolean supports(Class<?> aClass) {

        return LoginCmd.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required.userName", "User Name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Password is required.");
    }
}
