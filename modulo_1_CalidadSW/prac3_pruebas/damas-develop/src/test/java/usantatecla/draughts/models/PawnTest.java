package usantatecla.draughts.models;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class PawnTest {


    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {pawn(white()),
                    coordinate(0,0), true,
                    coordinate(5,4), coordinate(4,5), true,
                    Arrays.asList(pawn(black())), 0, new Coordinate[]{ coordinate(5,4), coordinate(3,6)}, null},
                {pawn(white()),
                    coordinate(3,7), true,
                    coordinate(5,4), coordinate(4,5), false,
                    Arrays.asList(pawn(white())), 0, new Coordinate[]{ coordinate(3,6), coordinate(4,6)}, Error.NOT_DIAGONAL},
                {pawn(white()),
                    coordinate(0,7), false,
                    coordinate(3,4), coordinate(4,5), true,
                    Arrays.asList(pawn(black())), 0, new Coordinate[]{ coordinate(3,6), coordinate(5,4)}, Error.COLLEAGUE_EATING},
                {pawn(white()),
                    coordinate(1,7), false,
                    coordinate(0,0), coordinate(7,7), false,
                    Arrays.asList(), 0, new Coordinate[]{ coordinate(7,7), coordinate(0,0)}, Error.TOO_MUCH_ADVANCED},
                {pawn(white()),
                    coordinate(6,4), false,
                    coordinate(7,0), coordinate(0,7), true,
                    Arrays.asList(), 0, new Coordinate[]{ coordinate(7,0), coordinate(5,2)}, Error.WITHOUT_EATING},
                {pawn(white()),
                    coordinate(5,0), false,
                    coordinate(7,7), coordinate(0,0), true,
                    Arrays.asList(pawn(black()),pawn(black())), 0, new Coordinate[]{ coordinate(3,6), coordinate(5,4)}, Error.TOO_MUCH_EATINGS},
        });
    }

 /*  @Test
    public void testGivenIsLimitWhenPawnMoveThenOk(){
        assertEquals(expectedIsLimit, this.piece.isLimit(coordinateToTestLimit));
    }

    @Test
    public void testGivenAdvancedPieceWhenMovedThenOk(){
        assertEquals(expectedIsAdvancing, this.piece.isAdvanced(coordinateOriginAdvance, coordinateTargetAdvance));
    }

    @Test
    public void testGivenCorrectMovementWhenCorrectThenOk(){
        assertEquals(expectedIsCorrectMovement, this.piece.isCorrectMovement(betweenDiagonalPieces, pair, corrdinatesCorrectMovement))
    }
*/
    private static Draught draught(Color color){
        return new Draught(color);
    }

    private static Pawn pawn(Color color){
        return new Pawn(color);
    }

    private static Coordinate coordinate(int row, int column){
        return new Coordinate(row, column);
    }

    private static Color white(){
        return Color.WHITE;
    }

    private static Color black(){
        return Color.BLACK;
    }

}
