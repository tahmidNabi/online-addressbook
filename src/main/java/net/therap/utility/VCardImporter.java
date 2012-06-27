package net.therap.utility;

import net.therap.domain.VCard;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 6/26/12
 * Time: 12:51 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VCardImporter {

    public VCard importVCard(String importedData);

}
