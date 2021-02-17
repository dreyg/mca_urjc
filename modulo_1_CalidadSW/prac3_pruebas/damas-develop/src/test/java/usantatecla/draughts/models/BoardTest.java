package usantatecla.draughts.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    public BoardTest(){
        this.board = new Board();
    }

    /*
        tablero vacio
    tablero colocado inicial perfecto
    tablero esquina derecha blanca
    tablero 8x8
        movimiento de piezas de forma correcta
    error tablero por dimensiones
    ¿error por ficha equivocada en el tablero?
    */

    @Test
    public void testGivenBoardIsEmptyWhenNewCoordinateIsZeroThenIsTrue(){
        assertTrue(this.board.isEmpty(new Coordinate(0,0)));
    }

    @Test
    public void testGivenNewBoardWhenMoveNewPawnIsOccupiedAndTargetIsEmptyThenIsTrue() {
        Pawn pawn = new Pawn(Color.WHITE);
        Coordinate originCoordinate = new Coordinate(0, 0);
        Coordinate coordinateToMove = new Coordinate(1, 1);
        this.board.put(originCoordinate, pawn);
        this.board.move(originCoordinate, coordinateToMove);
        assertTrue(this.board.isEmpty(originCoordinate));
        assertFalse(this.board.isEmpty(coordinateToMove));
    }







}
