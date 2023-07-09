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
import logic.Guest;
import persistence.exceptions.NonexistentEntityException;

/**
 *
 * @author lancer5500ryz
 */
public class GuestJpaController implements Serializable {

    public GuestJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public GuestJpaController() {
        emf = Persistence.createEntityManagerFactory("HotelAluraPU");

    }
    
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Guest guest) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(guest);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Guest guest) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            guest = em.merge(guest);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = guest.getIdGuest();
                if (findGuest(id) == null) {
                    throw new NonexistentEntityException("The guest with id " + id + " no longer exists.");
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
            Guest guest;
            try {
                guest = em.getReference(Guest.class, id);
                guest.getIdGuest();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The guest with id " + id + " no longer exists.", enfe);
            }
            em.remove(guest);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Guest> findGuestEntities() {
        return findGuestEntities(true, -1, -1);
    }

    public List<Guest> findGuestEntities(int maxResults, int firstResult) {
        return findGuestEntities(false, maxResults, firstResult);
    }

    private List<Guest> findGuestEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Guest.class));
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

    public Guest findGuest(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Guest.class, id);
        } finally {
            em.close();
        }
    }

    public int getGuestCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Guest> rt = cq.from(Guest.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
