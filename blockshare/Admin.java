package blockshare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/** A common structure of a admin's information.
 *  @author Shixuan (Wayne) Li
 */
class Admin extends User {
    Admin(String username, String password) {
        super(username, password, "admin");
    }

    /** Show the ParkingList. */
    public void showParkingList(ParkingList theParkingList) {
        theParkingList.show();
    }

    /** Only show "in application" Sites. */
    public void showSiteInApplication(ParkingList theParkingList) {
        theParkingList.show("application");
    }

    /** Only show "open" Sites. */
    public void showSiteOpen(ParkingList theParkingList) {
        theParkingList.show("open");
    }

    /** Only show "closed" Sites. */
    public void showSiteClosed(ParkingList theParkingList) {
        theParkingList.show("closed");
    }


    /** Approve the application of a site. */

    /** Decline the application of a site. */

    /** Close a site on ParkingList. */

    /** Remove a site on ParkingList*/
}