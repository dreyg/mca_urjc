package usantatecla.draughts;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import usantatecla.draughts.controllers.implementation.AllControllerimplementationTest;
import usantatecla.draughts.models.AllModelTest;
import usantatecla.draughts.views.AllViewTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({AllControllerimplementationTest.class,
        AllModelTest.class,
        AllViewTest.class })
public class AllDraughtsTest {
}
