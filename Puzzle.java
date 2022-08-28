/**
 * The Sudoku number puzzle to be solved
 */
public class Puzzle {
    // All variables have package access
    // The numbers on the puzzle
    int[][] numbers = new int[GameBoardPanel.GRID_SIZE][GameBoardPanel.GRID_SIZE];
    // The clues - isGiven (no need to guess) or need to guess
    boolean[][] isGiven = new boolean[GameBoardPanel.GRID_SIZE][GameBoardPanel.GRID_SIZE];

    // Constructor
    public Puzzle() {
        super();
    }

    // Generate a new puzzle given the number of cells to be guessed, which can be
    // used
    // to control the difficulty level.
    // This method shall set (or update) the arrays numbers and isGiven
    public void newPuzzle(int cellsToGuess) {
        // I hardcode a puzzle here for illustration and testing.
        Genrate_Sudoku GN_Object = new Genrate_Sudoku(9, 10);
        int[][] hardcodedNumbers = GN_Object.returnSudoku();
        int[][] hardcodedNumbers2 = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                hardcodedNumbers2[i][j] = hardcodedNumbers[i][j];
            }
        }

        // System.out.println(hardcodedNumbers.toString());
        Sudoku_Solver SS_Object = new Sudoku_Solver();
        SS_Object.solveSudoku(hardcodedNumbers, 9);

        // Copy from hardcodedNumbers into the array "numbers"
        for (int row = 0; row < GameBoardPanel.GRID_SIZE; ++row) {
            for (int col = 0; col < GameBoardPanel.GRID_SIZE; ++col) {
                numbers[row][col] = hardcodedNumbers[row][col];
                System.out.print(numbers[row][col]);
            }
            System.out.println();
        }

        // Need to use input parameter cellsToGuess!
        // Hardcoded for testing, only 2 cells of "8" is NOT GIVEN
        boolean[][] hardcodedIsGiven = new boolean[9][9];
        for (int row = 0; row < GameBoardPanel.GRID_SIZE; ++row) {
            for (int col = 0; col < GameBoardPanel.GRID_SIZE; ++col) {
                hardcodedIsGiven[row][col] = hardcodedNumbers2[row][col] != 0;
                System.out.print(hardcodedNumbers2[row][col] + " " + hardcodedIsGiven[row][col]);
            }
            System.out.println();
        }

        // Copy from hardcodedIsGiven into array "isGiven"
        for (int row = 0; row < GameBoardPanel.GRID_SIZE; ++row) {
            for (int col = 0; col < GameBoardPanel.GRID_SIZE; ++col) {
                isGiven[row][col] = hardcodedIsGiven[row][col];
            }
        }
    }
}