package net.therap.utility;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class VersionFourVCardExporter extends AbstractVCardExporter{

    @Override
    public String Header() {


        return "BEGIN:VCARD";
    }

    @Override
    public String exportNameString(String name) {
        String nameString = "N:"+name+";;;;;";
        return nameString;
    }

    @Override
    public String exportFullNameString(String fullName) {
        String fullNameString = "FN: " + fullName;
        return fullNameString;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String exportOrganization(String organization) {
        String organizationString = "ORG:" + organization;
        return organizationString;
    }

    @Override
    public String exportTitle(String title) {
        String titleString = "TITLE: " + title;
        return titleString;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String exportPhoto(String photo) {
        String photoString = "PHOTO:" + photo;
        return photoString;
    }

    @Override
    public String exportHomeTelephone(String homeTelephone) {
        String homeTelephoneString = "TEL;TYPE=\"home,voice\";VALUE=uri:tel:"+ homeTelephone;
        return homeTelephoneString;
    }

    @Override
    public String exportOfficeTelephone(String officeTelephone) {
        String officeTelephoneString = "TEL;TYPE=\"work,voice\";VALUE=uri:tel:"+ officeTelephone;
        return officeTelephoneString;
    }

    @Override
    public String exportAddress(String address) {
        String addressString = "ADR;TYPE=work;LABEL=\"" + address + "\"";
        return addressString;

    }

    @Override
    public String exportEmail(String email) {
        String emailString = "EMAIL:" + email;
        return emailString;
    }

    @Override
    public String exportRev(Date Rev) {
        String revString = "REV:" + Rev.toString().replace(" ","T").replace(":","").replace("-","").replace(".","").concat("Z");
        return revString;
    }

    @Override
    public String exportVersion(float version) {
        return "VERSION:"+version;
    }

    @Override
    public String Footer() {
        return "END:VCARD";
    }
}

