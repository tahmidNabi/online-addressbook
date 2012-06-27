package net.therap.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "T_ADDRESS_BOOK_VCARD")
public class VCard {

    private int vCardId;
    private User owningUser;
    private String Name;
    private String fullName;
    private String organization;
    private String title;
    private String photo;
    private String homeTelephone;
    private String officeTelephone;
    private String address;
    private String email;
    private Date rev;
    private float vCardVersion;
    private int Version;

    @Id
    @SequenceGenerator(name = "T_ADDRESS_VCARD", sequenceName = "T_ADDRESS_VCARD")
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "T_ADDRESS_VCARD")

    @Column(name = "V_CARD_ID")
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

    @Column(name = "V_NAME")
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Column(name = "V_FULLNAME")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "V_ORG")
    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Column(name = "V_TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "V_PHOTO")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Column(name = "V_TEL_HOME")
    public String getHomeTelephone() {
        return homeTelephone;
    }

    public void setHomeTelephone(String homeTelephone) {
        this.homeTelephone = homeTelephone;
    }

    @Column(name = "V_TEL_OFFICE")
    public String getOfficeTelephone() {
        return officeTelephone;
    }

    public void setOfficeTelephone(String officeTelephone) {
        this.officeTelephone = officeTelephone;
    }

    @Column(name = "V_ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "V_EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "V_REV")
    public Date getRev() {
        return rev;
    }

    public void setRev(Date rev) {
        this.rev = rev;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return Version;
    }


    public void setVersion(int version) {
        Version = version;
    }

    @Column(name = "VCARD_VERSION")
    public float getvCardVersion() {
        return vCardVersion;
    }

    public void setvCardVersion(float vCardVersion) {
        this.vCardVersion = vCardVersion;
    }
}
