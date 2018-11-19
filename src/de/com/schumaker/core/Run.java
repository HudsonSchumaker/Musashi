package de.com.schumaker.core;

import  de.com.schumaker.core.connection.HsConnectionFactory;
import java.io.IOException;


/**
 *
 * @author hudson schumaker
 */
public class Run {

    public static void main(String... args) throws IOException {
      //  Run.mongoDBSetUp();
        
        HsCrawler crawler = new HsCrawler();
        crawler.doScan();
        
        
        
        
      //  Run.mongoDBTeardown();        
    }
    
    private static void mongoDBSetUp(){
        System.out.println("connecting...");
        HsConnectionFactory.getInstance();
    }
    
    private static void mongoDBTeardown(){
        System.out.println("disconnecting...");
        HsConnectionFactory.getInstance().closeConnection();
    }
}
