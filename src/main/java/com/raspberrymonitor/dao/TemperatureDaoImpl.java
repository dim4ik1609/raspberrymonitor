package com.raspberrymonitor.dao;

import com.raspberrymonitor.enity.Temperature;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class TemperatureDaoImpl implements TemperatureDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Temperature temp) {
        sessionFactory.getCurrentSession().save(temp);
    }

    public void update(Temperature temp) {
        sessionFactory.getCurrentSession().update(temp);
    }

    public List<Temperature> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Temperature").list();
    }

    public Temperature findById(long id) {
        return null;
    }

    public Temperature findLast() {
        return (Temperature)sessionFactory.getCurrentSession().createQuery("from Temperature order by id DESC ").setMaxResults(1).uniqueResult();
    }

    public List<Temperature> findByDate(Date date) {
        return sessionFactory.getCurrentSession().createQuery("from Temperature t where date(t.date) = :date").setParameter("date", date).list();
    }
}
