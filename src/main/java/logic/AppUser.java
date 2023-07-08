package logic;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppUser implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAppUser;
    private String appUsername;
    private String appUserPassword;

    public AppUser() {
    }

    public AppUser(int idAppUser, String appUsername, String appUserPassword) {
        this.idAppUser = idAppUser;
        this.appUsername = appUsername;
        this.appUserPassword = appUserPassword;
    }

    public int getIdAppUser() {
        return idAppUser;
    }

    public void setIdAppUser(int idAppUser) {
        this.idAppUser = idAppUser;
    }

    public String getAppUsername() {
        return appUsername;
    }

    public void setAppUsername(String appUsername) {
        this.appUsername = appUsername;
    }

    public String getAppUserPassword() {
        return appUserPassword;
    }

    public void setAppUserPassword(String appUserPassword) {
        this.appUserPassword = appUserPassword;
    }
    
    


    
}
