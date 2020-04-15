/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.quick.dao;

import com.quick.model.Massageado;
import java.util.List;

/**
 *
 * @author adrianowisintainer
 */
public interface MassageadoDao extends GenericDao<Massageado, Integer> {

    public List<Massageado> sortearMassageados();
}
