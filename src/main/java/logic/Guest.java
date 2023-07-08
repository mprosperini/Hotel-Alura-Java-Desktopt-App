package logic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Guest implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGuest;
    private String guestName;
    private String guestLastName;
    @Temporal(TemporalType.DATE)
    private Date guestBirthDate;
    private String guestNationality;
    private String guestPhone;
    
    @OneToMany(mappedBy = "aGuest")
    private List<Booking> guestBooking;
    
    //private int  reservationNumber;

    public Guest() {
    }

    public Guest(int idGuest, String guestName, String guestLastName, Date guestBirthDate, String guestNationality, String guestPhone, List<Booking> guestBooking) {
        this.idGuest = idGuest;
        this.guestName = guestName;
        this.guestLastName = guestLastName;
        this.guestBirthDate = guestBirthDate;
        this.guestNationality = guestNationality;
        this.guestPhone = guestPhone;
        this.guestBooking = guestBooking;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    public Date getGuestBirthDate() {
        return guestBirthDate;
    }

    public void setGuestBirthDate(Date guestBirthDate) {
        this.guestBirthDate = guestBirthDate;
    }

    public String getGuestNationality() {
        return guestNationality;
    }

    public void setGuestNationality(String guestNationality) {
        this.guestNationality = guestNationality;
    }

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }

    public List<Booking> getGuestBooking() {
        return guestBooking;
    }

    public void setGuestBooking(List<Booking> guestBooking) {
        this.guestBooking = guestBooking;
    }
    
    
    
}
