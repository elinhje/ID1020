import java.util.Scanner;

/**
 * @author Elin Hjelmestam
 * This file was generated 2020-09-05
 * This file was last updated 2020-09-09
 *
 * This code is an recursive function that reads from stdin and prints the
 * input in reversed order.
 *
 * This code was written as a part of the examination of KTH course ID1020.
 *
 */

public class Recursive{


    public static void reverseRecursive(char[] array, int length) {

        if (!(length <= 0)){
            System.out.printf("[%s]", array[--length]);
            reverseRecursive(array, length);
        }
    }

    public static void main(String[] args){

        Scanner input2 = new Scanner(System.in);
        String c = input2.next();
        char[] inputChar2 = c.toCharArray();

        reverseRecursive(inputChar2, inputChar2.length);
        }
    }






