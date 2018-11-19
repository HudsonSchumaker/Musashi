package de.com.schumaker.core.service;

import de.com.schumaker.core.dao.impl.HsRecordFileDAOImpl;
import de.com.schumaker.core.builder.HsRecordFileBuilder;
import de.com.schumaker.core.files.HsFile;

/**
 *
 * @author hudson schumaker
 */
public class HsReadableService {
    
    public void persistRecord(HsFile tipo){
        
        new HsRecordFileDAOImpl().Salvar(new HsRecordFileBuilder()
                .withName(tipo.getName())
                .withExt(tipo.getExt())
                .withPath(tipo.getPath())
                .withContent(tipo.getContent().trim())
                .build());
    }
}
