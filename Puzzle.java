/**
 * The Sudoku number puzzle to be solved
 */
public class Puzzle {
    // All variables have package access
    // The numbers on the puzzle
    int[][] numbers = new int[GameBoardPanel.GRID_SIZE][GameBoardPanel.GRID_SIZE];
    // The clues - isGiven (no need to guess) or need to guess
    boolean[][] isGiven = new boolean[GameBoardPanel.GRID_SIZE][GameBoardPanel.GRID_SIZE];
    private int[][] onedArray;

    // Constructor
    public Puzzle() {
        super();
    }
    public void showSolution(){
        for (int row = 0; row < GameBoardPanel.GRID_SIZE; ++row) {
            for (int col = 0; col < GameBoardPanel.GRID_SIZE; ++col) {
                //numbers[row][col] = onedArray[row][col];
                System.out.print(onedArray[row][col]+" ");
            }
            System.out.println();
        }
    }
    // Generate a new puzzle given the number of cells to be guessed, which can be
    // used
    // to control the difficulty level.
    // This method shall set (or update) the arrays numbers and isGiven
    public void newPuzzle(int cellsToGuess) {
        // I hardcode a puzzle here for illustration and testing.
        Genrate_Sudoku GN_Object = new Genrate_Sudoku(9, 10);
        onedArray = GN_Object.returnSudoku();
        int[][] onedArray2 = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                onedArray2[i][j] = onedArray[i][j];
            }
        }

        // System.out.println(onedArray.toString());
        Sudoku_Solver SS_Object = new Sudoku_Solver();
        SS_Object.solveSudoku(onedArray, 9);

        // Copy from onedArray into the array "numbers"
        for (int row = 0; row < GameBoardPanel.GRID_SIZE; ++row) {
            for (int col = 0; col < GameBoardPanel.GRID_SIZE; ++col) {
                numbers[row][col] = onedArray[row][col];
                //System.out.print(numbers[row][col]+" ");
            }
            //System.out.println();
        }

        boolean[][] hardcodedIsGiven = new boolean[9][9];
        for (int row = 0; row < GameBoardPanel.GRID_SIZE; ++row) {
            for (int col = 0; col < GameBoardPanel.GRID_SIZE; ++col) {
                hardcodedIsGiven[row][col] = onedArray2[row][col] != 0;
                //System.out.print(onedArray2[row][col] + " " + hardcodedIsGiven[row][col]);
            }
            //System.out.println();
        }

        // Copy from hardcodedIsGiven into array "isGiven"
        for (int row = 0; row < GameBoardPanel.GRID_SIZE; ++row) {
            for (int col = 0; col < GameBoardPanel.GRID_SIZE; ++col) {
                isGiven[row][col] = hardcodedIsGiven[row][col];
            }
        }
    }
}