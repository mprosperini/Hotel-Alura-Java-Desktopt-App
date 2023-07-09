package persistence;

import java.util.List;
import logic.AppUser;
import logic.Booking;
import logic.Guest;

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
    
    
}
