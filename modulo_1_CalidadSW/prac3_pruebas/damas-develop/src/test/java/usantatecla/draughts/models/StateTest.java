package usantatecla.draughts.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateTest {

    private State state;

    public StateTest() {
        this.state = new State();
    }

    @Test
    public void testGivenNewStateWhenGetValueStateThenIsInitial() {
        assertEquals(StateValue.INITIAL, this.state.getValueState());
    }

    @Test
    public void testGivenNewStateWhenDoNextAndGetValueStateThenIsInGame() {
        this.state.next();
        assertEquals(StateValue.IN_GAME, this.state.getValueState());
    }

    @Test
    public void testGivenNewStateWhenDoTwoNextAndGetValueStateThenIsResult() {
        this.state.next();
        this.state.next();
        assertEquals(StateValue.FINAL, this.state.getValueState());
    }

    @Test
    public void testGivenNewStateWhenDoThreeNextAndGetValueStateThenIsExit() {
        this.state.next();
        this.state.next();
        this.state.next();
        assertEquals(StateValue.EXIT, this.state.getValueState());
    }

    @Test
    public void testGivenResetStateWhenResetStateThenIsInitial(){
        this.state.next();
        state.reset();
        assertEquals(StateValue.INITIAL, this.state.getValueState());
    }
}
