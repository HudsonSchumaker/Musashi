package de.com.schumaker.core.service;

import de.com.schumaker.core.dao.impl.HsRecordFileDAOImpl;
import de.com.schumaker.core.entity.HsRecordFileBuilder;
import de.com.schumaker.core.files.HsFile;

/**
 *
 * @author hudsonschumaker
 */
public class HsReadableService {
    
    public void persistRecord(HsFile tipo){
        new HsRecordFileDAOImpl().Salvar(new HsRecordFileBuilder()
                .withName(tipo.getName())
                .withExt(tipo.getExt())
                .withPath(tipo.getPath().normalize().toString())
                .withContent(tipo.getContent())
                .build());
    }
}
