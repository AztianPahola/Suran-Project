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
    public static void main(String[] args) {
        File file = new File("test\\names.txt");
        String newString;
        ArrayList<String> names = new ArrayList();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SuranSorting.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Add all the names to the array list
        try {
            while ((newString = br.readLine()) != null) {
                newString = newString.trim();
                // Verify the string is at least length 1, excluding white space
                // If valid, sort the values dynamically while adding them
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
                    for (int i = index + 1; i < names.size(); i++) {
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

        //Print out sorted names
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
    }

}
