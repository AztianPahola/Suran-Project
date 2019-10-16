package suransorting;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chase Dawson
 */
public class SuranSorting {

    /* This method sorts the text file stored in test\names.txt
       by length and then by alphabet
    */
    public static void main(String[] args) { 
        File file = new File("test\\names.txt");
        String st;
        ArrayList<String> names = new ArrayList();
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SuranSorting.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Add all the names to the array list
        try {
            while ((st = br.readLine()) != null) {
                if(st.length() > 0)
                    names.add(st.trim());
            }
        } catch (IOException ex) {
            Logger.getLogger(SuranSorting.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Sort them by length
        for (int i = 0; i < names.size(); i++) {
            for (int j = i+1; j < names.size(); j++) {
                if(names.get(i).length() > names.get(j).length()){
                    st = names.get(i);
                    names.set(i, names.get(j));
                    names.set(j, st);
                }
            }
        }
        
        // Sort them alphabetically
        for (int i = 0; i < names.size()-1; i++) {
            for (int j = i+1; j < names.size(); j++) {
                if(names.get(i).length() < names.get(j).length())
                    break;
                String sti = names.get(i);
                String stj = names.get(j);
                
                int x = 0;
                while(sti.charAt(x) == stj.charAt(x))
                    x++;
                if(sti.charAt(x) > stj.charAt(x)){
                    st = names.get(i);
                    names.set(i, names.get(j));
                    names.set(j, st);
                }
            }
        }
        
       
        //Print out sorted names
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

    }

}
