package de.com.schumaker.core;

import  de.com.schumaker.core.connection.HsConnectionFactory;
import java.io.IOException;


/**
 *
 * @author hudson schumaker
 */
public class Run {

    public static void main(String... args) throws IOException {
        Run.mongoDBSetUp();
        HsCrawler crawler = new HsCrawler();
        crawler.doScan();

         // ConnectionFactory.getInstance().getDatabase().createCollection("HudsonLuZI");
        
    }
    
    private static void mongoDBSetUp(){
        HsConnectionFactory.getInstance();
    }
}
