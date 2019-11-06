package suransorting;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 * @author Chase Dawson
 */
public class SuranSorting {

    /* This application takes the strings contained in test/names.txt and adds 
     * them to an arraylist while dynamically sorting them by length, then by
     * alphabet
     *
     * 
     */
    private static ArrayList<String> names = new ArrayList();

    public static void main(String[] args) {
        File inputFile = new File("Unsorted1.txt");
        File outputFile = new File("SortAttempt1.txt");
        String input;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(inputFile));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SuranSorting.class.getName()).log(Level.SEVERE, null, ex);
        }

        // If argument ascending or descending is given with program call
        if ((args.length > 0) && (args[0].equalsIgnoreCase("A") || args[0].equalsIgnoreCase("D"))) {
            input = args[0];
        } else { // Retrieve argument for ascending or descending from user in the console
            input = getUserInput();
        }

        String newString;
        // Add all the names to the array list
        try {
            while ((newString = br.readLine()) != null) {
                newString = newString.trim();
                // Verify the string is at least length 1, excluding white space
                // If valid, puts the value in the appropriate spot
                int index = 0;
                if (newString.length() > 0) {
                    // Sort them by length
                    for (int i = 0; i < names.size(); i++) {
                        // Determine which string should be longer, depending on
                        // Whether we are ascending or descending
                        if (input.equalsIgnoreCase("A")) {
                            if (newString.length() > names.get(i).length()) {
                                index++;
                            } else {
                                break;
                            }
                        } else {
                            if (newString.length() < names.get(i).length()) {
                                index++;
                            } else {
                                break;
                            }
                        }

                    }
                    // Sort them alphabetically
                    for (int i = index; i < names.size(); i++) {
                        if (input.equalsIgnoreCase("A")) {
                            if (newString.length() < names.get(i).length()) {
                                break;
                            }
                        } else {
                            if (newString.length() > names.get(i).length()) {
                                break;
                            }
                        }
                        String compareString = names.get(i);
                        int charIndex = 0;

                        while (newString.charAt(charIndex) == compareString.charAt(charIndex)) {
                            charIndex++;
                        }
                        if (newString.charAt(charIndex) > compareString.charAt(charIndex)) {
                            index++;
                        }
                    }
                    names.add(index, newString);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SuranSorting.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //Write the sorted list to the output file
            writeToFile(outputFile);
        } catch (IOException ex) {
            Logger.getLogger(SuranSorting.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 'A' to sort the strings ascending by length or\n"
                + "enter 'D' to sort them descending by length.");
        String response = scanner.next();

        while (!response.equalsIgnoreCase("A") && !response.equalsIgnoreCase("D")) {
            System.out.println("Please enter 'A' to sort the strings ascending by length or\n"
                    + " enter 'D' to sort them descending by length.");
            response = scanner.next();
        }
        scanner.close();
        return response;
    }

    private static void writeToFile(File output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        for (int i = 0; i < names.size() - 1; i++) {
            // Write to file
            writer.write(names.get(i) + "\n");
            // Writes to terminal
            System.out.println(names.get(i));
        }
        writer.write(names.get(names.size() - 1));
        System.out.println(names.get(names.size() - 1));
        System.out.println("\nThis sorted list is stored in SortAttempt1");

        writer.close();
    }

}
