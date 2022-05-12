package com.assignment2.taxi_management_system.service;
import com.assignment2.taxi_management_system.model.Car;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
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

    public Long saveCar(Car car){
        sessionFactory.getCurrentSession().save(car);
        return car.getId();
    }

    public Long deleteCar(Car car){
        sessionFactory.getCurrentSession().delete(car);
        return car.getId();
    }

    public Long updateCar(Car car){
        if(car.getDriver() != null){
            if (car.getDriver().getCar() == null) {
                car.getDriver().setCar(car);
                sessionFactory.getCurrentSession().update(car);
                return 1L;
            }else{
                return 0L;
            }
        }
        sessionFactory.getCurrentSession().update(car);
        return 2L;
    }
}