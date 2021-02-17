package usantatecla.draughts.models;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class CoordinateTest {

    @Test
    public void testGivenIsLastWhenIsNotWithinUpperLimitThenFalse(){
        assertThat(new Coordinate(5,5).isLast(), is(Boolean.FALSE));
    }

    @Test
    public void testGivenIsExtremeCoordinateWhenValuesExtremeThenNull(){
        for(String input: Arrays.asList("00","09","98","98")){
            assertNull(Coordinate.getInstance(input));
        }
    }

    @Test
    public void testGivenIsLastWhenRowIsLastThenTrue(){
        assertThat(Coordinate.getInstance("88").isLast(), is(Boolean.TRUE));
    }

    @Test
    public void testGivenIsFirstWhenRowIsFirstThenTrue(){
        assertThat(Coordinate.getInstance("11").isFirst(), is(Boolean.TRUE));
    }


    // TODO coordinate + direction
}
