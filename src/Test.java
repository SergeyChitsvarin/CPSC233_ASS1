public class Test {


    public static int[][] createBoard(int rows, int columns) {

        int[][] board = new int[rows][columns];

        return board;
    }

    public static int rowsIn(int[][] array){
        int rowCount = array.length;
        return rowCount;
    }

    public static int columnsIn(int[][] array){
        int amountOfOColumns = array[0].length;
        return amountOfOColumns;
    }

    public static boolean canPlay(int [][] board, int row, int column){
        return (board[row][column] == 0);

    }
    public static void play(int[][] board, int row, int column, int piece){
        board[row][column] = piece;
    }

    public static boolean full(int[][] board){
        int rowCount = Test.rowsIn(board);
        int columnCount = Test.columnsIn(board);
        for(int row = 0; row < rowCount; row++){
            for(int column = 0; column < columnCount; column++){
                if (board[row][column] == 0){
                    return false;
                }

            }
        }
        return true;
    }

    public static boolean winInRow(int[][] board, int row, int piece){
        int columnCount = Test.columnsIn(board);
        for(int column = 0; column < columnCount; column++){
            if (board[row][column] == piece){
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(Test.createBoard(3, 5));
        //System.out.println(Test.rowsIn(Test.createBoard(3, 5)));
        //System.out.println(Test.columnsIn(Test.createBoard(3, 5)));
        int [][] fakeBoard = new int[3][3];
        fakeBoard[1][0] = 1;
        fakeBoard[1][1] = 1;
        fakeBoard[1][2] = 1;
        boolean bool = winInRow(fakeBoard, 1, 1);
        //boolean bool = Test.full(fakeBoard);
        System.out.println(bool);
    }
}

