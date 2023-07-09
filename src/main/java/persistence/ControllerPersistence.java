package persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.AppUser;
import logic.Booking;
import logic.Guest;
import persistence.exceptions.NonexistentEntityException;

public class ControllerPersistence {
    
    AppUserJpaController appUserJPA = new AppUserJpaController();
    BookingJpaController bookingJPA = new BookingJpaController();
    GuestJpaController guestJPA = new GuestJpaController();

    public List<AppUser> getAppUsersList() {
        return appUserJPA.findAppUserEntities();
    }

    public void createBooking(Booking aBooking) {
        bookingJPA.create(aBooking);
    }

    public List<Booking> getBookingList() {
        return bookingJPA.findBookingEntities();
    }

    public void createGuest(Guest aGuest) { /////////////////////////////////////
        guestJPA.create(aGuest);
        
    }

    public void deleteLastBooking(int lastBookingId) {
        try {
            bookingJPA.destroy(lastBookingId);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteLastGuest(int lastGuestId) {
        try {
            guestJPA.destroy(lastGuestId);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Guest findGuest(int lastGuestId) {
        return guestJPA.findGuest(lastGuestId);
    }

    public void editGuest(Guest lastGuest) {
        try {
            guestJPA.edit(lastGuest);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
