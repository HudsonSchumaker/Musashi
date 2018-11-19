
package de.com.schumaker.core.dao.impl;

import de.com.schumaker.core.entity.HsRecordFile;
import de.com.schumaker.core.dao.HsRecordFileDAO;

/**
 *
 * @author hudson schumaker
 */
public class HsRecordFileDAOImpl implements HsRecordFileDAO{

    @Override
    public void Salvar(HsRecordFile rf) {
        System.out.println(rf.getContent());
       // System.out.println(rf.getExt());
    }
}
