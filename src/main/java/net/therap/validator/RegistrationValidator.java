package net.therap.validator;


import net.therap.command.RegistrationCmd;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/7/12
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationValidator implements Validator {

    public boolean supports(Class<?> aClass) {

        return RegistrationCmd.class.equals(aClass);
    }


    public void validate(Object o, Errors errors) {
        RegistrationCmd registrationCmd = (RegistrationCmd) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required.userName", "User Name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Password is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required.confirmPassword", "Confirm the password.");


        if (!(registrationCmd.getPassword().equals(registrationCmd.getConfirmPassword()))) {
            errors.rejectValue("password", "notmatch.password");
        }

    }
}