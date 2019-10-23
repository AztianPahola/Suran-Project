package suransorting;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chase Dawson
 */
public class SuranSorting {

    /* This application takes the strings contained in test/names.txt and adds 
       them to an arraylist while dynamically sorting them by length, then by
       alphabet
     */
    private static ArrayList<String> names = new ArrayList();

    public static void main(String[] args) {
        File inputFile = new File("Unsorted1.txt");
        File outputFile = new File("SortAttempt1.txt");
        //File file = new File("G:\\Semester 5\\CSC 499\\Homework 1\\SuranSorting\\test\\names.txt");
        String newString;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(inputFile));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SuranSorting.class.getName()).log(Level.SEVERE, null, ex);
        }

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
                        if (newString.length() > names.get(i).length()) {
                            index++;
                        } else {
                            break;
                        }
                    }
                    // Sort them alphabetically
                    for (int i = index; i < names.size(); i++) {
                        if (newString.length() < names.get(i).length()) {
                            break;
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

    private static void writeToFile(File output) throws IOException {
        String str = "Hello";
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        for (int i = 0; i < names.size()-1; i++) {
            writer.write(names.get(i) + "\n");
        }
        writer.write(names.get(names.size()-1));

        writer.close();
    }

}
