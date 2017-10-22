package blockshare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** A common structure of a user's information.
 *  @author Shixuan (Wayne) Li
 */
class User {
    /** A new User is registered with username, password, and usertype. */
    User(String username, String password, String usertype) {
        _username = username;
        _password = password;
        _usertype = usertype;
    }

    /** Get the username. */
    public String getUsername() {
        return _username;
    }

    /** Get the usertype. */
    public String getUsertype() {
        return _usertype;
    }

    /** User should be able to change their password. */
    public String changePassword(String oldPassword, String newPassword) {
        boolean passwordMatch = oldPassword.equals(_password);
        if (passwordMatch) {
            _password = newPassword;
        }
        return _password;
    }

    /** Search sites for given location. */
    public List<Site> searchSites(String location, ParkingList theParkingList) {
        List<Site> result = new ArrayList<>();
        for (int i = 0; i < theParkingList.size(); i++) {
            Site site = theParkingList.getSite(i);
            String status = site.getStatus();
            if (isApprovedStatus(status)) {
                String siteLocation = site.getLocation();
                if (siteLocation.equals(location)) {
                    result.add(site);
                    site.show();
                }
            }
        }
        return result;
    }

    /** Check if the status is approved type. */
    private boolean isApprovedStatus(String status) {
        boolean result = false;
        for (int i = 0; i < approvedStatus.size(); i++) {
            if (approvedStatus.get(i).equals(status)) {
                return true;
            }
        }
        return result;
    }

    /** Username cannot change after registration. */
    private final String _username;

    /** password can be reset after registration. */
    private String _password;

    /** Usertype cannot change after registration. */
    private final String _usertype;

    private List<String> approvedStatus = Arrays.asList("open", "closed");
}
