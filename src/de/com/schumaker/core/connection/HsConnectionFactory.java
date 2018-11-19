package de.com.schumaker.core.connection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author hudson schumaker
 */
public class HsConnectionFactory {
    
    private static final HsConnectionFactory INSTANCE = new HsConnectionFactory();
    private static final MongoClient CLIENTE = new MongoClient();
    private static final MongoDatabase DB = CLIENTE.getDatabase("musashiDB");
    
    private HsConnectionFactory(){
    }
    
    public static HsConnectionFactory getInstance(){
        return INSTANCE;
    }
    
    public MongoDatabase getDatabase(){
        return DB;
    }
    
    public void closeConnection(){
        CLIENTE.close();
    }
}
