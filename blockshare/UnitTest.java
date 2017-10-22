package blockshare;

import static org.junit.Assert.*;
import org.junit.Test;
import ucb.junit.textui;

import java.util.ArrayList;

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

    /** Run the JUnit tests in this package. Add xxxTest.class entries to
     *  the arguments of runClasses to run other JUnit tests. */
    public static void main(String[] ignored) {
        /* textui.runClasses(); */
        System.exit(textui.runClasses(UnitTest.class));
    }

}
