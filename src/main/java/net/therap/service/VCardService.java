package net.therap.service;

import net.therap.command.ImportCmd;
import net.therap.command.SearchCmd;
import net.therap.command.VCardCmd;
import net.therap.domain.User;
import net.therap.domain.VCard;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VCardService {

    public void addNewVCard(User user, VCardCmd vCardCmd);

    public List<VCard> getAddressBook (User user);

    public VCard getVCardById(int vCardId);

    public void deleteVCard(VCard vCard, User user);

    public void updateVCard(VCard vCard);

    public String exportVCard(VCard vCard);

    public List<VCard> getVCardsByName(SearchCmd searchCmd, User user);

    public void importVCard(User user, ImportCmd importCmd) throws Exception;

}
