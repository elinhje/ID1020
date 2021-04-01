import java.util.Hashtable;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Elin Hjelmestam
 *
 * This code was generated 2020-09-27 and last updated 2020-09-28.
 *
 * The purpose of this code is to demonstrate how evenly-built the
 * hashmap() function in Java is. In the code, this is done by showing
 * how many we get collisisons when searching for the largest word in
 * the the text.
 *
 * This code was written as part of examination of KTH course ID1020.
 */

public class Uppg3 {

    public static void main(String[] args) throws FileNotFoundException{

        File file = new File("C:\\Users\\eelin\\IdeaProjects\\Lab3_uppgift3\\src\\BOK.txt");
        Scanner text = new Scanner(file);

        Scanner in = new Scanner(System.in);
        System.out.println("How many words to search among:");
        int N = in.nextInt();
        in.nextLine();

        int minlen = 3; //ord är ej kortare än så

        //initiate hashmap
        Hashtable<Integer, String> hashmap = new Hashtable<>();

        int collisions = 0;
        int lim = 0;

        /**
         * Searches
         */
        while(text.hasNext() && lim < N){
            for(String word : text.next().split("\\s+")){
                if(word.length() > 0){
                    lim++;
                }
                if(word.length() >= minlen){
                    if(hashmap.get(word.hashCode() & 0x7fffffff % N) == null){
                        hashmap.put(word.hashCode() & 0x7fffffff % N, word);
                    }
                    else{
                        collisions++;
                    }
                }
            }
        }

        int conW = 0, largestWord = 0, conNulls = 0, largestWordNull = 0;

        boolean lastWasWord = (hashmap.get(0) != null);

        for(int a = 0; a < lim; a++){
            if(hashmap.get(a) == null){
                if(lastWasWord){
                    if(largestWord < conW){
                        largestWord = conW;
                    }
                    conNulls = 0;
                }
                else{
                    conNulls++;
                }
            }
            else{
                if(lastWasWord){
                    conW++;
                }
                else{
                    if(largestWordNull < conNulls){
                        largestWordNull = conNulls;
                    }
                    conW = 0;
                }
            }
            lastWasWord = (hashmap.get(a) != null);
        }

        //results
        System.out.print("The longest word from word streak " + largestWord);
        System.out.print(" and largest word from null streak " + largestWordNull);
        System.out.println(" out of " + lim + " indexes");
        System.out.println("Number of collisions: " + collisions);
    }
}
