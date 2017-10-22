package blockshare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/** A common structure of new site application list.
 *  @author Shixuan (Wayne) Li
 */
class ParkingList extends ArrayList{
    /** A list of sites that keeps track of any changes in sites. */
    ParkingList() {}

    public Site getSite(int index) {
        return getList().get(index);
    }

    public Site getSite(String name) {
        int index = getIndex(name);
        if (index < 0) {
            System.out.println("No corresponding site found.");
            return null;
        }
        return getSite(index);
    }

    @Override
    /** Get size. */
    public int size() {
        return getList().size();
    }

    /** Get the list. */
    public ArrayList<Site> getList() {
        return _list;
    }

    /** Add new site. */
    public void add(Site site) {
        getList().add(site);
    }

    /** Get index of the site based on name and owner. */
    private int getIndex(String name) {
        if (this.size() <= 0) {
            return -1;
        }
        for (int i = 0; i < size(); i++) {
            Site site = getSite(i);
            String siteName = site.getName();
            if (siteName.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /** Show the list. */
    public void show() {
        if (size() <= 0) {
            throw new Error("Empty ParkingList.");
        }
        for (int i = 0; i < size(); i++) {
            Site site = getSite(i);
            site.show();
        }
    }

    /** Show the list with selected status. */
    public void show(String status) {
        int count = 0;
        if (size() <= 0) {
            throw new Error("Empty ParkingList.");
        }
        for (int i = 0; i < size(); i++) {
            Site site = getSite(i);
            if (site.getStatus().equals(status)) {
                site.show();
                count += 1;
            }
        }
        if (count == 0) {
            System.out.println("Nothing found for your selection.");
        }
    }

    /** Delete a site. */
    public void remove(String name) {
        int index = getIndex(name);
        if (index < 0) {
            throw new Error("Empty list or no such site.");
        } else {
            getList().remove(index);
        }
    }

    /** Define the list. */
    private ArrayList<Site> _list = new ArrayList();
}


















