package net.therap.service;

import net.therap.command.ImportCmd;
import net.therap.command.SearchCmd;
import net.therap.dao.UserDao;
import net.therap.dao.VCardDao;
import net.therap.domain.User;
import net.therap.domain.VCard;
import net.therap.utility.VCardExporter;
import net.therap.utility.VCardImporter;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 12:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class VCardServiceImpl implements VCardService {

    protected final Logger logger = Logger.getLogger(this.getClass());

    private VCardDao vCardDao;
    private UserDao userDao;
    private VCardExporter vCardExporter;
    private VCardImporter vCardImporter;

    public void setvCardImporter(VCardImporter vCardImporter) {
        this.vCardImporter = vCardImporter;
    }

    public void setvCardExporter(VCardExporter vCardExporter) {
        this.vCardExporter = vCardExporter;
    }

    public void setvCardDao(VCardDao vCardDao) {
        this.vCardDao = vCardDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addNewVCard(User user, VCard vCard) {

        vCard.setOwningUser(user);
        vCard.setRev(new Date());
        vCard.setvCardVersion(4.0f);
        vCardDao.addNewVCard(vCard);
    }

    public List<VCard> getAddressBook(User user) {

        user = userDao.getUserById(user.getUserId());

        logger.info("VCardList size: " + user.getAddressBook().size());

        return user.getAddressBook();
    }

    public VCard getVCardById(int vCardId) {
        VCard vCard = vCardDao.getVCardById(vCardId);

        logger.info("Name: " + vCard.getName());

        return vCard;
    }

    public void deleteVCard(VCard vCard, User user) {
        if (vCard.getOwningUser().getUserId() == user.getUserId()) {
            vCardDao.deleteVCard(vCard);
        }
    }

    public void updateVCard(VCard vCard) {
        logger.info("Photo:" + vCard.getPhoto());
        vCard.setRev(new Date());
        vCardDao.updateVCard(vCard);
    }

    public String exportVCard(VCard vCard) {
        String ExportedVCard = vCardExporter.ExportVCard(vCard);
        return ExportedVCard;
    }

    public List<VCard> getVCardsByName(SearchCmd searchCmd, User user) {
        String searchedName = searchCmd.getName();

        return vCardDao.getVCardsByName(searchedName, user);
    }

    public void importVCard(User user, ImportCmd importCmd) throws Exception {

        MultipartFile importedVCardFile = importCmd.getFile();

        if (importedVCardFile == null) {
            logger.info("Imported file is null");
            return;
        }

        user = userDao.getUserById(user.getUserId());

        byte[] bytes = new byte[(int) importedVCardFile.getSize()];

        importedVCardFile.getInputStream().read(bytes);

        String importedVCardData = new String(bytes);

        VCard vCard = vCardImporter.importVCard(importedVCardData);

        vCard.setOwningUser(user);

        vCard.setRev(new Date());

        vCard.setvCardVersion(4.0f);

        vCardDao.addNewVCard(vCard);


    }
}
