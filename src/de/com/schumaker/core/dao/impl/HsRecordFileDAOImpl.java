package de.com.schumaker.core.dao.impl;

import com.mongodb.client.FindIterable;
import de.com.schumaker.core.connection.HsConnectionFactory;
import de.com.schumaker.core.dao.HsRecordFileDAO;
import org.bson.Document;
import com.mongodb.client.model.Filters;

/**
 *
 * @author hudson schumaker
 */
public class HsRecordFileDAOImpl implements HsRecordFileDAO{

    @Override
    public void Salvar(Document doc) {
        System.out.println(doc.getString("Name") +" - " + doc.getString("Date") + " - "+ doc.getString("Size"));
        System.out.println(doc.getString("Content"));
       // System.out.println();
       // System.out.println();
       
       // HsConnectionFactory.getInstance().getCollection().insertOne(doc);
    }
    
    public void Search(){
        FindIterable<Document> doc = HsConnectionFactory.getInstance().getCollection().find(Filters.eq("Name","Wii_Mario_Kart.pdf"));
        int x =0; 
    }
}
