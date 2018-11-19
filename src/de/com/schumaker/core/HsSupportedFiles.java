package de.com.schumaker.core;

import de.com.schumaker.core.util.MusashiCommons;
import de.com.schumaker.core.files.impl.HsCss;
import de.com.schumaker.core.files.impl.HsCs;
import de.com.schumaker.core.files.impl.HsHtml;
import de.com.schumaker.core.files.impl.HsJava;
import de.com.schumaker.core.files.impl.HsJs;
import de.com.schumaker.core.files.impl.HsJsp;
import de.com.schumaker.core.files.impl.HsPdf;
import de.com.schumaker.core.files.impl.HsTxt;
import de.com.schumaker.core.files.HsReadable;
import de.com.schumaker.core.files.impl.HsDoc;
import de.com.schumaker.core.files.impl.HsDocx;
import de.com.schumaker.core.files.impl.HsRtf;
import java.util.HashMap;

/**
 *
 * @author hudson schumaker
 */
public class HsSupportedFiles {

    private static final HsSupportedFiles INSTANCE = new HsSupportedFiles();
    private static final HashMap<String, HsReadable> SUPPORTED_FILES = new HashMap<>();

    static {
        SUPPORTED_FILES.put(MusashiCommons.HTML, new HsHtml());
//        SUPPORTED_FILES.put(MusashiCommons.CSS,  new HsCss());
//        SUPPORTED_FILES.put(MusashiCommons.JS,   new HsJs());
//        SUPPORTED_FILES.put(MusashiCommons.JAVA, new HsJava());
//        SUPPORTED_FILES.put(MusashiCommons.JSP,  new HsJsp());
//        SUPPORTED_FILES.put(MusashiCommons.CS,   new HsCs());
//        SUPPORTED_FILES.put(MusashiCommons.TXT,  new HsTxt());
//        SUPPORTED_FILES.put(MusashiCommons.RTF,  new HsRtf());
//        SUPPORTED_FILES.put(MusashiCommons.PDF,  new HsPdf());
//        SUPPORTED_FILES.put(MusashiCommons.DOC,  new HsDoc());
//        SUPPORTED_FILES.put(MusashiCommons.DOCX, new HsDocx());
    }

    private HsSupportedFiles() { }

    public static HsSupportedFiles getInstance() {
        return INSTANCE;
    }

    public boolean isSupported(String ext) {
        HsReadable arq = SUPPORTED_FILES.get(ext);
        return arq != null;
    }

    public HsReadable getType(String ext) {
        return SUPPORTED_FILES.get(ext);
    }
}
