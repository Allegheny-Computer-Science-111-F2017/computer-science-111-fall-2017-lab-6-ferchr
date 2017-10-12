package labsix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class ManipulateDna {
  /** I hate javadoc comments. */

  public static void main(String[] args) {
    // display the name of the programmer and the date
    System.out.println("Rand Ferch " + new Date());
    // declare the starting file and scanner
    File dnaInputsFile = null;
    Scanner scanner = null;
    // connect the scanner to the input file
    try {
      dnaInputsFile = new File("input/dna_inputs.txt");
      scanner = new Scanner(dnaInputsFile);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }
    // Step One: Read in and display the chosen DNA string
    String dna = scanner.nextLine();
    dna = dna.toUpperCase();
    System.out.println("\nYour string is: " + dna);
    String dnaMod = "";
    // Step Two: Compute the complement of the DNA String
    dnaMod = dna.replace('A', 't');
    dnaMod = dnaMod.replace('C', 'g');
    dnaMod = dnaMod.replace('T', 'a');
    dnaMod = dnaMod.replace('G', 'c');
    dnaMod = dnaMod.toUpperCase();
    System.out.println("The complement of your string is " + dnaMod + ".");
    // Step Three: Insert a randomly chosen DNA letter into the DNA String
    Random ran = new Random();
    String dnaPull = "ATCG";
    char insert = dnaPull.charAt(ran.nextInt(dnaPull.length()));
    int pos = ran.nextInt(dna.length());
    dnaMod = dna.substring(0, pos + 1) + insert + dna.substring(pos + 1, dna.length());
    System.out.println("Inserting random " + insert + " after position " 
        + (pos + 1) + " gives " + dnaMod + ".");
    // Step Four: Delete a DNA letter from a randomly chosen position in the DNA string
    pos = ran.nextInt(dna.length());
    dnaMod = dna.substring(0, pos) + dna.substring(pos + 1, dna.length());
    System.out.println("Deleting the letter at position " + (pos + 1) + " gives " + dnaMod + ".");
    // Step Five: Change a random position in the DNA String to a randomly chosen DNA letter
    insert = dnaPull.charAt(ran.nextInt(dnaPull.length()));
    pos = ran.nextInt(dna.length());
    dnaMod = dna.substring(0, pos) + insert + dna.substring(pos + 1, dna.length());
    System.out.println("Changing the letter at position " + (pos + 1) + " gives " + dnaMod + ".");
    // Step Six: Display a final thankyou message
    System.out.println("\nThanks for using the ManipulateDna program. Have a great day.");
  }

}
