package net.therap.utility;

import net.therap.domain.VCard;

import java.util.Date;

/**
 * Created by
 * User: tahmid
 * Date: 6/26/12
 * Time: 4:10 PM
 */

public abstract class AbstractVCardExporter implements VCardExporter{

    public abstract String Header();

    public abstract String exportVersion(String version);

    public abstract String exportNameString(String name);

    public abstract String exportFullNameString(String fullName);

    public abstract String exportOrganization(String organization);

    public abstract String exportTitle(String title);

    public abstract String exportPhoto(String photo);

    public abstract String exportHomeTelephone(String homeTelephone);

    public abstract String exportOfficeTelephone(String officeTelephone);

    public abstract String exportAddress(String address);

    public abstract String exportEmail(String email);

    public abstract String exportRev(Date Rev);

    public abstract String Footer ();

    public String ExportVCard(VCard vCard) {

        String ExportedVCard = Header() + "\n" + exportVersion(vCard.getvCardVersion()) + "\n" + exportNameString(vCard.getName()) + "\n" + exportFullNameString(vCard.getFullName()) + "\n" + exportOrganization(vCard.getOrganization()) + "\n"
                + exportTitle(vCard.getTitle()) + "\n" + exportPhoto(vCard.getPhoto()) + "\n" + exportOfficeTelephone(vCard.getOfficeTelephone()) + "\n"
                + exportHomeTelephone(vCard.getHomeTelephone()) + "\n" + exportAddress(vCard.getAddress()) + "\n" + exportEmail(vCard.getEmail()) + "\n" +
                exportRev(vCard.getRev()) + Footer();


        return ExportedVCard;
    }


}
