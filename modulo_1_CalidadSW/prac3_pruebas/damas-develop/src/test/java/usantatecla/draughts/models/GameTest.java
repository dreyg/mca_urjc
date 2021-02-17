package usantatecla.draughts.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    Game game;

    public static Game game(String... rows){
        return new GameBuilder().rows(rows).build();
    }

    @Test
    public void testGivenBlockedPawnWhenBoardBlockedThenReturnTrue(){
        this.game = game(
                "        ",
                "        ",
                " n   n  ",
                "  n n   ",
                "   b    ",
                "        ",
                "        ",
                "        "
        );
        assertTrue(this.game.isBlocked());
    }

    @Test
    public void testGivenUnblockedPawnWhenBoardUnblockedThenReturnTrue(){
        this.game = game(
                "        ",
                "        ",
                " n      ",
                "  n n   ",
                "   b    ",
                "  n n   ",
                " n   n  ",
                "        "
        );
        assertFalse(this.game.isBlocked());
    }

    @Test
    public void testGivenBlockedDraughtWhenBoardBlockedThenReturnTrue(){
        this.game = game(
                  "        ",
                        "        ",
                        "  n     ",
                        " n      ",
                        "B       ",
                        " n      ",
                        "  n     ",
                        "        "
        );
        assertTrue(this.game.isBlocked());
    }

    @Test
    public void testGivenUnblockedDraughtWhenBoardUnblockedThenReturnFalse(){
        this.game = game(
                  "        ",
                        "        ",
                        "  n     ",
                        " n      ",
                        "B       ",
                        " n      ",
                        "        ",
                        "        "
        );
        assertFalse(this.game.isBlocked());
    }

    @Test
    public void testGivenEmptyOriginPawnWhenBoardUnblockedThenReturnErrorNotDiagonal(){
        this.game = game(
                  "        ",
                        "        ",
                        "   n    ",
                        "  n     ",
                        "        ",
                        "  n     ",
                        "   n    ",
                        "b       "
        );
        Error error = this.game.move(coordinate(6,5),coordinate(4,7),coordinate(3,7));
        assertEquals(Error.EMPTY_ORIGIN,error);
    }



    @Test
    public void testGivenMoveEatingWhenErrorTooMuchThenError(){
        this.game = game(
                  "        ",
                        "        ",
                        "        ",
                        "        ",
                        "     n  ",
                        "      n ",
                        "       B",
                        "        "
        );
        Error error = this.game.move(coordinate(6,7),coordinate(3,4));
        assertEquals(Error.TOO_MUCH_EATINGS,error);
    }

    private Coordinate coordinate(int row, int column){
        return new Coordinate(row,column);
    }

}
