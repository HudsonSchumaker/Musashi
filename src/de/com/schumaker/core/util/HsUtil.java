package de.com.schumaker.core.util;

/**
 *
 * @author hudsonschumaker
 */
public class HsUtil {
    
    public static String getFileExtension(String fileName) {
        String [] ext = fileName.split("\\.");
        int size = ext.length;
        String result = "";
        if (size > 1) {
            result = ext[size - 1];
        }
        return result.toLowerCase();
    }
    
   public static String getClearName(String fileName) {
        String [] name = fileName.split("\\.");
        return name[0];
    }
}
