package usantatecla.draughts.controllers.implementation;

import org.junit.Test;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.*;

import static org.junit.Assert.*;

public class PlayControllerImplementationTest {

    private PlayController playController;

    @Test
    public void testGivenPlayControllerWhenMoveThenOk(){
        Game game = new GameBuilder().rows("        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "b       ",
                "        ").build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(6,0);
        Coordinate target = new Coordinate(5,1);
        playController.move(origin, target);
        assertEquals(playController.getColor(target), Color.WHITE);
    }

    @Test
    public void testGivenPlayControllerWhenMoveBlockedThenError(){
        Game game = new GameBuilder().rows
                ("        ",
                "b       ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "        ").build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(1,0);
        Coordinate target = new Coordinate(0,1);
        playController.move(origin, target);
        assertTrue(game.isBlocked());
    }

    @Test
    public void testGivenPlayControllerWhenMoveSecondPlayerThenOk(){
        Game game = new GameBuilder().rows("        ",
                "        ",
                "        ",
                "n       ",
                "        ",
                "        ",
                "b       ",
                "        ").build();
        playController = new PlayController(game, new State());
        Coordinate origin = new Coordinate(6,0);
        Coordinate target = new Coordinate(5,1);
        playController.move(origin, target);
        Coordinate originBlack = new Coordinate(3,0);
        Coordinate targetBlack = new Coordinate(4,1);
        playController.move(originBlack, targetBlack);
        assertEquals(playController.getColor(targetBlack), Color.BLACK);
    }

    //TODO como probar el cancel ??

}
