package usantatecla;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import usantatecla.draughts.AllDraughtsTest;
import usantatecla.utils.AllUtilsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AllDraughtsTest.class
        //AllUtilsTest.class
})
public class AllTest {
}
