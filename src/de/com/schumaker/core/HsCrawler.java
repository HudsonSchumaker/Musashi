
package de.com.schumaker.core;

import de.com.schumaker.core.util.HsUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author hudson schumaker
 */
public class HsCrawler {

    public void doScan() throws IOException{
        
         Path configFilePath = Paths.get("/Users/hudsonschumaker/Downloads/t");
       
      //  Path configFilePath = Paths.get("/Users/hudsonschumaker/Documents");
        
      
        Files.walk(configFilePath)
            .filter(p -> HsSupportedFiles.getInstance().isSupported(HsUtil.getFileExtension(p.toString())))
            .map(Path::normalize)
            .collect(toList())
            .parallelStream()
            .forEach(p -> HsSupportedFiles
                .getInstance()
                .getType(HsUtil.getFileExtension(p.toString()))
                .newOne(p.normalize().toString(), p.getFileName().toString(), HsUtil.getFileExtension(p.toString()))
                .process());
    }
}
