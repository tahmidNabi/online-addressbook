package net.therap.command;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by
 * User: tahmid
 * Date: 6/26/12
 * Time: 6:55 PM
 */

public class ImportCmd {

    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }


}
