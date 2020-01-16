package complexityanalizer;

/
//  "in this program user will be asked to enter a valid file to check its complexity \n"
// "by determing the range of word within a character input the user enters \n"
// "then the complexity percentage of the file is displayed \n"
// "the output is later appended to a different file to saves all the information \n"
// "entered and recieved 
// importing all packages
import java.text.DecimalFormat;
import java.awt.HeadlessException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ComplexityAnalizer {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome to file complexity calculator \n"
                + "in this program user will be asked to enter a valid file to check its complexity \n"
                + "by determing the range of word within a character input the user enters \n"
                + "then the complexity percentage of the file is displayed \n"
                + "the output is later appended to a different file to saves all the information \n"
                + "entered and recieved enjoy!!");
// do while loop if user wants to play again

        do {
            DecimalFormat form = new DecimalFormat("0.00"); // format doubles to two decimal places
            boolean proceed = false; //  boolean that checks for user character count input
            boolean corruptFile = false; // boolean that checks if file exist
            int range; // variable for user character input
            double total = 0.0; // variable that holds total words in a file
            double lengthCounter = 0.0; // variable that holds the length of each token
            String sentence = ""; // varable that holds eeach word
            String txtFile = ""; // variable for user file input
            String characterCount = ""; // variable that for user string charater input
            int charCount = 0; // integer holder of charachter count input
            double complexity = 0.0; // holds the complexity percentage

            try {

                txtFile = JOptionPane.showInputDialog("Enter text file"); // asks user for file input
                corruptFile = true; // if file input is correct 

                Scanner file = new Scanner(new File(txtFile)); // new scanner file for file input

                while (file.hasNext()) { // checks if there is content in file
                    sentence = file.next();  // adds each word to the sentence variable

                    while (!proceed) { // while checks whether input is valid 
                        try {
                            characterCount = JOptionPane.showInputDialog("Enter range"); // enter a range of character count
                            charCount = Integer.parseInt(characterCount); // changes string input to a string
                            proceed = true; // if input is valid changes to true and exits while loop
                        } catch (NumberFormatException e) { // exception handling if input is not a number
                            JOptionPane.showMessageDialog(null, "Please do not enter a string");
                        }
                    }

                    if (charCount <= sentence.length()) { // compares the range of character with each word in the file
                        lengthCounter++; // increments each time conditon above is true
                    } else { // else everything remains the same
                        total = total;
                        lengthCounter = lengthCounter;

                    }
                    total++; // total words in the file increments
                }
                complexity = lengthCounter / total * 100; // gets total words withing given range and divides over total word in file

                // displays message
                JOptionPane.showMessageDialog(null, " from " + txtFile + "\n with a character count of " + charCount + "\n the complexity percentage is " + form.format(complexity) + "%");

                file.close(); // close file

            } catch (FileNotFoundException fnfe) { // exception if file is not found
                JOptionPane.showMessageDialog(null, "Document not found!!");
            }

            try { // checks if file exist

                FileOutputStream complex = new FileOutputStream("complexFolder.txt", true); // appends input from above to file

                PrintWriter pw = new PrintWriter(complex); // printing object declared and initialized
                pw.print(" This was the text file you entered : "); //entering data into file above
                pw.println(txtFile);
                pw.print(" Your character Count was : ");
                pw.println(charCount);
                pw.print("The complexity of this file was ");
                pw.println(form.format(complexity) + "%");

                pw.close(); // close file

            } catch (FileNotFoundException fnfe) {
                JOptionPane.showMessageDialog(null, "file not found!! Try Again!!!"); // exception if file does not exist
            }

        } while (JOptionPane.showConfirmDialog(null, " would you like to continue") == 0); // ask for user to continue

        JOptionPane.showMessageDialog(null, " Thank you for using my complexity calculator application"); // closing message
    }

}
