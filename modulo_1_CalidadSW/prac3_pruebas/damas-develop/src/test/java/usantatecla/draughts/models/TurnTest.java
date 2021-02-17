package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class TurnTest {

    private static Color initialColor = Color.WHITE;

    private Turn turn;

    @Before
    public void before(){
        this.turn = new Turn();
    }

    @Test
    public void testGivenInitialColorWhenIsWhiteThenIsOk(){
        assertThat(this.turn.getColor(), is(initialColor));
    }

    @Test
    public void testGivenOppositeColorWhenIsBlackThenIsOk(){
        assertThat(this.turn.getColor(), is(initialColor));
        assertThat(this.turn.getOppositeColor(), not(initialColor));
    }

    @Test
    public void testGivenChangeColorWhenChangeTurnThenIsOk(){
        this.turn.change();
        assertThat(this.turn.getColor(), not(initialColor));
    }

}
