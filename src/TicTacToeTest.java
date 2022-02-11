import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertEquals(true, open);
    }

    /**
     * it returns false if cell is closed
     */
    @Test
    void canPlayClosedSuccess() {
        int[][] board = TicTacToe.createBoard(5,3);
        board[0][0] = 1;
        boolean open = TicTacToe.canPlay(board, 0,0);
        assertEquals(false, open);
    }

    /**
     * checks if the function places piece 1 on empty square
     */
    @Test
    void playPiece1Success() {
        int[][] board = TicTacToe.createBoard(5,4);
        TicTacToe.play(board, 2,2,1);
        int actual = board[2][2];
        assertEquals(1, actual);
    }

    /**
     * checks if the function places piece 2 on empty square
     */
    @Test
    void playPiece2Success() {
        int[][] board = TicTacToe.createBoard(5,3);
        TicTacToe.play(board, 0,0,2);
        int actual = board[0][0];
        assertEquals(2, actual);
    }

    /**
     * returns true if the board is full
     */
    @Test
    void fullSuccess() {
        int[][] board = TicTacToe.createBoard(3,3);
        board[0][0] = 1; board[0][1] = 1; board[0][2] = 1;
        board[1][0] = 1; board[1][1] = 1; board[1][2] = 1;
        board[2][0] = 1; board[2][1] = 1; board[2][2] = 1;
        boolean actual = TicTacToe.full(board);
        assertEquals(true, actual);

    }

    @Test
    void winInRow() {
    }

    @Test
    void winInColumn() {
    }

    @Test
    void winInDiagonalBS() {
    }

    @Test
    void winInDiagonalFS() {
    }

    @Test
    void hint() {
    }

    @Test
    void factorial() {
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCreateBoard() {
    }

    @Test
    void testRowsIn() {
    }

    @Test
    void testColumnsIn() {
    }

    @Test
    void testCanPlay() {
    }

    @Test
    void testPlay() {
    }

    @Test
    void testFull() {
    }

    @Test
    void testWinInRow() {
    }

    @Test
    void testWinInColumn() {
    }

    @Test
    void checkSingleDiagonalBS() {
    }

    @Test
    void testWinInDiagonalBS() {
    }

    @Test
    void checkSingleDiagonalFS() {
    }

    @Test
    void testWinInDiagonalFS() {
    }

    @Test
    void won() {
    }

    @Test
    void testHint() {
    }

    @Test
    void testFactorial() {
    }
}