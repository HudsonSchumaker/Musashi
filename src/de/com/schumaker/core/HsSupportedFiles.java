package de.com.schumaker.core;

import de.com.schumaker.core.util.MusashiExtensions;
import de.com.schumaker.core.files.HsReadable;
import de.com.schumaker.core.files.impl.HsDoc;
import de.com.schumaker.core.files.impl.HsDocx;
import de.com.schumaker.core.files.impl.HsPdf;
import de.com.schumaker.core.files.impl.HsPpt;
import de.com.schumaker.core.files.impl.HsPptx;
import de.com.schumaker.core.files.impl.HsRtf;
import de.com.schumaker.core.files.impl.HsTxt;
import de.com.schumaker.core.files.impl.HsHtml;
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
        SUPPORTED_FILES.put(MusashiExtensions.HTM,   new HsHtml());
        SUPPORTED_FILES.put(MusashiExtensions.HTML,  new HsHtml());
        SUPPORTED_FILES.put(MusashiExtensions.DHTML, new HsHtml());
        SUPPORTED_FILES.put(MusashiExtensions.JHTML, new HsHtml());
        SUPPORTED_FILES.put(MusashiExtensions.SHTML, new HsHtml());
        SUPPORTED_FILES.put(MusashiExtensions.XHTML, new HsHtml());
        
        SUPPORTED_FILES.put(MusashiExtensions.TXT, new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.CSV, new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.JSON, new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.XML, new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.JS,  new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.SH,  new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.CSS, new HsTxt());

        SUPPORTED_FILES.put(MusashiExtensions.BAT, new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.JSP, new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.ASP, new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.ASPX, new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.C,   new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.CS,  new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.CPP, new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.PHP, new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.JAVA, new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.PEARL, new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.PYTHON, new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.RUBY, new HsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.COLDFUSION, new HsTxt());

        SUPPORTED_FILES.put(MusashiExtensions.RTF,  new HsRtf());
        SUPPORTED_FILES.put(MusashiExtensions.PDF,  new HsPdf());
        SUPPORTED_FILES.put(MusashiExtensions.DOC,  new HsDoc());
        SUPPORTED_FILES.put(MusashiExtensions.DOCX, new HsDocx());
        SUPPORTED_FILES.put(MusashiExtensions.XLS,  new HsXls());
        SUPPORTED_FILES.put(MusashiExtensions.XLSX, new HsXlsx());
        SUPPORTED_FILES.put(MusashiExtensions.PPT,  new HsPpt());
        SUPPORTED_FILES.put(MusashiExtensions.PPTX, new HsPptx());
    }

    private HsSupportedFiles() {
    }

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
