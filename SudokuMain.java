import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
    private static final long serialVersionUID = 1L;  // to prevent serial warning

    // private variables
    GameBoardPanel board = new GameBoardPanel();
    SolvePanel solv = new SolvePanel();
    JButton btnNewGame = new JButton("New Game");

    // Constructor
    public SudokuMain() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER);

        // Add a button to the south to re-start the game via board.newGame()
        // ......

        // Initialize the game board to start the game

        board.newGame();
        pack();     // Pack the UI components, instead of using setSize()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
        setTitle("Sudoku");
        setVisible(true);

        //1. Create the frame.
        JFrame frame = new JFrame("Side Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Button b = new Button("   SOLVE   ");  

        // Make custom font
        Font fb = new Font(Font.SANS_SERIF,Font.BOLD, 50);

        b.setBackground(Color.WHITE);
        b.setBounds(1000,1000,1000,1000);
        b.setFont(fb);

        b.addActionListener(new ActionListener() {    
                public void actionPerformed (ActionEvent e) {    
                    iinnvokeShowSolution();
                }    
            }
        );  

        frame.add(b);
        // Size the frame.
        frame.pack();

        // Show it.
        frame.setVisible(true);

    }

    public void iinnvokeShowSolution(){
        board.invokeShowSolution();
    }

    /** The entry main() entry method */
    public static void main(String[] args) {
        // [TODO 1] Check "Swing program template" on how to run
        //  the constructor of "SudokuMain"
        new SudokuMain();

    }

}