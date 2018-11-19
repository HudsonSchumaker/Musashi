package de.com.schumaker.core;

import de.com.schumaker.core.util.MusashiExtensions;
import de.com.schumaker.core.files.impl.HsHtml;
import de.com.schumaker.core.files.HsReadable;
import de.com.schumaker.core.files.impl.HsCs;
import de.com.schumaker.core.files.impl.HsCss;
import de.com.schumaker.core.files.impl.HsDoc;
import de.com.schumaker.core.files.impl.HsDocx;
import de.com.schumaker.core.files.impl.HsHtm;
import de.com.schumaker.core.files.impl.HsJava;
import de.com.schumaker.core.files.impl.HsJs;
import de.com.schumaker.core.files.impl.HsJsp;
import de.com.schumaker.core.files.impl.HsPdf;
import de.com.schumaker.core.files.impl.HsPpt;
import de.com.schumaker.core.files.impl.HsPptx;
import de.com.schumaker.core.files.impl.HsRtf;
import de.com.schumaker.core.files.impl.HsTxt;
import de.com.schumaker.core.files.impl.HsXhtml;
import de.com.schumaker.core.files.impl.HsXls;
import de.com.schumaker.core.files.impl.HsXlsx;
import java.util.HashMap;

/**
 *
 * @author hudson schumaker
 */
public class HsSupportedFiles {

    private static final HsSupportedFiles INSTANCE = new HsSupportedFiles();
    private static final HashMap<String, HsReadable> SUPPORTED_FILES = new HashMap<>();

    static {
        SUPPORTED_FILES.put(MusashiExtensions.HTML,  new HsHtml());
        SUPPORTED_FILES.put(MusashiExtensions.XHTML, new HsXhtml());
        SUPPORTED_FILES.put(MusashiExtensions.HTM,   new HsHtm());
        SUPPORTED_FILES.put(MusashiExtensions.CSS,   new HsCss());
        SUPPORTED_FILES.put(MusashiExtensions.JS,    new HsJs());
        SUPPORTED_FILES.put(MusashiExtensions.JAVA,  new HsJava());
        SUPPORTED_FILES.put(MusashiExtensions.JSP,   new HsJsp());
        SUPPORTED_FILES.put(MusashiExtensions.CS,    new HsCs());
        SUPPORTED_FILES.put(MusashiExtensions.TXT,   new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.RTF,   new HsRtf());
        SUPPORTED_FILES.put(MusashiExtensions.PDF,   new HsPdf());
        SUPPORTED_FILES.put(MusashiExtensions.DOC,   new HsDoc());
        SUPPORTED_FILES.put(MusashiExtensions.DOCX,  new HsDocx());
        SUPPORTED_FILES.put(MusashiExtensions.XLS,   new HsXls());
        SUPPORTED_FILES.put(MusashiExtensions.XLSX,  new HsXlsx());
        SUPPORTED_FILES.put(MusashiExtensions.PPT,   new HsPpt());
        SUPPORTED_FILES.put(MusashiExtensions.PPTX,  new HsPptx());
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
