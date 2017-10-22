package blockshare;

import static org.junit.Assert.*;
import org.junit.Test;
import ucb.junit.textui;

import java.util.ArrayList;
import java.util.List;

/** The suite of all JUnit tests for the qirkat package.
 *  @author Shixuan (Wayne) Li
 */
public class UnitTest {

    @Test
    public void testOwnerUser() {
        Owner owner1 = new Owner("owner1", "password1");
        String type = owner1.getUsertype();
        assertEquals(type, "owner");
    }


    @Test
    public void testParkingListConstruction() {
        System.out.println("Test Spot.java");
        Spot spot1 = new Spot("site1");
        Spot spot2 = new Spot("site1");
        Spot spot3 = new Spot("site1");
        spot2.changeStatus("closed");
        assertEquals(spot1.getStatus(), "open");
        assertEquals(spot2.getStatus(), "closed");
        System.out.println("Spot.java complete");

        System.out.println();
        System.out.println("Test Map.java");
        Map map1 = new Map("site1");
        map1.add(spot1);
        map1.add(spot2);
        map1.add(spot3);
        assertEquals(map1.size(), 3);
        assertEquals(map1.getSpot(2).getStatus(), "open");
        map1.remove(2);
        assertEquals(map1.size(), 2);
        map1.show();
        System.out.println("Map.java complete");

        System.out.println();
        System.out.println("Test Site.java");
        Site site1 = new Site("site1", map1, "UCSD", "Wayne");
        assertEquals(site1.getName(), "site1");
        assertEquals(site1.getMap(), map1);
        assertEquals(site1.getLocation(), "UCSD");
        assertEquals(site1.getOwner(), "Wayne");
        assertEquals(site1.getStatus(), "open");
        site1.setStatus("closed");
        assertEquals(site1.getStatus(), "closed");
        site1.setStatus("open");
        site1.show();
        site1.showMap();
        System.out.println("Site.java complete");

        System.out.println();
        System.out.println("Test ParkingList.java");
        ParkingList theParkingList = new ParkingList();
        theParkingList.add(site1);
        assertEquals(theParkingList.size(), 1);
        assertEquals(theParkingList.getSite("site1"), site1);
        theParkingList.show();
        theParkingList.show("open");
        theParkingList.remove("site1");
        assertEquals(theParkingList.size(), 0);
        theParkingList.add(site1);
        System.out.println("ParkingList.java complete");

        Spot spot4 = new Spot("site2");
        Spot spot5 = new Spot("site2");
        Spot spot6 = new Spot("site2");
        Map map2 = new Map("site2");
        map2.add(spot4);
        map2.add(spot5);
        map2.add(spot6);

        System.out.println();
        System.out.println("Test Owner.java");
        System.out.println("Test Admin.java");
        Owner owner = new Owner("owner", "owner");
        assertEquals(owner.getUsertype(), "owner");

        /** Owner applies a site named "site2". */
        owner.applyNewSite("site2", map2, "UCSD", theParkingList);
        Site site2 = theParkingList.getSite("site2");
        assertEquals(site2.getStatus(), "application");
        List<Site> list1 = new ArrayList<>();
        list1.add(site2);
        List<Site> resultlist1 = owner.showMySites(theParkingList);
        assertEquals(resultlist1, list1);
        owner.checkMyApplication("site2", theParkingList);
        int ownerCount = owner.numOfSites(theParkingList);
        assertEquals(ownerCount, 1);

        /** Admin approves the application. */
        Admin admin = new Admin("admin", "admin");
        assertEquals(admin.getUsertype(), "admin");
        admin.showParkingList(theParkingList);
        admin.showSelectedSite("application", theParkingList);
        admin.showSelectedSite("open", theParkingList);
        admin.approveSite("site2", theParkingList);
        site2 = theParkingList.getSite("site2");
        assertEquals(site2.getStatus(), "open");

        /** Now 'site2's status should be 'open'.
         * And then try admin's power. */
        owner.checkMyApplication("site2", theParkingList);
        admin.declineSite("site2", theParkingList);

        admin.closeSite("site2", theParkingList);
        site2 = theParkingList.getSite("site2");
        assertEquals(site2.getStatus(), "closed");

        admin.openSite("site2", theParkingList);
        site2 = theParkingList.getSite("site2");
        assertEquals(site2.getStatus(), "open");

        admin.removeSite("site2", theParkingList);
        site2 = theParkingList.getSite("site2");
        assertNull(site2);

        site2 = new Site("site2", map2, "UCSD", "owner");
        admin.addSite(site2, theParkingList);
        Site sitetemp = theParkingList.getSite("site2");
        assertEquals(site2, sitetemp);
        System.out.println("Owner.java complete");
        System.out.println("Admin.java complete");

        System.out.println();
        System.out.println("Test Customer.java");
        Customer customer = new Customer("customer", "customer");
        List<Site> siteList = customer.searchAll("UCSD", theParkingList);
        List<Site> sitetemplist = new ArrayList<>();
        sitetemplist.add(site1);
        sitetemplist.add(site2);
        assertEquals(siteList, sitetemplist);
        siteList = customer.searchAvailable("UCSD", theParkingList);
        assertEquals(siteList, sitetemplist);
        customer.showInfo("site1", theParkingList);
        System.out.println("Customer.java complete");
    }




    /** Run the JUnit tests in this package. Add xxxTest.class entries to
     *  the arguments of runClasses to run other JUnit tests. */
    public static void main(String[] ignored) {
        /* textui.runClasses(); */
        System.exit(textui.runClasses(UnitTest.class));
    }

}
