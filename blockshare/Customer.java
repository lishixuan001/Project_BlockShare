package blockshare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/** A common structure of a customer's information.
 *  @author Shixuan (Wayne) Li
 */
class Customer extends User {
    /** An customer is registerd as usertype "customer".
     * An customer searches and rents available parking spaces. */
    Customer(String username, String password) {
        super(username, password, "customer");
    }

    /** Search all nearby parking lots. */
    public List<Site> searchAll(String location, ParkingList theParkingList) {
        List<Site> result = new ArrayList();
        Iterator<Site> ParkListIterator = theParkingList.getList().iterator();
        while (ParkListIterator.hasNext()) {
            Site site = ParkListIterator.next();
            String siteLocation = site.getLocation();
            String siteName = site.getName();
            String siteStatus = site.getStatus();
            if (siteLocation.equals(location)) {
                System.out.println("Parking space called [" + siteName
                        + "] is [" + siteStatus + "]");
                result.add(site);
            }
        }
        return result;
    }

    /** Search nearby parking lots that are available. */
    public List<Site> searchAvailable(String location, ParkingList theParkingList) {
        List<Site> result = new ArrayList();
        Iterator<Site> ParkListIterator = theParkingList.getList().iterator();
        while (ParkListIterator.hasNext()) {
            Site site = ParkListIterator.next();
            String siteLocation = site.getLocation();
            String siteName = site.getName();
            String siteStatus = site.getStatus();
            if (siteLocation.equals(location) && siteStatus.equals("open")) {
                System.out.println("Parking space called [" + siteName
                        + "] is [" + siteStatus + "]");
                result.add(site);
            }
        }
        return result;
    }

    /** See information about a parking station.
     * Note: the "info" here means "map" specifically. */
    public void showInfo(String name, ParkingList theParkingList) {
        Site site = theParkingList.getSite(name);
        site.showMap();
    }

}



























