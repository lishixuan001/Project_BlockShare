package blockshare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/** A common structure of a parking site.
 *  @author Shixuan (Wayne) Li
 */
class Site {
    /** A site is a spot for parking. */
    Site(String name, Map map, String location, String owner) {
        _name = name;
        _map = map;
        _location = location;
        _owner = owner;
        _status = "open";
    }

    /** Get the name of the site. */
    public String getName() {
        return _name;
    }

    /** Get the map of the site. */
    public Map getMap() {
        return _map;
    }

    /** Get the location of the site. */
    public String getLocation() { return _location; }

    /** Get the owner of the site. */
    public String getOwner() {
        return _owner;
    }

    /** Get the status of the site. */
    public String getStatus() { return _status; }

    /** Check if the status type is valid. */
    private boolean isValidStatus(String status) {
        boolean result = false;
        for (int i = 0; i < allValidStatus.size(); i++) {
            if (allValidStatus.get(i).equals(status)) {
                return true;
            }
        }
        return result;
    }

    /** Change site status. */
    public void setStatus(String status) {
        if (isValidStatus(status)) {
            _status = status;
        } else {
            throw new Error("Invalid status change.");
        }
    }

    /** Display the information of the site. */
    public void show() {
        System.out.println("Site [" + getName() + "] at location ["
                + getLocation() + "] has status [" + getStatus() + "]");
    }

    /** Display the map of the site. */
    public void showMap() {
        getMap().show();
    }


    /** Attribute variables. */
    private String _name;
    private Map _map;
    private String _location;
    private String _owner;
    private String _status;
    private List<String> allValidStatus = Arrays.asList("open", "closed", "application", "declined");
}