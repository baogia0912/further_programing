package com.assignment2.taxi_management_system.service;
import com.assignment2.taxi_management_system.model.Invoice;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class InvoiceService {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Invoice> getAllInvoices(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Invoice.class);
        return criteria.list();
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
}
