package net.therap.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "T_ADDRESS_BOOK_USER")
public class User {

    private int userId;
    private String userName;
    private String password;
    private int version;
    private List<VCard> addressBook;

    @Id
    @SequenceGenerator(name = "T_ADDRESS_USER_SEQ", sequenceName = "T_ADDRESS_USER_SEQ")
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "T_ADDRESS_USER_SEQ")

    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @OneToMany(mappedBy = "owningUser")
    public List<VCard> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(List<VCard> addressBook) {
        this.addressBook = addressBook;
    }
}
