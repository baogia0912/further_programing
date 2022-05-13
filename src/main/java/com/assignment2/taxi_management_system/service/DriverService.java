package com.assignment2.taxi_management_system.service;
import com.assignment2.taxi_management_system.model.Car;
import com.assignment2.taxi_management_system.model.Driver;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@SuppressWarnings("unchecked")
public class DriverService {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Driver> getAllDrivers(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Driver.class);
        return criteria.list();
    }

    public Long saveDriver(Driver driver){
        sessionFactory.getCurrentSession().save(driver);
        return driver.getId();
    }

    public Long deleteDriver(Driver driver){
        sessionFactory.getCurrentSession().delete(driver);
        return driver.getId();
    }

    public Long updateDriver(Driver driver){
        sessionFactory.getCurrentSession().update(driver);
        return driver.getId();
    }

    public Driver findByID(long id){
        return sessionFactory.getCurrentSession().find(Driver.class, id);
    }

    public List<Driver> findByName(String name){
        return (List<Driver>) sessionFactory.getCurrentSession().createQuery("from Driver where name = :name")
                .setParameter("name", name).list();
    }

    public Driver findByLicenseNumber(String license_number){
        return (Driver) sessionFactory.getCurrentSession().createQuery("from Driver where license_number = :license_number")
                .setParameter("license_number", license_number).list();
    }

    public List<Driver> findByPhoneNumber(String phone_number){
        return (List<Driver>) sessionFactory.getCurrentSession().createQuery("from Driver where phone_number = :phone_number")
                .setParameter("phone_number", phone_number).list();
    }

    public List<Driver> findByRating(double rating){
        return (List<Driver>) sessionFactory.getCurrentSession().createQuery("from Driver where rating = :rating")
                .setParameter("rating", rating).list();
    }
}
