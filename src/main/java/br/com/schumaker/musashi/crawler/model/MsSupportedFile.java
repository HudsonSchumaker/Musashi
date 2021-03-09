package br.com.schumaker.musashi.crawler.model;

import br.com.schumaker.musashi.crawler.model.files.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 *
 * @author Hudson Schumaker
 */
@Component
public class MsSupportedFile {

    private static final MsSupportedFile INSTANCE = new MsSupportedFile();
    private static final HashMap<String, MsReadable> SUPPORTED_FILES = new HashMap<>();

    static {

        SUPPORTED_FILES.put(MusashiExtensions.JS,  new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.TXT, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.CSV, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.XML, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.SH,  new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.CSS, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.JSON, new MsTxt());

        SUPPORTED_FILES.put(MusashiExtensions.BAT, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.SQL, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.JSP, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.ASP, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.ASPX, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.C,   new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.CS,  new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.CPP, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.INO, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.PHP, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.JAVA, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.PEARL, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.PYTHON, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.RUBY, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.COLDFUSION, new MsTxt());
        SUPPORTED_FILES.put(MusashiExtensions.RTF, new MsRtf());

        SUPPORTED_FILES.put(MusashiExtensions.DOC, new MsDoc());
        SUPPORTED_FILES.put(MusashiExtensions.DOCX, new MsDocx());
        SUPPORTED_FILES.put(MusashiExtensions.XLS, new MsXls());
        SUPPORTED_FILES.put(MusashiExtensions.XLSX, new MsXlsx());
        SUPPORTED_FILES.put(MusashiExtensions.PPT, new MsPpt());
        SUPPORTED_FILES.put(MusashiExtensions.PPTX, new MsPptx());
        SUPPORTED_FILES.put(MusashiExtensions.PDF, new MsPdf());

        SUPPORTED_FILES.put(MusashiExtensions.HTM,   new MsHtml());
        SUPPORTED_FILES.put(MusashiExtensions.HTML,  new MsHtml());
        SUPPORTED_FILES.put(MusashiExtensions.DHTML, new MsHtml());
        SUPPORTED_FILES.put(MusashiExtensions.JHTML, new MsHtml());
        SUPPORTED_FILES.put(MusashiExtensions.SHTML, new MsHtml());
        SUPPORTED_FILES.put(MusashiExtensions.XHTML, new MsHtml());
    }

    private MsSupportedFile() {}

    public static MsSupportedFile getInstance() {
        return INSTANCE;
    }

    public boolean isSupported(String ext) {
        MsReadable arq = SUPPORTED_FILES.get(ext);
        return arq != null;
    }

    public MsReadable getType(String ext) {
        return SUPPORTED_FILES.get(ext);
    }
}
