package com.assignment2.taxi_management_system.service;
import com.assignment2.taxi_management_system.model.Car;
import com.assignment2.taxi_management_system.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Transactional
@Service
public class CarService {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Car> getAllCars(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Car.class);
        return criteria.list();
    }

    public long saveCar(Car car){
        sessionFactory.getCurrentSession().save(car);
        return car.getVIN();
    }

    public long deleteCar(Car car){
        sessionFactory.getCurrentSession().delete(car);
        return car.getVIN();
    }

    public long updateCar(Car car){
        sessionFactory.getCurrentSession().update(car);
        return car.getVIN();
    }
}