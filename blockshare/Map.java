package blockshare;

import java.util.ArrayList;
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

    @Override
    /** Delete spot from the map. */
    public Object remove(int index) {
        _map.remove(index);
        return null;
    }

    /** Show the map in a way that clearly show availability. */
    public void show() {
        if (size() <= 0) {
            throw new Error("Empty Site.");
        }
        System.out.println("Spots' status are: ");
        for (int i = 0; i < size(); i++) {
            Spot spot = getMap().get(i);
            System.out.println("   " + (i+1) + "." + spot.getStatus());

        }
    }

    /** Name of the Site which the map belongs to. */
    private String _name;
    private List<Spot> _map = new ArrayList();
}