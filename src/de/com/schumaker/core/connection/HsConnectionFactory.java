package de.com.schumaker.core.connection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Hudson Schumaker
 */
public class HsConnectionFactory {
    
    private static final HsConnectionFactory INSTANCE = new HsConnectionFactory();
    private static final MongoClient CLIENTE = new MongoClient();
    private static final MongoDatabase DB = CLIENTE.getDatabase("musashiDB");
    private static final MongoCollection<Document> COLLECTION = DB.getCollection("musashi");
    
    private HsConnectionFactory(){
    }
    
    public static HsConnectionFactory getInstance(){
        return INSTANCE;
    }
    
    public MongoDatabase getDatabase(){
        return DB;
    }
    
    public MongoCollection<Document> getCollection(){
        return COLLECTION;
    }
    
    public void closeConnection(){
        CLIENTE.close();
    }
}
