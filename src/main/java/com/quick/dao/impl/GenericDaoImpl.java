package com.quick.dao.impl;

import com.quick.dao.GenericDao;
import com.quick.exception.CommitException;
import com.quick.exception.NoDataException;
import com.quick.model.Usuario;
import com.quick.model.Massageado;
import com.quick.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author adrianowisintainer
 */
public class GenericDaoImpl<T, K> implements GenericDao<T, K> {

    SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public void cadastrar(T entidade) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(entidade);
        tx.commit();
        session.close();

    }

    @Override
    public T pesquisar(K codigo) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Criteria cri = session.createCriteria(codigo.getClass());
        session.close();
        return (T) cri.uniqueResult();

    }

    @Override
    public List<T> pesquisarTodos(T entidade) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Criteria cri = session.createCriteria(entidade.getClass());

        return (List<T>) cri.list();

    }

    @Override
    public void remover(T entidade) throws NoDataException {
        if (entidade == null) {
            throw new NoDataException();
        } else {
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(entidade);
            tx.commit();
            session.close();
        }
    }

    @Override
    public void atualizar(T entidade) throws NoDataException {
        if (entidade == null) {
            throw new NoDataException();
        } else {
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();
            try {
                session.update(entidade);
            } catch (Exception e) {
                e.printStackTrace();
            }
            tx.commit();
            session.close();
        }
    }
}
