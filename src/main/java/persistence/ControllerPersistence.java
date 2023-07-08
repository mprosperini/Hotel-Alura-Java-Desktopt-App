package persistence;

import java.util.List;
import logic.AppUser;

public class ControllerPersistence {
    
    AppUserJpaController AppUserJPA = new AppUserJpaController();

    public List<AppUser> getAppUsersList() {
        return AppUserJPA.findAppUserEntities();
    }
    
    
}
