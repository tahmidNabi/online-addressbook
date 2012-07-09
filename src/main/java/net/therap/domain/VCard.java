package net.therap.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by
 * User: tahmid
 * Date: 6/26/12
 * Time: 10:57 AM
 */

@Entity
@Table(name = "T_ADDRESS_BOOK_VCARD")
public class VCard {

    private int vCardId;
    private User owningUser;
    private String name;
    private String fullName;
    private String organization;
    private String title;
    private String photo;
    private String homeTelephone;
    private String officeTelephone;
    private String address;
    private String email;
    private Date rev;
    private String vCardVersion;
    private int version;

    @Id
    @SequenceGenerator(name = "T_ADDRESS_VCARD", sequenceName = "T_ADDRESS_VCARD")
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "T_ADDRESS_VCARD")

    @Column(name = "VCARD_ID")
    public int getvCardId() {
        return vCardId;
    }

    public void setvCardId(int vCardId) {
        this.vCardId = vCardId;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getOwningUser() {
        return owningUser;
    }

    public void setOwningUser(User owningUser) {
        this.owningUser = owningUser;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "FULLNAME")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "ORG")
    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "PHOTO")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Column(name = "TEL_HOME")
    public String getHomeTelephone() {
        return homeTelephone;
    }

    public void setHomeTelephone(String homeTelephone) {
        this.homeTelephone = homeTelephone;
    }

    @Column(name = "TEL_OFFICE")
    public String getOfficeTelephone() {
        return officeTelephone;
    }

    public void setOfficeTelephone(String officeTelephone) {
        this.officeTelephone = officeTelephone;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REV")
    public Date getRev() {
        return rev;
    }

    public void setRev(Date rev) {
        this.rev = rev;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }


    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "VCARD_VERSION")
    public String getvCardVersion() {
        return vCardVersion;
    }

    public void setvCardVersion(String vCardVersion) {
        this.vCardVersion = vCardVersion;
    }
}
