package com.assignment2.taxi_management_system.service;
import com.assignment2.taxi_management_system.model.Booking;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BookingService {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Booking> getAllBookings(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Booking.class);
        return criteria.list();
    }

    public Long saveBooking(Booking booking){
        sessionFactory.getCurrentSession().save(booking);
        return booking.getId();
    }

    public Long deleteBooking(Booking booking){
        sessionFactory.getCurrentSession().delete(booking);
        return booking.getId();
    }

    public Long updateBooking(Booking booking){
        sessionFactory.getCurrentSession().update(booking);
        return booking.getId();
    }
}
