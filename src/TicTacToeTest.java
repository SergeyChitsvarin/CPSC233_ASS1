import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    /**
     * test to see if the function creates and returns a 2D integer array,
     * filled with 0's
     * with rows that should be size of first dimension of array,
     * columns the second dimension.
     */
    @Test
    void createBoard3x4Success(){
        // references:
        // comparing two arrays https://stackoverflow.com/questions/4228161/comparing-arrays-in-junit-assertions-concise-built-in-way
        // creating 2d array https://www.geeksforgeeks.org/multidimensional-arrays-in-java/
        int[][] board = TicTacToe.createBoard(3,4);
        int[][] expectedBoard = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
        assertArrayEquals(expectedBoard, board);
    }

    /**
     * take a 3x5 board and make sure the method returns 3 rows.
     */
    @Test
    void rowsIn3x5BoardSuccess() {
        int[][] board = TicTacToe.createBoard(3,5);
        int rowCount = TicTacToe.rowsIn(board);
        int expectedRowCount = 3;
        assertEquals(expectedRowCount,rowCount);
    }

    /**
     * take a 4x5 board and make sure the method returns 4 rows.
     */
    @Test
    void rowsIn4x5BoardSuccess() {
        int[][] board = TicTacToe.createBoard(4,5);
        int rowCount = TicTacToe.rowsIn(board);
        int expectedRowCount = 4;
        assertEquals(expectedRowCount,rowCount);
    }

    /**
     * Take a 3x4 board and make sure the method returns 4 columns.
     */
    @Test
    void columnsIn3x4BoardSuccess() {
        int[][] board = TicTacToe.createBoard(3,4);
        int columnCount = TicTacToe.columnsIn(board);
        int expectedColumnCount = 4;
        assertEquals(expectedColumnCount,columnCount);
    }

    /**
     * Take a 5x3 board and make sure the method returns 3 columns.
     */
    @Test
    void columnsIn5x3BoardSuccess() {
        int[][] board = TicTacToe.createBoard(5,3);
        int columnCount = TicTacToe.columnsIn(board);
        int expectedColumnCount = 3;
        assertEquals(expectedColumnCount, columnCount);
    }

    /**
     * it returns true if cell is open
     */
    @Test
    void canPlayOpenSuccess() {
        int[][] board = TicTacToe.createBoard(5,3);
        boolean open = TicTacToe.canPlay(board, 0,0);
        assertTrue(open);
    }

    /**
     * it returns false if cell is closed
     */
    @Test
    void canPlayClosedSuccess() {
        int[][] board = TicTacToe.createBoard(5,3);
        board[0][0] = 1;
        boolean open = TicTacToe.canPlay(board, 0,0);
        assertFalse(open);
    }

    /**
     * checks if the function places piece 1 on empty square
     */
    @Test
    void playPiece1Success() {
        int[][] board = TicTacToe.createBoard(5,4);
        TicTacToe.play(board, 2,2,1);
        int pieceAtPosition = board[2][2];
        assertEquals(1, pieceAtPosition);
    }

    /**
     * checks if the function places piece 2 on empty square
     */
    @Test
    void playPiece2Success() {
        int[][] board = TicTacToe.createBoard(5,3);
        TicTacToe.play(board, 0,0,2);
        int pieceAtPosition = board[0][0];
        assertEquals(2, pieceAtPosition);
    }

    /**
     * returns true if the board is full
     */
    @Test
    void fullBoardSuccess() {
        int[][] board = TicTacToe.createBoard(3,3);
        board[0][0] = 1; board[0][1] = 1; board[0][2] = 1;
        board[1][0] = 1; board[1][1] = 1; board[1][2] = 1;
        board[2][0] = 1; board[2][1] = 1; board[2][2] = 1;
        boolean full = TicTacToe.full(board);
        assertTrue(full);

    }

    /**
     * returns false if the board is not full (empty)
     */
    @Test
    void fullEmptyBoardSuccess() {
        int[][] board = TicTacToe.createBoard(3,3);
        boolean full = TicTacToe.full(board);
        assertFalse(full);

    }

    /**
     * returns false if the board is partially filled
     */
    @Test
    void fullHalfFilledBoardSuccess() {
        int[][] board = TicTacToe.createBoard(3,3);
        board[0][0] = 1; board[0][1] = 1; board[0][2] = 1;
        board[1][0] = 1; board[1][1] = 1;
        boolean full = TicTacToe.full(board);
        assertFalse(full);

    }

    /**
     * checks if function returns true if row has 3 of the same consecutive piece that was given (1)
     */
    @Test
    void winInRowSuccess() {
        int[][] board = TicTacToe.createBoard(3,3);
        board[0][0] = 1; board[0][1] = 1; board[0][2] = 1;
        boolean win = TicTacToe.winInRow(board, 0, 1);
        assertTrue(win);
    }

    /**
     * checks if function returns false if row has less than 3 of the same consecutive piece that was given (1)
     */
    @Test
    void winInRowLossSuccess() {
        int[][] board = TicTacToe.createBoard(3,3);
        board[2][0] = 0; board[2][1] = 1; board[2][2] = 1;
        boolean win = TicTacToe.winInRow(board, 2, 1);
        assertFalse(win);
    }

    /**
     * checks if function returns false with empty board
     */
    @Test
    void winInRowEmptyBoardSuccess() {
        int[][] board = TicTacToe.createBoard(5,5);
        boolean win = TicTacToe.winInRow(board, 2, 2);
        assertFalse(win);
    }

    /**
     * checks if function returns true if column has 3 of the same consecutive piece that was given (1)
     */
    @Test
    void winInColumnSuccess() {
        int[][] board = TicTacToe.createBoard(3,3);
        board[0][0] = 1; board[1][0] = 1; board[2][0] = 1;
        boolean win = TicTacToe.winInColumn(board, 0, 1);
        assertTrue(win);
    }

    /**
     * checks if function returns false if column has less than 3 of the same consecutive piece that was given (1)
     */
    @Test
    void winInColumnLossSuccess() {
        int[][] board = TicTacToe.createBoard(3,3);
        board[0][2] = 0; board[1][2] = 1; board[2][2] = 1;
        boolean win = TicTacToe.winInColumn(board, 2, 1);
        assertFalse(win);
    }

    /**
     * checks if function returns false with empty board
     */
    @Test
    void winInColumnEmptyBoardSuccess() {
        int[][] board = TicTacToe.createBoard(5,5);
        boolean win = TicTacToe.winInRow(board, 2, 2);
        assertFalse(win);
    }

    /**
     * when a diagonal has 3 consecutive given pieces (2) it returns true
     */
    @Test
    void winInDiagonalBSSuccess() {
        int[][] board = TicTacToe.createBoard(5,5);
        board[2][2] = 2;
        board[3][3] = 2;
        board[4][4] = 2;
        boolean win = TicTacToe.winInDiagonalBS(board, 2);
        assertTrue(win);
    }

    /**
     * when none of the diagonals have 3 consecutive given pieces (2) it returns false
     */
    @Test
    void winInDiagonalBSLossSuccess() {
        int[][] board = TicTacToe.createBoard(5,5);
        board[0][0] = 2;
        board[2][1] = 2;
        board[2][2] = 2;
        boolean win = TicTacToe.winInDiagonalBS(board, 2);
        assertFalse(win);
    }

    /**
     * when the board is empty it returns false
     */
    @Test
    void winInDiagonalBSEmptyBoardSuccess() {
        int[][] board = TicTacToe.createBoard(5,5);
        boolean win = TicTacToe.winInDiagonalBS(board, 2);
        assertFalse(win);
    }

    /**
     * when a diagonal has 3 consecutive given pieces (2) it returns true
     */
    @Test
    void winInDiagonalFSSuccess() {
        int[][] board = TicTacToe.createBoard(5,5);
        board[2][2] = 2;
        board[1][3] = 2;
        board[0][4] = 2;
        boolean win = TicTacToe.winInDiagonalFS(board, 2);
        assertTrue(win);
    }

    /**
     * when none of the diagonals have 3 consecutive given pieces (2) it returns false
     */
    @Test
    void winInDiagonalFSLossSuccess() {
        int[][] board = TicTacToe.createBoard(5,5);
        board[0][0] = 2;
        board[2][1] = 2;
        board[2][2] = 2;
        boolean win = TicTacToe.winInDiagonalFS(board, 2);
        assertFalse(win);
    }

    /**
     * when the board is empty it returns false
     */
    @Test
    void winInDiagonalFSEmptyBoardSuccess() {
        int[][] board = TicTacToe.createBoard(5,5);
        boolean win = TicTacToe.winInDiagonalFS(board, 2);
        assertFalse(win);
    }

    /**
     * when the board is full
     * function should return -1 for both row and column
     */
    @Test
    void hintCantPlaySuccess() {
        int[][] board = TicTacToe.createBoard(3,3);
        board[0][0] = 1; board[0][1] = 1; board[0][2] = 1;
        board[1][0] = 1; board[1][1] = 1; board[1][2] = 1;
        board[2][0] = 1; board[2][1] = 1; board[2][2] = 1;
        int[] expectedArray = new int[] {-1, -1};
        int[] hintedArray = TicTacToe.hint(board, 1);
        assertArrayEquals(expectedArray, hintedArray);
    }

    /**
     * when player is going to win next move
     * function should remove the players piece from the last played location
     * and return the row and column of winning square
     */
    @Test
    void hintCanPlaySuccess() {
        int[][] board = TicTacToe.createBoard(3,3);
        board[0][0] = 1; board[0][1] = 1;
        int[] hintedArray = TicTacToe.hint(board, 1);
        int [] expectedRowColumn = new int[]{0, 2};
        assertArrayEquals(expectedRowColumn, hintedArray);
    }

    /**
     * function should use the n given (3) and return (6) it's factorial value
     */

    @Test
    void factorialSuccess() {
        BigInteger factorialValue = TicTacToe.factorial(3);
        BigInteger expectedValue = BigInteger.valueOf(6);
        assertEquals(expectedValue,factorialValue);
    }

    /**
     * function should use the n given (0) and return it's factorial value (1)
     */
    @Test
    void factorialValueIs0Success() {
        BigInteger factorialValue = TicTacToe.factorial(0);
        BigInteger expectedValue = BigInteger.valueOf(1);
        assertEquals(expectedValue,factorialValue);
    }

}