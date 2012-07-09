package net.therap.validator;

import net.therap.command.ImportCmd;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by
 * User: tahmid
 * Date: 6/27/12
 * Time: 5:54 PM
 */

public class ImportValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return ImportCmd.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        ImportCmd importCmd = (ImportCmd) o;

        if(importCmd.getFile()==null || importCmd.getFile().getSize() == 0){

            errors.rejectValue("file","required.file");
            return;
        }


    }
}
