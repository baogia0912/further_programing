package com.assignment2.taxi_management_system.service;

import com.assignment2.taxi_management_system.model.Car;
import com.assignment2.taxi_management_system.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@SuppressWarnings("unchecked")
public class CustomerService {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Customer> getAllCustomers(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        return criteria.list();
    }

    public long saveCustomer(Customer customer){
        sessionFactory.getCurrentSession().save(customer);
        return customer.getId();
    }

    public long deleteCustomer(Customer customer){
        sessionFactory.getCurrentSession().delete(customer);
        return customer.getId();
    }

    public long updateCustomer(Customer customer){
        sessionFactory.getCurrentSession().update(customer);
        return customer.getId();
    }

    public Customer findByID(long id){
        return sessionFactory.getCurrentSession().find(Customer.class, id);
    }

    public List<Customer> findByName(String name){
        return (List<Customer>) sessionFactory.getCurrentSession().createQuery("from Customer where name = :name")
                .setParameter("name", name).list();
    }

    public List<Customer> findByAddress(String address){
        return (List<Customer>) sessionFactory.getCurrentSession().createQuery("from Customer where address = :address")
                .setParameter("address", address).list();
    }

    public List<Customer> findByPhoneNumber(String phone_number){
        return (List<Customer>) sessionFactory.getCurrentSession().createQuery("from Customer where phone_number = :phone_number")
                .setParameter("phone_number", phone_number).list();
    }
}
