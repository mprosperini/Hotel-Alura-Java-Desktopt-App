/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logic.Booking;
import logic.Guest;
import persistence.exceptions.NonexistentEntityException;

public class BookingJpaController implements Serializable {

    public BookingJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public BookingJpaController() {
                emf = Persistence.createEntityManagerFactory("HotelAluraPU");
    }
    
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Booking booking) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Guest aGuest = booking.getaGuest();
            if (aGuest != null) {
                aGuest = em.getReference(aGuest.getClass(), aGuest.getIdGuest());
                booking.setaGuest(aGuest);
            }
            em.persist(booking);
            if (aGuest != null) {
                aGuest.getGuestBooking().add(booking);
                aGuest = em.merge(aGuest);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Booking booking) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Booking persistentBooking = em.find(Booking.class, booking.getIdBooking());
            Guest aGuestOld = persistentBooking.getaGuest();
            Guest aGuestNew = booking.getaGuest();
            if (aGuestNew != null) {
                aGuestNew = em.getReference(aGuestNew.getClass(), aGuestNew.getIdGuest());
                booking.setaGuest(aGuestNew);
            }
            booking = em.merge(booking);
            if (aGuestOld != null && !aGuestOld.equals(aGuestNew)) {
                aGuestOld.getGuestBooking().remove(booking);
                aGuestOld = em.merge(aGuestOld);
            }
            if (aGuestNew != null && !aGuestNew.equals(aGuestOld)) {
                aGuestNew.getGuestBooking().add(booking);
                aGuestNew = em.merge(aGuestNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = booking.getIdBooking();
                if (findBooking(id) == null) {
                    throw new NonexistentEntityException("The booking with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Booking booking;
            try {
                booking = em.getReference(Booking.class, id);
                booking.getIdBooking();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The booking with id " + id + " no longer exists.", enfe);
            }
            Guest aGuest = booking.getaGuest();
            if (aGuest != null) {
                aGuest.getGuestBooking().remove(booking);
                aGuest = em.merge(aGuest);
            }
            em.remove(booking);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Booking> findBookingEntities() {
        return findBookingEntities(true, -1, -1);
    }

    public List<Booking> findBookingEntities(int maxResults, int firstResult) {
        return findBookingEntities(false, maxResults, firstResult);
    }

    private List<Booking> findBookingEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Booking.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Booking findBooking(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Booking.class, id);
        } finally {
            em.close();
        }
    }

    public int getBookingCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Booking> rt = cq.from(Booking.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
