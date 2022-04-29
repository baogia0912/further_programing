package com.assignment2.taxi_management_system.service;
import com.assignment2.taxi_management_system.model.Driver;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
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

    public long saveDriver(Driver driver){
        sessionFactory.getCurrentSession().save(driver);
        return driver.getId();
    }

    public long deleteDriver(Driver driver){
        sessionFactory.getCurrentSession().delete(driver);
        return driver.getId();
    }

    public long updateDriver(Driver driver){
        sessionFactory.getCurrentSession().update(driver);
        return driver.getId();
    }
}
