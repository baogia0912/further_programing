package com.assignment2.taxi_management_system.service;

import com.assignment2.taxi_management_system.model.Booking;
import com.assignment2.taxi_management_system.model.Car;
import com.assignment2.taxi_management_system.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@SuppressWarnings("unchecked")
public class CustomerService {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Customer> getAllCustomers(Optional<Integer> page, Optional<Integer> limit){
        int pageSize = limit.orElse(10);
        int pageNum = (page.orElse(1) - 1) * pageSize;

        Query<Customer> selectQuery = sessionFactory.getCurrentSession().createQuery("from Customer");
        selectQuery.setFirstResult(pageNum);
        selectQuery.setMaxResults(pageSize);

        return selectQuery.list();
    }

    public Booking getBookingDetails(Customer customer){
        return sessionFactory.getCurrentSession().find(Customer.class, customer.getId()).getBooking();
    }

    public Customer saveCustomer(Customer customer){
        sessionFactory.getCurrentSession().save(customer);
        return customer;
    }

    public long deleteCustomer(Customer customer){
        sessionFactory.getCurrentSession().delete(customer);
        return customer.getId();
    }

    public long updateCustomer(Customer newCustomer){
        Customer oldCustomer = sessionFactory.getCurrentSession().find(Customer.class, newCustomer.getId());
        if(newCustomer.getName() != null){oldCustomer.setName(newCustomer.getName());}
        if(newCustomer.getAddress() != null){oldCustomer.setAddress(newCustomer.getAddress());}
        if(newCustomer.getPhone_number() != null){oldCustomer.setPhone_number(newCustomer.getPhone_number());}
        if(newCustomer.getBooking() != null){oldCustomer.setBooking(newCustomer.getBooking());}
        return newCustomer.getId();
    }

    public Customer findByID(long id){
        return sessionFactory.getCurrentSession().find(Customer.class, id);
    }

    public List<Customer> findByName(String name, Optional<Integer> page, Optional<Integer> limit){
        int pageSize = limit.orElse(10);
        int pageNum = (page.orElse(1) - 1) * pageSize;

        Query<Customer> selectQuery = sessionFactory.getCurrentSession().createQuery(
                "from Customer where name = :name")
                .setParameter("name", name);
        selectQuery.setFirstResult(pageNum);
        selectQuery.setMaxResults(pageSize);

        return selectQuery.list();
    }

    public List<Customer> findByAddress(String address, Optional<Integer> page, Optional<Integer> limit){
        int pageSize = limit.orElse(10);
        int pageNum = (page.orElse(1) - 1) * pageSize;

        Query<Customer> selectQuery = sessionFactory.getCurrentSession().createQuery(
                        "from Customer where address = :address")
                .setParameter("address", address);
        selectQuery.setFirstResult(pageNum);
        selectQuery.setMaxResults(pageSize);

        return selectQuery.list();
    }

    public List<Customer> findByPhoneNumber(String phone_number, Optional<Integer> page, Optional<Integer> limit) {
        int pageSize = limit.orElse(10);
        int pageNum = (page.orElse(1) - 1) * pageSize;

        Query<Customer> selectQuery = sessionFactory.getCurrentSession().createQuery(
                        "from Customer where phone_number = :phone_number")
                .setParameter("phone_number", phone_number);
        selectQuery.setFirstResult(pageNum);
        selectQuery.setMaxResults(pageSize);

        return selectQuery.list();
    }
}
