import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Uppg1{

    public Uppg1() throws IOException{}

    public static void main(String[] args) {
        Scanner input = new Scanner(file);

        BufferedWriter out = new BufferedWriter(new FileWriter(outPutFile));

        while(input.hasNextLine()) {
            String strIn = input.nextLine();
            String[] currentWord = strIn.split(" ");

            for (int i = 0; i < currentWord.length; i++)
                for(int j = 0; j < currentWord[i].length(); j++){
                    if (Character.isLetter(currentWord[i].charAt(j))) {
                        out.write(currentWord[i].charAt(j));
                    } if (j == currentWord[i].length() - 1) {
                        out.write(" ");
                    } else {
                        out.write("");
                    }
                }
        }
        out.close();
        input.close();
    }

    /*
    public static void filter(File file, File outPutFile) throws IOException {

        //Scanner input = new Scanner(file);

        BufferedWriter out = new BufferedWriter(new FileWriter(outPutFile));

        /*
        while(input.hasNextLine()) {
            String strIn = input.nextLine();
            String[] currentWord = strIn.split(" ");

            for (int i = 0; i < currentWord.length; i++)
                for(int j = 0; j < currentWord[i].length(); j++){
                    if (Character.isLetter(currentWord[i].charAt(j))) {
                        out.write(currentWord[i].charAt(j));
                    } if (j == currentWord[i].length() - 1) {
                        out.write(" ");
                    } else {
                        out.write("");
                    }
                }
        }

        out.close();
        input.close();
    }
    */
}
