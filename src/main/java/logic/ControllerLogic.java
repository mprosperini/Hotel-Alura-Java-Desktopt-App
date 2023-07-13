package logic;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import persistence.ControllerPersistence;

public class ControllerLogic {

    ControllerPersistence controlPersis;
    
    public ControllerLogic() {
        controlPersis = new ControllerPersistence();
    }

    
    public void showMessage(String message, String type, String tittle) {
        //Creating Pop Up Dialog when delete//
        JOptionPane optionPane = new JOptionPane(message);

        if (type.equals("info")) {

            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if ((type.equals("error"))) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }

        JDialog dialog = optionPane.createDialog(tittle);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);

    }
    
    public boolean verifyCredentials(String appUsrName, String appUsrPassword) {
        List<AppUser> appUserList = this.getAppUsersList();
        for(AppUser anUser :appUserList ){
            if(anUser.getAppUsername().equals(appUsrName) && anUser.getAppUserPassword().equals(appUsrPassword)) {
                return true;
            }
        }
        return false;
    }

    public List<AppUser> getAppUsersList() {
        return controlPersis.getAppUsersList();
    }

    public void createBooking(Date date, Date date0, int reservationPrice, String string) {
        Guest aGuest = new Guest();
        Booking aBooking = new Booking(date, date0, reservationPrice, string, aGuest);
        aBooking.setCheckInDate(date);
        aBooking.setCheckOutDate(date0);
        aBooking.setPaymentMethod(string);
        aBooking.setPrice(reservationPrice);
        aBooking.setaGuest(aGuest);
        
        controlPersis.createGuest(aGuest);           ////////////////////
        controlPersis.createBooking(aBooking);
    }

    public int calcDifferenceBetweenDates(Date date, Date date0) {
        Long diffBtwDates = (date0.getTime() - date.getTime() ) / (24*60*60*1000) ;
        return diffBtwDates.intValue();
        
    }

    public int calcReservationPrice(int diffBetweenDates) {
        
        int pricePerDay = 50; //USD
        return diffBetweenDates * pricePerDay;
    }

    public List<Booking> getBookingList() {
        return controlPersis.getBookingList();
    }

    public void deleteLastBooking(Booking lastBooking) {
        int lastBookingId = lastBooking.getIdBooking();
        controlPersis.deleteLastBooking(lastBookingId);
    }

    public void deleteLastGuest(Booking lastBooking) {
        int lastGuestId = lastBooking.getIdBooking();
        controlPersis.deleteLastGuest(lastGuestId);
        
    }

    public void editGuest(Booking lastBooking, String firstName, String lastName, String phoneNumber, String nationality, Date birthDate) {
        int lastGuestId = lastBooking.getIdBooking();
        Guest lastGuest =  this.findGuest(lastGuestId);
        
        lastGuest.setGuestName(firstName);
        lastGuest.setGuestLastName(lastName);
        lastGuest.setGuestPhone(phoneNumber);
        lastGuest.setGuestNationality(nationality);
        lastGuest.setGuestBirthDate(birthDate);
        
        controlPersis.editGuest(lastGuest);
    }

    public Guest findGuest(int lastGuestId) {
        return controlPersis.findGuest(lastGuestId);
    }

    public List<Guest> getGuestList() {
        return controlPersis.getGuestList();
    }

    public void deleteBooking(int bookingId) {
        controlPersis.deleteBooking(bookingId);
    }

    public void deleteGuest(int selectedTableId) {
        controlPersis.deleteGuest(selectedTableId);
    }

    public Booking  findBooking(int bookingid) {
        return controlPersis.findBooking(bookingid);
    }

    public void editBooking(Booking bookingToEdit, int reservationPrice, Date checkin, Date checkout, String paymentMethod) {
        bookingToEdit.setCheckInDate(checkin);
        bookingToEdit.setCheckOutDate(checkout);
        bookingToEdit.setPaymentMethod(paymentMethod);
        bookingToEdit.setPrice((reservationPrice));
        
        controlPersis.editBooking(bookingToEdit);
        
    }

    public Booking findBooking(Guest guestToEdit) {
        List<Booking> bookingList = controlPersis.getBookingList();
        bookingList = bookingList.stream().filter(guest -> guest.getaGuest().getIdGuest() == guestToEdit.getIdGuest()).collect(Collectors.toList());
        return bookingList.get(0);
    }

    
}
