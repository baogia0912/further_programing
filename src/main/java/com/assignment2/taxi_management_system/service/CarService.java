package com.assignment2.taxi_management_system.service;
import com.assignment2.taxi_management_system.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@SuppressWarnings("unchecked")
public class CarService {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Car> getAllCars(){
        return (List<Car>) sessionFactory.getCurrentSession().createQuery("from Car").list();
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

    public Car findByID(long id){
        return sessionFactory.getCurrentSession().find(Car.class, id);
    }

    public Car findByVIN(String VIN){
        return (Car) sessionFactory.getCurrentSession().createQuery("from Car where VIN = :VIN")
                .setParameter("VIN", VIN).uniqueResult();
    }

    public List<Car> findByMake(String make){
        return (List<Car>) sessionFactory.getCurrentSession().createQuery("from Car where make = :make")
                .setParameter("make", make).list();
    }

    public List<Car> findByModel(String model){
        return sessionFactory.getCurrentSession().createQuery("from Car where model = :model")
                .setParameter("model", model).list();
    }

    public List<Car> findByColor(String color){
        return (List<Car>) sessionFactory.getCurrentSession().createQuery("from Car where color = :color")
                .setParameter("color", color).list();
    }

    public List<Car> findByConvertible(boolean convertible){
        return (List<Car>) sessionFactory.getCurrentSession().createQuery("from Car where convertible = :convertible")
                .setParameter("convertible", convertible).list();
    }

    public List<Car> findByRate(double rate){
        return (List<Car>) sessionFactory.getCurrentSession().createQuery("from Car where rate = :rate")
                .setParameter("rate", rate).list();
    }

    public List<Car> findByRating(double rating){
        return (List<Car>) sessionFactory.getCurrentSession().createQuery("from Car where rating = :rating")
                .setParameter("rating", rating).list();
    }

    public List<Car> findByLicensePlate(String license_plate){
        return (List<Car>) sessionFactory.getCurrentSession().createQuery("from Car where license_plate = :license_plate")
                .setParameter("license_plate", license_plate).list();
    }
}