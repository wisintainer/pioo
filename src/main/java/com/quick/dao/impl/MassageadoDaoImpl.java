package com.quick.dao.impl;

import com.quick.dao.MassageadoDao;
import com.quick.exception.NoDataException;
import com.quick.model.Massageado;
import com.quick.util.HibernateUtil;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author adrianowisintainer
 */
public class MassageadoDaoImpl extends GenericDaoImpl<Massageado, Integer> implements MassageadoDao {

    @Override
    public List<Massageado> sortearMassageados() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        SQLQuery query = session.createSQLQuery("select id,nome,telefone,email,area,tipo,ultimamassagem from Funcionario order by ultimamassagem asc limit 5");
        List<Object[]> rows = query.list();
        List<Massageado> massageados = new ArrayList<Massageado>();

        for (Object[] row : rows) {
            Massageado massageado = new Massageado();
            massageado.setId(Integer.parseInt(row[0].toString()));
            massageado.setNome(row[1].toString());
            massageado.setTelefone(row[2].toString());
            massageado.setEmail(row[3].toString());
            massageado.setArea(row[4].toString());
            massageado.setTipo(row[5].toString());
            massageado.setUltimamassagem(Date.valueOf(row[6].toString()));

            massageados.add(massageado);
        }
        return massageados;
    }

}
