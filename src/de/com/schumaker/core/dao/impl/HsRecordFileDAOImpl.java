package de.com.schumaker.core.dao.impl;

import de.com.schumaker.core.dao.HsRecordFileDAO;
import org.bson.Document;

/**
 *
 * @author hudson schumaker
 */
public class HsRecordFileDAOImpl implements HsRecordFileDAO{

    @Override
    public void Salvar(Document doc) {
        System.out.println(doc.getString("Name") +" - " + doc.getString("Date") + " - "+ doc.getString("Size"));
       // System.out.println(doc.getString("Content"));
       // System.out.println();
       // System.out.println();
    }
}
