//public class Test {
//
//
//    public static int[][] createBoard(int rows, int columns) {
//
//        int[][] board = new int[rows][columns];
//
//        return board;
//    }
//
//    public static int rowsIn(int[][] array){
//        int rowCount = array.length;
//        return rowCount;
//    }
//
//    public static int columnsIn(int[][] array){
//        int amountOfOColumns = array[0].length;
//        return amountOfOColumns;
//    }
//
//    public static boolean canPlay(int [][] board, int row, int column){
//        return (board[row][column] == 0);
//
//    }
//    public static void play(int[][] board, int row, int column, int piece){
//        board[row][column] = piece;
//    }
//
//    public static boolean full(int[][] board){
//        int rowCount = Test.rowsIn(board);
//        int columnCount = Test.columnsIn(board);
//        for(int row = 0; row < rowCount; row++){
//            for(int column = 0; column < columnCount; column++){
//                if (board[row][column] == 0){
//                    return false;
//                }
//
//            }
//        }
//        return true;
//    }
//
//    public static boolean winInRow(int[][] board, int row, int piece) {
//        int columnCount = Test.columnsIn(board);
//        int conseqCount = 0;
//        for (int column = 0; column < columnCount; column++) {
//            if (board[row][column] == piece) {
//                conseqCount++;
//            }
//            else {
//                conseqCount = 0;
//            }
//            if (conseqCount == 3) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static boolean winInColumn(int[][] board, int column, int piece) {
//        int rowCount = Test.rowsIn(board);
//        int conseqCount = 0;
//        for (int row = 0; column < rowCount; row++) {
//            if (board[row][column] == piece) {
//                conseqCount++;
//            }
//            else {
//                conseqCount = 0;
//            }
//            if (conseqCount == 3) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static boolean checkSingleDiagonalBS(int[][] board, int piece, int currentRowIndex, int currentColumnIndex){
//        int lastColumnIndex = columnsIn(board)-1;
//        int lastRowIndex = rowsIn(board)-1;
//        int conseqCount = 0;
//
//        while (currentRowIndex <= lastRowIndex && currentColumnIndex <= lastColumnIndex){
//            if (board[currentRowIndex][currentColumnIndex] == piece) {
//                conseqCount++;
//            }
//            else {
//                conseqCount = 0;
//            }
//            if (conseqCount == 3) {
//                return true;
//            }
//            currentColumnIndex++;
//            currentRowIndex++;
//        }
//        return false;
//    }
//    public static boolean winInDiagonalBS(int[][] board, int piece){
//        int lastColumnIndex = columnsIn(board)-1;
//        int lastRowIndex = rowsIn(board)-1;
//        // check top diagonals
//        int currentRowIndex = 0;
//        for (int currentColumnIndex = 0; currentColumnIndex <= lastColumnIndex; currentColumnIndex++){
//            boolean won = Test.checkSingleDiagonalBS(board, piece, currentRowIndex, currentColumnIndex);
//            if (won){
//                return true;
//            }
//        }
//        int currentColumnIndex = 0;
//        for (currentRowIndex = 1; currentRowIndex <= lastRowIndex; currentRowIndex++) {
//            boolean won = Test.checkSingleDiagonalBS(board, piece, currentRowIndex, currentColumnIndex);
//            if (won){
//                return true;
//            }
//        }
//
//        return false;
//    }
//    public static boolean checkSingleDiagonalFS(int[][] board, int piece, int currentRowIndex, int currentColumnIndex){
//        int lastColumnIndex = columnsIn(board)-1;
//        int lastRowIndex = rowsIn(board)-1;
//        int conseqCount = 0;
//        while ((currentRowIndex <= lastRowIndex) && (0 <= currentColumnIndex)){
//            if (board[currentRowIndex][currentColumnIndex] == piece){
//                conseqCount++;
//            }
//            else {
//                conseqCount = 0;
//            }
//            if (conseqCount == 3) {
//                return true;
//            }
//            currentColumnIndex--;
//            currentRowIndex++;
//
//        }
//        return false;
//    }
//
//
//    public static boolean winInDiagonalFS(int[][] board, int piece){
//        int lastColumnIndex = columnsIn(board)-1;
//        int lastRowIndex = rowsIn(board)-1;
//        // check top diagonals
//
//        for (int currentColumnIndex = lastColumnIndex; currentColumnIndex >= 0; currentColumnIndex--){
//            boolean won = Test.checkSingleDiagonalFS(board, piece, 0, currentColumnIndex);
//            if (won){
//                return true;
//            }
//        }
//
//
//        int currentColumnIndex = lastColumnIndex;
//        for (int currentRowIndex = 1; currentRowIndex <= lastRowIndex; currentRowIndex++) {
//            boolean won = Test.checkSingleDiagonalFS(board, piece, currentRowIndex, currentColumnIndex);
//            if (won){
//                return true;
//            }
//        }
//
//        return false;
//    }
//    static public boolean won(int[][] board, int row, int column, int piece){
//        if (winInRow(board, row, piece)){
//            return true;
//        }
//        if (winInColumn(board, column, piece)){
//            return true;
//        }
//        if (winInDiagonalFS(board, piece)){
//            return true;
//        }
//        if (winInDiagonalBS(board, piece)){
//            return true;
//        }
//        return false;
//    }
//    static public int[] hint(int[][] board, int piece){
//        int rowCount = Test.rowsIn(board);
//        int columnCount = Test.columnsIn(board);
//        for(int row = 0; row < rowCount; row++){
//            for(int column = 0; column < columnCount; column++)
//                if (Test.canPlay(board, row, column)){
//                    Test.play(board,row, column, piece);
//                    if (Test.won(board, row, column, piece)){
//                        board[row][column] = 0;
//                        int [] rowColumnOfHint = {row, column};
//                        return rowColumnOfHint;
//                    }
//                    else{
//                        board[row][column] = 0;
//                    }
//                }
//        }
//        int row = -1;
//        int column = -1;
//        int [] defaultReturn = {row, column};
//        return defaultReturn;
//    }
//
//
//
//    public static void main(String[] args) {
//        //System.out.println(Test.createBoard(3, 5));
//        //System.out.println(Test.rowsIn(Test.createBoard(3, 5)));
//        //System.out.println(Test.columnsIn(Test.createBoard(3, 5)));
//        int [][] fakeBoard = new int[5][3];
//        fakeBoard[2][2] = 1;
//        fakeBoard[3][1] = 1;
//        fakeBoard[4][0] = 1;
//        //fakeBoard[1][1] = 1;
//        //boolean bool = winInRow(fakeBoard, 2, 1);
//        boolean bool  = winInDiagonalFS(fakeBoard, 1);
//        //boolean bool = Test.full(fakeBoard);
//        System.out.println(bool);
//    }
//}
//
