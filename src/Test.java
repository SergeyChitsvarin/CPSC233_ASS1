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


    public static void main(String[] args) {
        System.out.println(Test.createBoard(3, 5));
        System.out.println(Test.rowsIn(Test.createBoard(3, 5)));
        System.out.println(Test.columnsIn(Test.createBoard(3, 5)));
    }
}

