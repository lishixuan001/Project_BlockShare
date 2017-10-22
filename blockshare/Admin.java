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


/** A common structure of a admin's information.
 *  @author Shixuan (Wayne) Li
 */
class Admin extends User {
    Admin(String username, String password) {
        super(username, password, "admin");
    }

    /** Show all sites. */
    public void showParkingList(ParkingList theParkingList) {
        theParkingList.show();
    }

    /**  Show sites by selection. */
    public void showSelectedSite(String status, ParkingList theParkingList) {
        theParkingList.show(status);
    }

    /** Approve the application of a site. */
    public void approveSite(String name, ParkingList theParkingList) {
        Site site = theParkingList.getSite(name);
        String status = site.getStatus();
        if (isApprovedStatus(status)) {
            System.out.println("It is already an approved site, maybe you want to open/close it?");
        } else if (isInApplicationStatus(status)) {
            site.setStatus("open");
            System.out.println("Selected site is now approved and open.");
        }
    }

    /** Decline the application of a site. */
    public void declineSite(String name, ParkingList theParkingList) {
        Site site = theParkingList.getSite(name);
        String status = site.getStatus();
        if (isApprovedStatus(status)) {
            System.out.println("You cannot decline an approved site, maybe you want to open/close it?");
        } else if (isInApplicationStatus(status)) {
            site.setStatus("declined");
            System.out.println("Selected site is now declined.");
        }
    }

    /** Open a site on ParkingList. */
    public void openSite(String name, ParkingList theParkingList) {
        Site site = theParkingList.getSite(name);
        String status = site.getStatus();
        if (isApprovedStatus(status)) {
            site.setStatus("open");
            System.out.println("Selected site is now open");
        } else if (isInApplicationStatus(status)) {
            System.out.println("Selected site hasn't been approved yet, please approve/decline first.");
        }
    }

    /** Close a site on ParkingList. */
    public void closeSite(String name, ParkingList theParkingList) {
        Site site = theParkingList.getSite(name);
        String status = site.getStatus();
        if (isApprovedStatus(status)) {
            site.setStatus("closed");
            System.out.println("Selected site is now closed");
        } else if (isInApplicationStatus(status)) {
            System.out.println("Selected site hasn't been approved yet, please approve/decline first.");
        }
    }

    /** Add a site on ParkingList*/
    public void addSite(Site site, ParkingList theParkingList) {
        theParkingList.add(site);
        System.out.println("Selected site is now added");
    }

    /** Remove a site on ParkingList*/
    public void removeSite(String name, ParkingList theParkingList) {
        Site site = theParkingList.getSite(name);
        String status = site.getStatus();
        if (isValidStatus(status)) {
            theParkingList.remove(name);
            System.out.println("Selected site is now closed");
        }
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

    /** Check if the status is 'in application' type. */
    private boolean isInApplicationStatus(String status) {
        boolean result = false;
        for (int i = 0; i < inApplicationStatus.size(); i++) {
            if (inApplicationStatus.get(i).equals(status)) {
                return true;
            }
        }
        return result;
    }

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

    private List<String> approvedStatus = Arrays.asList("open", "closed");
    private List<String> inApplicationStatus = Arrays.asList("application", "declined");
    private List<String> allValidStatus = Arrays.asList("open", "closed", "application", "declined");
}