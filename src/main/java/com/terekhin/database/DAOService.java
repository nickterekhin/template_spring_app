package com.terekhin.database;

import com.terekhin.domain.IBaseModel;
import com.terekhin.exceptions.DBException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Nick on 12.11.17.
 */

public abstract class DAOService<T extends IBaseModel> implements IDAOService<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> persistentClass;

    public DAOService() {
        this.persistentClass = (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void create(T obj) throws DBException {
        getSession().persist(obj);
    }

    @Override
    public T getById(Long id) throws DBException {
        return getSession().get(persistentClass,id);
    }

    @Override
    public void delete(T obj) throws DBException {
        getSession().delete(obj);
    }

    @Override
    public void delete(Long id) throws DBException {
        getSession().delete(this.getById(id));
    }

    @Override
    public void update(T obj) throws DBException {
        getSession().update(obj);
    }

    @Override
    public List<T> getAll() throws DBException {
        CriteriaQuery<T> criteria = this.getCriteria();
            return getSession().createQuery(criteria).list();
    }

    @Override
    public T activate(Long id, boolean status) throws DBException {
        T obj =  getSession().byId(persistentClass).load(id);
        obj.setActive(status);
        getSession().update(obj);
        return obj;
    }

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    private CriteriaQuery<T> getCriteria()
    {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        return  builder.createQuery(persistentClass);

    }

}
