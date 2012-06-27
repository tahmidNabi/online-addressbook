package net.therap.validator;

import net.therap.command.LoginCmd;
import net.therap.command.VCardCmd;
import net.therap.domain.VCard;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import javax.validation.Validation;
import javax.xml.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/27/12
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class VCardEntryValidator implements org.springframework.validation.Validator{

    public boolean supports(Class<?> aClass) {
        return VCardCmd.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.userName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "required.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organization", "required.organization");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required.title");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "photo", "required.photo");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homeTelephone", "required.homeTelephone");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "workTelephone", "required.officeTelephone");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required.address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.userName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email");



    }
}
