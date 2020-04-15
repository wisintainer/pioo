package com.quick.dao;

import com.quick.model.Usuario;
import com.quick.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author adrianow
 */
public interface UsuarioDao extends GenericDao<Usuario, Integer> {

    public boolean validaUsuario(Usuario usuario);
}
