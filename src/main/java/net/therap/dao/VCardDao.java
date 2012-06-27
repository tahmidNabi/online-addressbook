package net.therap.dao;

import net.therap.domain.User;
import net.therap.domain.VCard;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VCardDao {

    public void addNewVCard(VCard vCard);

    public VCard getVCardById(int vCardId);

    public void deleteVCard(VCard vCard);

    public void updateVCard(VCard vcard);

    public List<VCard> getVCardsByName(String name, User user);
}
