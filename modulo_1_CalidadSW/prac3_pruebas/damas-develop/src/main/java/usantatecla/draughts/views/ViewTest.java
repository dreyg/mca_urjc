package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.controllers.StartController;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class ViewTest {

    @Mock
    private StartView startView;

    @Mock
    private PlayView playView;

    @Mock
    private ResumeView resumeView;

    @Mock
    private StartController startController;

    @Mock
    private PlayController playController;

    @Mock
    private ResumeController resumeController;

    @InjectMocks
    private View view;

    @Before
    public void before() {
        initMocks(this);
    }

    @Test
    public void testGivenViewWhenInteractWithControllersThenOk() {
        this.view.interact(this.startController);
        verify(this.startController).accept(this.view);

        this.view.interact(this.playController);
        verify(this.playController).accept(this.view);
        this.view.interact(this.resumeController);
        verify(this.resumeController).accept(this.view);
    }

    @Test
    public void testGivenViewWhenVisitStartControllerThenOk() {
        this.view.visit(this.startController);
        verify(this.startView).interact(this.startController);
    }

    @Test
    public void testGivenViewWhenVisitPlayControllerThenOk() {
        this.view.visit(this.playController);
        verify(this.playView).interact(this.playController);
    }

    @Test
    public void testGivenViewWhenVisitResumeControllerThenOk() {
        this.view.visit(this.resumeController);
        verify(this.resumeView).interact(this.resumeController);
    }

}
