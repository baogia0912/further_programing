package com.assignment2.taxi_management_system.service;
import com.assignment2.taxi_management_system.model.*;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;

@Transactional
@Service
@SuppressWarnings("unchecked")
public class InvoiceService {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Invoice> getAllInvoices(){
        return (List<Invoice>) sessionFactory.getCurrentSession().createQuery("from Invoice order by dateCreated").list();
    }

    public Long saveInvoice(Invoice invoice){
        sessionFactory.getCurrentSession().save(invoice);
        return invoice.getId();
    }

    public Long deleteInvoice(Invoice invoice){
        sessionFactory.getCurrentSession().delete(invoice);
        return invoice.getId();
    }

    public Long updateInvoice(Invoice invoice){
        sessionFactory.getCurrentSession().update(invoice);
        return invoice.getId();
    }

    public static double calculateRevenue(List<Invoice> invoices){
        double revenue = 0;
        for (Invoice invoice : invoices) {
            revenue += invoice.getTotalCharge();
        }
        return revenue;
    }

    public List<Invoice> findByCustomerInDate(long customer_id, ZonedDateTime start_date, ZonedDateTime end_date){
        return (List<Invoice>) sessionFactory.getCurrentSession()
                .createQuery("from Invoice where Customer.id =: customer_id and dateCreated >= :start and dateCreated <= :end")
                .setParameter("customer_id", customer_id)
                .setParameter("start", start_date)
                .setParameter("end", end_date).list();
    }

    public List<Invoice> findByDriverInDate(long driver_id, ZonedDateTime start_date, ZonedDateTime end_date){
        return (List<Invoice>) sessionFactory.getCurrentSession()
                .createQuery("from Invoice where Driver.id = :driver_id and dateCreated >= :start and dateCreated <= :end")
                .setParameter("driver_id", driver_id)
                .setParameter("start", start_date)
                .setParameter("end", end_date).list();
    }

    public double findRevenueInDate(ZonedDateTime start_date, ZonedDateTime end_date) {
        return calculateRevenue((List<Invoice>) sessionFactory.getCurrentSession()
                .createQuery("from Invoice where dateCreated >= :start and dateCreated <= :end")
                .setParameter("start", start_date)
                .setParameter("end", end_date));
    }

    public double findRevenueByCustomerInDate(long customer_id, ZonedDateTime start_date, ZonedDateTime end_date) {
        return calculateRevenue((List<Invoice>) sessionFactory.getCurrentSession()
                .createQuery("from Invoice where Customer .id = :customer_id and dateCreated >= :start and dateCreated <= :end")
                .setParameter("customer_id", customer_id)
                .setParameter("start", start_date)
                .setParameter("end", end_date));
    }

    public double findRevenueByDriverInDate(long driver_id, ZonedDateTime start_date, ZonedDateTime end_date) {
        return calculateRevenue((List<Invoice>) sessionFactory.getCurrentSession()
                .createQuery("from Invoice where Driver.id = :driver_id and dateCreated >= :start and dateCreated <= :end")
                .setParameter("driver_id", driver_id)
                .setParameter("start", start_date)
                .setParameter("end", end_date));
    }
}
