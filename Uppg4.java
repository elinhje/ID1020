import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Elin Hjelmestam
 *
 * This code was genereated 2020-09-27 and last updated 2020-09-28.
 *
 * The purpose of this code is to search for a word chosen by the user
 * to search for in a text. When executed, the program returns which indexes
 * the word can be found at.
 *
 * This code was written as part of examination of KTH course ID1020.
 */

public class Uppg4 {

    public Uppg4(){}

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.println("Which word to search for:");
        String N = in.nextLine();
        char word[] = N.toCharArray();

        FileReader text = new FileReader("C:\\Users\\eelin\\IdeaProjects\\Lab3_uppgift4\\src\\Bok.txt");

        int hepp;
        long index = 0;
        int a = 0;

        while((hepp = text.read()) != -1){
            if(hepp == word[a]){
                if(a == (word.length - 1)){     //if character hit
                    System.out.println("found ["+ N +"] at " + (index - (a - 1)));
                    a = 0;
                }
                else{
                    a++;
                }
            }
            else{
                a = 0;
            }
            index++;
        }

    }
}
