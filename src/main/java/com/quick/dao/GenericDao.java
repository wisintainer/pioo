package com.quick.dao;

import com.quick.exception.CommitException;
import com.quick.exception.NoDataException;
import com.quick.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author adrianowisintainer
 */
public interface GenericDao<T, K> {

    public void cadastrar(T entidade);

    public void atualizar(T entidade) throws NoDataException;

    public T pesquisar(K codigo);

    public List<T> pesquisarTodos(T entidade);

    public void remover(T entidade) throws NoDataException;

}
