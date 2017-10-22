package blockshare;

import org.apache.commons.collections.ArrayStack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/** A common structure of the map of a site.
 *  @author Shixuan (Wayne) Li
 */
class Map extends ArrayList {
    /** Map is represented by a series of numbers which each represent one parking lot. */
    Map(String name) {
        _name = name;
    }

    @Override
    /** Size of the map. */
    public int size() {
        return _map.size();
    }

    private List<Spot> getMap() {
        return _map;
    }

    public Spot getSpot(int index) {
        return getMap().get(index);
    }

    /** Add spot into the map. */
    public void add(Spot spot) {
        _map.add(spot);
    }

    /** Delete spot from the map. */
    public void delete(int index) {
        _map.remove(index);
    }

    /** Show the map in a way that clearly show availability. */
    public void show() {
        if (size() <= 0) {
            throw new Error("Empty Site.");
        }
        for (int i = 0; i < size(); i++) {
            Spot spot = getMap().get(i);
            System.out.print(spot.getStatus());
        }
    }

    /** Name of the Site which the map belongs to. */
    private String _name;
    private List<Spot> _map = new ArrayList();
}