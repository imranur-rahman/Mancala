package source2;

import javax.swing.*;	//needed for graphics
import java.awt.*;
import java.awt.event.*;  // needed for ActionEvent

/*
 *
 * @author PID
 * @author PID
 * The object of this lab is to implement the Mancala Game. Read over the
 * directions to understand Mancala before you begin.
 * http://www.centralconnector.com/GAMES/mancala.html - rules
 * http://www.pressmantoy.com/instructions/instruct_mancala.html - rules
 * http://www.mathsyear2000.org/museum/floor2/gallery6/mancala/ - applet
 *
 */
public class Mancala extends JApplet {
        // Entry for graphics application
        public static void main(String [] args) {
                JFrame frame = new JFrame("Mancala Game");

                //Add components (buttons, panels) to the container of this window
                Container c = frame.getContentPane();
                Lab13Init.init(c);

                // pack up and show the window, don't touch this part
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                frame.pack();
                frame.show();
        }
        // Check whether one side has won
        // The game is over when the opponent has no stones in their bowls
        // won = true: check whether your partner has won
        // won = false: check whether you have won
        static boolean isDone(Board b, boolean won) {
                boolean done = true;
                int offset = ( won ? b.size / 2 : 0 );
                for (int i = 0; i < b.size / 2 - 1; i++)
                        if (b.boardArray[offset+i] > 0)
                                done = false;
                return done;
        }
}

class Lab13Init {
        static Board board = new Board();
        static JLabel labelBside = new JLabel("Lab Partner (NAME)");
        static JLabel labelAside = new JLabel("Your Side (NAME)");
        static JLabel labelGameStatus = new JLabel("Game status: To move, click on a bin");

        /* the bins are laid out as follows:
           12	11	10	9	8	7
        13							6
       0	1	2	3	4	5
        */
        static JButton bins[] = {
                new JButton("A6     "),
                new JButton("A5     "),
                new JButton("A4     "),
                new JButton("A3     "),
                new JButton("A2     "),
                new JButton("A1     "),
                new JButton("A's mancala     "),
                new JButton("B6     "),
                new JButton("B5     "),
                new JButton("B4     "),
                new JButton("B3     "),
                new JButton("B2     "),
                new JButton("B1     "),
                new JButton("B's mancala     ")};

        static String buttonTexts[] = {
                "A6","A5", "A4", "A3", "A2", "A1",
                "A's mancala",
                "B6","B5", "B4", "B3", "B2", "B1",
                "B's mancala"};

        static void init(Container c){
                Container topLine = new Container(); // Create a container
                topLine.setLayout( new FlowLayout() ); // Layout from left to right
                for(int i=12; i>=7; i--) topLine.add(Lab13Init.bins[i]);

                Container bottomLine = new Container();
                // Layout from left to right
                bottomLine.setLayout( new FlowLayout() );
                for(int i=0; i<=5; i++) bottomLine.add(Lab13Init.bins[i]);

                Container twoLines = new Container();
                // layout from top to bottom
                twoLines.setLayout( new BoxLayout(twoLines, BoxLayout.Y_AXIS) );
                twoLines.add(topLine);
                twoLines.add(bottomLine);

                // Conbine the two lines with the mancalas on both sides
                Container binsContainer = new Container();	// Create another container
                binsContainer.setLayout(new FlowLayout());	// Layout from left to right
                binsContainer.add(Lab13Init.bins[13]);	// On left: mancala for B
                binsContainer.add(twoLines);	// then the two lines of bins
                binsContainer.add(Lab13Init.bins[6]);		// and mancala for A on right

                // Now, add some lables on top and bottom of the board
                c.setLayout( new BoxLayout(c, BoxLayout.Y_AXIS) ); // layout from top to bottom
                c.add(labelBside);		// labelBside are on top
                c.add(binsContainer);	// below is the board
                c.add(labelAside);		// then labelAside
                c.add(labelGameStatus);	// and labelGameStatus on the bottom

                // define the actions for the buttons
                MyActionListener myaction = new MyActionListener();
                bins[0].addActionListener(myaction); //action for button "A6"
        }
}

class MyActionListener implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
                if ( e.getSource() instanceof JButton ) {
                        JButton b = (JButton)e.getSource();

                        // if the button "A6" is pressed
                        if(b == Lab13Init.bins[0]){
                                Lab13Init.board.print(/*PARAMETER NEEDED*/);
                        }
                }
        }
}

class Board {
        int size;
        int [] boardArray;
        int myHome;		//the index of A's mancala
        int hisHome;	//the index of B's mancala

        Board() {
                this.size = 14;
                this.boardArray = new int[size];
                for (int i = 0; i < size; i++)
                        this.boardArray[i] = 4;
                this.myHome = 13;
                this.hisHome = 6;
                this.boardArray[this.myHome] = 0;
                this.boardArray[this.hisHome] = 0;
        }

        void print(/*PARAMETER NEEDED*/) {
                Lab13Init.bins[0].setText(Lab13Init.buttonTexts[0]+ ": " + boardArray[0]);
        }


        ////////////////////////////////////////
        /* METHODS NEEDED TO IMPLEMENT SOWING */
        ////////////////////////////////////////


}