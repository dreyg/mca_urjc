package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import usantatecla.draughts.controllers.StartController;
import usantatecla.draughts.utils.Console;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class StartViewTest {

    @Mock
    private StartController startController;

    @Mock
    private Console console;

    @InjectMocks
    private StartView startView;

    @Before
    public void before() {
        initMocks(this);
    }

    @Test
    public void testGivenStartViewWhenInteractWithStartControllerThenInteract() {
        this.startView.interact(this.startController);
        verify(this.console).writeln(Mockito.anyString());
        verify(this.startController).start();
    }

}
