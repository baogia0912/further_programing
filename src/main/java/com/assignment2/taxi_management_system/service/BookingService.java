package com.assignment2.taxi_management_system.service;
import com.assignment2.taxi_management_system.model.Booking;
import com.assignment2.taxi_management_system.model.Car;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Transactional
@Service
@SuppressWarnings("unchecked")
public class BookingService {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Booking> getAllBookings(){
        return (List<Booking>) sessionFactory.getCurrentSession().createQuery("from Booking order by dateCreated").list();
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
        Booking oldBooking = sessionFactory.getCurrentSession().find(Booking.class, booking.getId());
        if(booking.getStartLocation() != null){
            oldBooking.setStartLocation(booking.getStartLocation());
        }
        if(booking.getEndLocation() != null){
            oldBooking.setEndLocation(booking.getEndLocation());
        }
        if(booking.getPickUpDateTime() != null){
            oldBooking.setPickUpDateTime(booking.getPickUpDateTime());
        }
        if(booking.getDropOffDateTime() != null){
            oldBooking.setDropOffDateTime(booking.getDropOffDateTime());
        }
        if(booking.getDistance() > 0){
            oldBooking.setDistance(booking.getDistance());
        }
        return booking.getId();
    }

    public Booking findByID(long id){
        return sessionFactory.getCurrentSession().find(Booking.class, id);
    }

    public List<Booking> findByDate(ZonedDateTime start_date, ZonedDateTime end_date){
        return (List<Booking>) sessionFactory.getCurrentSession()
                .createQuery("from Booking where dateCreated >= :start and dateCreated <= :end")
                .setParameter("start", start_date)
                .setParameter("end", end_date.plusHours(23).plusMinutes(59).plusSeconds(59)).list();
    }
}
