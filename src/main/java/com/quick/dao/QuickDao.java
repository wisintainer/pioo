package com.quick.dao;

import com.quick.model.Massageado;
import java.util.List;

/**
 *
 * @author adrianowisintainer
 */
public interface QuickDao extends GenericDao<Massageado, Integer> {
    public List<Massageado> sortearMassageados();
}
