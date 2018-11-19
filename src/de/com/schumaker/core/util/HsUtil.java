package de.com.schumaker.core.util;

/**
 *
 * @author hudson schumaker
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
    
    public static final String formatSize(long bytes) {
        String s = String.valueOf(bytes);
        int digits = 0;
        while (s.length() > 3) {
            s = s.substring(0, s.length() - 3);
            digits++;
        }
        StringBuilder buffer = new StringBuilder();
        buffer.append(s);
        if ((s.length() == 1) && (String.valueOf(bytes).length() >= 3)) {
            buffer.append(".");
            buffer.append(String.valueOf(bytes).substring(1, 3));
        } else if ((s.length() == 2) && (String.valueOf(bytes).length() >= 3)) {
            buffer.append(".");
            buffer.append(String.valueOf(bytes).substring(2, 3));
        }
        if (digits == 0) {
            buffer.append(" B");
        } else if (digits == 1) {
            buffer.append(" KB");
        } else if (digits == 2) {
            buffer.append(" MB");
        } else if (digits == 3) {
            buffer.append(" GB");
        } else if (digits == 4) {
            buffer.append(" TB");
        }
        return buffer.toString();
    }
    
    public static String formatFileLastModified(long date) {
        return String.format("%tF", date);
    }
}
