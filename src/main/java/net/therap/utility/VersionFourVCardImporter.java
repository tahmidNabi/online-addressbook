package net.therap.utility;

import net.therap.domain.VCard;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class VersionFourVCardImporter implements VCardImporter {

    private final int nameTokenIndex = 2;
    private final int fullTokenNameIndex = 3;
    private final int orgTokenIndex = 4;
    private final int titleTokenIndex = 5;
    private final int photoTokenIndex = 6;
    private final int officeTokenIndex = 7;
    private final int homeTokenIndex = 8;
    private final int addressTokenIndex = 9;
    private final int emailTokenIndex = 10;

    private final int nameStartLocation = 2;
    private final int fullNameStartLocation = 4;
    private final int orgStartLocation = 4;
    private final int titleStartLocation = 6;
    private final int photoStartLocation = 6;
    private final int officeTelephoneStartLocation = 36;
    private final int homeTelephoneStartLocation = 36;
    private final int addressStartLocation = 21;
    private final int emailStartLocation = 6;

    private final int nameEndLocation = 5;


    public VCard importVCard(String importedData) {
        VCard vCard = new VCard();

        String[] tokens = importedData.split("\n");

        /*System.out.println(name(tokens[2]));
        System.out.println(fullName(tokens[3]));
        System.out.println(organization(tokens[4]));
        */
        vCard.setName(name(tokens[nameTokenIndex]));
        vCard.setFullName(fullName(tokens[fullTokenNameIndex]));
        vCard.setOrganization(organization(tokens[orgTokenIndex]));
        vCard.setTitle(title(tokens[titleTokenIndex]));
        vCard.setPhoto(photo(tokens[photoTokenIndex]));
        vCard.setOfficeTelephone(officeTelephone(tokens[officeTokenIndex]));
        vCard.setHomeTelephone(homeTelephone(tokens[homeTokenIndex]));
        vCard.setAddress(address(tokens[addressTokenIndex]));
        vCard.setEmail(email(tokens[emailTokenIndex]));

        return vCard;
    }

    public String name(String importedName) {

        String name = importedName.substring(nameStartLocation, importedName.length()-nameEndLocation);

        return name;

    }

    public String fullName(String importedfullName) {
        String fullName = importedfullName.substring(fullNameStartLocation, importedfullName.length());
        return fullName;
    }

    public String organization(String importedOrg) {
        String organization = importedOrg.substring(orgStartLocation, importedOrg.length());
        return organization;
    }

    public String title(String importedTitle) {
        String title = importedTitle.substring(titleStartLocation, importedTitle.length());
        return title;
    }

    public String photo(String importedPhoto) {
        String photo = importedPhoto.substring(photoStartLocation, importedPhoto.length());
        return photo;
    }

    public String officeTelephone(String importedOfficeTelephone) {
        String officeTelephone = importedOfficeTelephone.substring(officeTelephoneStartLocation, importedOfficeTelephone.length());
        return officeTelephone;
    }

    public String homeTelephone(String importedHomeTelephone) {
        String homeTelephone = importedHomeTelephone.substring(homeTelephoneStartLocation, importedHomeTelephone.length());
        return homeTelephone;
    }

    public String address(String importedAddress) {
        String address = importedAddress.substring(addressStartLocation, importedAddress.length()-1);
        return address;
    }

    public String email(String importedEmail) {
        String email = importedEmail.substring(emailStartLocation, importedEmail.length());
        return email;
    }

}
