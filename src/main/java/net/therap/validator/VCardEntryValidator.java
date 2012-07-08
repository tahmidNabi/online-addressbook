package net.therap.validator;

import net.therap.domain.VCard;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/27/12
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class VCardEntryValidator implements org.springframework.validation.Validator{

    public boolean supports(Class<?> aClass) {
        return VCard.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "required.fullName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organization", "required.organization");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required.title");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "photo", "required.photo");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homeTelephone", "required.homeTelephone");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "officeTelephone", "required.officeTelephone");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required.address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email");
    }
}
