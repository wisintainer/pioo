/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quick.dao.impl;

import com.quick.dao.UsuarioDao;
import com.quick.model.Usuario;
import com.quick.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author adrianowisintainer
 */
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao {

    @Override
    public boolean validaUsuario(Usuario usuario) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Criteria cri = session.createCriteria(Usuario.class);

        cri.add(Restrictions.eq("login", usuario.getLogin()));
        cri.add(Restrictions.eq("passwd", usuario.getPasswd()));

        if (cri.uniqueResult() != null) {
            return true;
        }
        return false;
    }
}
