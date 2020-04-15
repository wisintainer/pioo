/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.quick.dao.impl;

import com.quick.dao.MassageadoDao;
import com.quick.dao.QuickDao;
import com.quick.model.Massageado;
import com.quick.model.Usuario;
import com.quick.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author adrianowisintainer
 */
public class QuickDaoImpl extends GenericDaoImpl<Massageado, Integer> implements QuickDao {

    @Override
    public List<Massageado> sortearMassageados() {
        MassageadoDao md = new MassageadoDaoImpl();
        return md.sortearMassageados();
    }

}
