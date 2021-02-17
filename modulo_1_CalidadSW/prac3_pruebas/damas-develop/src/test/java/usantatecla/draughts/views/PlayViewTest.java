package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.utils.Console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class PlayViewTest {

    @Mock
    private PlayController playController;

    @Mock
    private Console console;

    @InjectMocks
    private PlayView playView;

    @Before
    public void before() {
        initMocks(this);
    }

    @Test(expected = AssertionError.class)
    public void testGivenPlayViewWhenInteractWithNullPlayControllerThenError() {
        this.playView.interact(null);
    }

    @Test
    public void testGivenPlayViewWhenInteractWithPlayControllerAndReadBadFormatCoordinatesThenCancel() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(anyString())).thenReturn("-1");

        this.playView.interact(this.playController);

        verify(this.playController).cancel();
    }

    @Test
    public void testGivenPlayViewWhenInteractWithPlayControllerAndReadCorrectCoordinatesThenMove() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(anyString())).thenReturn("11.22");

        this.playView.interact(this.playController);

        verify(this.playController).move(
                new Coordinate(0, 0),
                new Coordinate(1, 1)
        );
    }

    @Test
    public void testGivenPlayViewWhenInteractWithPlayControllerAndGameIsBlockedThenBlocked() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(anyString())).thenReturn("11.22");
        when(this.playController.isBlocked()).thenReturn(Boolean.TRUE);

        this.playView.interact(this.playController);

        verify(this.console).writeln("Derrota!!! No puedes mover tus fichas!!!");
    }

    @Test
    public void testGivenPlayViewWhenInteractWithPlayControllerAndReadWrongFormatCoordinatesThenWrongFormat() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(anyString())).thenReturn("abcd").thenReturn("-1");

        this.playView.interact(this.playController);

        verify(this.console, times(1)).writeln("Error!!! Formato incorrecto");
    }

}
