package com.assignment2.taxi_management_system.service;
import com.assignment2.taxi_management_system.model.Car;
import com.assignment2.taxi_management_system.model.Customer;
import com.assignment2.taxi_management_system.model.Driver;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@SuppressWarnings("unchecked")
public class CarService {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Car> getAllCars(Optional<Integer> page, Optional<Integer> limit){
        int pageSize = limit.orElse(10);
        int pageNum = (page.orElse(1) - 1) * pageSize;

        Query<Car> selectQuery = sessionFactory.getCurrentSession().createQuery("from Car");
        selectQuery.setFirstResult(pageNum);
        selectQuery.setMaxResults(pageSize);

        return selectQuery.list();
    }

    public List<Car> getAllCarsWithDriver(Optional<Integer> page, Optional<Integer> limit){
        int pageSize = limit.orElse(10);
        int pageNum = (page.orElse(1) - 1) * pageSize;

        Query<Car> selectQuery = sessionFactory.getCurrentSession().createQuery("from Car where driver != null ");
        selectQuery.setFirstResult(pageNum);
        selectQuery.setMaxResults(pageSize);

        return selectQuery.list();
    }

    public Long saveCar(Car car){
        sessionFactory.getCurrentSession().save(car);
        return car.getId();
    }

    public Long deleteCar(Car car){
//        Car oldCar = sessionFactory.getCurrentSession().find(Car.class, car.getId());
//        if(oldCar.getDriver() != null){
//            sessionFactory.getCurrentSession().find(Driver.class, oldCar.getDriver().getId()).setCar(null);
//        }
        sessionFactory.getCurrentSession().delete(car);
        return car.getId();
    }

    public Long updateCar(Car newCar){
        Car oldCar = sessionFactory.getCurrentSession().find(Car.class, newCar.getId());
        if(newCar.getVIN() != null){oldCar.setVIN(newCar.getVIN());}
        if(newCar.getMake() != null){oldCar.setMake(newCar.getMake());}
        if(newCar.getModel() != null){oldCar.setModel(newCar.getModel());}
        if(newCar.getColor() != null){oldCar.setColor(newCar.getColor());}
        if(newCar.getRating() != 0){oldCar.setRating(newCar.getRating());}
        if(newCar.getRate() != 0){oldCar.setRate(newCar.getRate());}
        if(newCar.getLicense_plate() != null){oldCar.setLicense_plate(newCar.getLicense_plate());}
        return newCar.getId();
    }

    public Long setDriver(Car car){
        Driver driver = sessionFactory.getCurrentSession().find(Driver.class, car.getDriver().getId());
        Car oldCar = sessionFactory.getCurrentSession().find(Car.class, car.getId());
        if(driver.getCar() != null || oldCar.getDriver() != null){
            return 0L;
        }else{
            oldCar.setDriver(driver);
            driver.setCar(oldCar);
            return car.getId();
        }
    }

    public Car findByID(long id){
        return sessionFactory.getCurrentSession().find(Car.class, id);
    }

    public Car findByVIN(String VIN){
        return (Car) sessionFactory.getCurrentSession().createQuery("from Car where VIN = :VIN")
                .setParameter("VIN", VIN).uniqueResult();
    }

    public List<Car> findByMake(String make, Optional<Integer> page, Optional<Integer> limit){
        int pageSize = limit.orElse(10);
        int pageNum = (page.orElse(1) - 1) * pageSize;

        Query<Car> selectQuery = sessionFactory.getCurrentSession().createQuery("from Car where make = :make")
                .setParameter("make", make);
        selectQuery.setFirstResult(pageNum);
        selectQuery.setMaxResults(pageSize);

        return selectQuery.list();
    }

    public List<Car> findByModel(String model, Optional<Integer> page, Optional<Integer> limit){
        int pageSize = limit.orElse(10);
        int pageNum = (page.orElse(1) - 1) * pageSize;

        Query<Car> selectQuery = sessionFactory.getCurrentSession().createQuery("from Car where model = :model")
                .setParameter("model", model);
        selectQuery.setFirstResult(pageNum);
        selectQuery.setMaxResults(pageSize);

        return selectQuery.list();
    }

    public List<Car> findByColor(String color, Optional<Integer> page, Optional<Integer> limit){
        int pageSize = limit.orElse(10);
        int pageNum = (page.orElse(1) - 1) * pageSize;

        Query<Car> selectQuery = sessionFactory.getCurrentSession().createQuery("from Car where color = :color")
                .setParameter("color", color);
        selectQuery.setFirstResult(pageNum);
        selectQuery.setMaxResults(pageSize);

        return selectQuery.list();
    }

    public List<Car> findByConvertible(boolean convertible, Optional<Integer> page, Optional<Integer> limit){
        int pageSize = limit.orElse(10);
        int pageNum = (page.orElse(1) - 1) * pageSize;

        Query<Car> selectQuery = sessionFactory.getCurrentSession().createQuery("from Car where convertible = :convertible")
                .setParameter("convertible", convertible);
        selectQuery.setFirstResult(pageNum);
        selectQuery.setMaxResults(pageSize);

        return selectQuery.list();
    }

    public List<Car> findByRate(double rate, Optional<Integer> page, Optional<Integer> limit){
        int pageSize = limit.orElse(10);
        int pageNum = (page.orElse(1) - 1) * pageSize;

        Query<Car> selectQuery = sessionFactory.getCurrentSession().createQuery("from Car where rate = :rate")
                .setParameter("rate", rate);
        selectQuery.setFirstResult(pageNum);
        selectQuery.setMaxResults(pageSize);

        return selectQuery.list();
    }

    public List<Car> findByRating(double rating, Optional<Integer> page, Optional<Integer> limit){
        int pageSize = limit.orElse(10);
        int pageNum = (page.orElse(1) - 1) * pageSize;

        Query<Car> selectQuery = sessionFactory.getCurrentSession().createQuery("from Car where rating = :rating")
                .setParameter("rating", rating);
        selectQuery.setFirstResult(pageNum);
        selectQuery.setMaxResults(pageSize);

        return selectQuery.list();
    }

    public Car findByLicensePlate(String license_plate){
        return (Car) sessionFactory.getCurrentSession().createQuery("from Car where license_plate = :license_plate")
                .setParameter("license_plate", license_plate).list();
    }
}