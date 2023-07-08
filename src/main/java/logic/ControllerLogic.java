package logic;

import java.util.List;
import persistence.ControllerPersistence;

public class ControllerLogic {

    ControllerPersistence controlPersis;
    
    public ControllerLogic() {
        controlPersis = new ControllerPersistence();
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

    private List<AppUser> getAppUsersList() {
        return controlPersis.getAppUsersList();
    }
    
}
