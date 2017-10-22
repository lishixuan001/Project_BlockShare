package blockshare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/** A common structure of a owner's information.
 *  @author Shixuan (Wayne) Li
 */
class Owner extends User {
    /** An owner is registerd as usertype "owner".
     * An owner provides parking spots by submitting application,
     * which then will be approved/or not by the administrator. */
    Owner(String username, String password) {
        super(username, password, "owner");
    }

    public void applyNewSite(String name, Map map, String location, ParkingList theParkingList) {
        Site newSite = new Site(name, map, location, this.getUsername());
        newSite.setStatus("application");
        theParkingList.add(newSite);
        System.out.println("Application Submitted");
    }

    public int numOfSites(ParkingList theParkinglist) {
        List<Site> siteList = showMySites(theParkinglist);
        int number = siteList.size();
        System.out.println("You have totally [" + number + "] sites.");
        return number;
    }

    public List<Site> showMySites(ParkingList theParkingList) {
        List<Site> result = new ArrayList();
        Iterator<Site> AppListIterator = theParkingList.getList().iterator();
        while (AppListIterator.hasNext()) {
            Site site = AppListIterator.next();
            String siteOwner = site.getOwner();
            if (siteOwner.equals(this.getUsername())) {
                System.out.println("Your site named [" + site.getName()
                        + "] is now [" + site.getStatus() + "]");
                result.add(site);
            }
        }
        return result;
    }

    public void checkMyApplication(String name, ParkingList theParkingList) {
        Iterator<Site> AppListIterator = theParkingList.getList().iterator();
        while (AppListIterator.hasNext()) {
            Site site = AppListIterator.next();
            String siteOwner = site.getOwner();
            String siteName = site.getName();
            boolean condition1 = siteOwner.equals(this.getUsername());
            boolean condition2 = siteName.equals(name);
            if (condition1 && condition2) {
                System.out.println("Your applied site for [" + site.getName()
                        + "] is now [" + site.getStatus() + "]");
            }
        }
        return;
    }


}
