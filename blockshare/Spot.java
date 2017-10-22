package blockshare;

import org.apache.commons.collections.ArrayStack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/** A common structure of the spot in a parking map.
 *  @author Shixuan (Wayne) Li
 */
class Spot extends ArrayList {
    Spot(String name) {
        _name = name;
        _status = "open";
    }

    /** Get status. */
    public String getStatus() {
        return _status;
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

    /** Change status. */
    public void changeStatus(String status) {
        if (isValidStatus(status)) {
            _status = status;
        } else {
            throw new Error("Invalid status type.");
        }
    }

    /** Name of the Site(Map) which the Spot belongs to. */
    private String _name;
    private String _status;
    private List<String> allValidStatus = Arrays.asList("open", "closed", "application", "declined");
}