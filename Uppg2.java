import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Elin Hjelmestam
 *
 * This code was generated 2020-09-16 and last updated 2020-09-21.
 *
 * This code is an implemantation of insertion sort. It takes input from
 * user in an integer array and calls methos sort which for every element
 * in the array checks if thevalue at current index should be swapped with
 * value at previous index. In this code methods to sort, check if less,
 * check if sorted, swap and print is implemented. Also, a function that counts
 * the number of swaps and print execuded is added. This is done in the sort method.
 *
 * This code is a copy of Uppg1.java except for the swap counter implementation.
 *
 * This code was written as part of examination of KTH course ID1020.
 */

public class Uppg2 {

    public static void Uppg2(){}        //not instantiated

    /**
     * Arranges array in ascending order, counts
     * and prints number of swaps executed
     * @param input
     */
    public static void sort(int[] input){
        int counter = 0;
        for (int a = 1; a < input.length; a++){
            for (int b = a; b > 0 && less(input[b], input[b - 1]); b--){
                counter++;
                swap(input, b, b-1);
            }
            assert isSorted(input);
        }
        System.out.print("number of swaps made: ");
        System.out.println(counter);
    }

    /**
     * Checks if value at index b is less than value at index b - 1
     * @param bla
     * @param hepp
     * @return
     */
    public static boolean less(Comparable bla, Comparable hepp){
        return bla.compareTo(hepp) < 0;
    }

    /**
     * Swaps locs of elements at [a] and [b]
     * @param input
     * @param a
     * @param b
     */
    public static void swap(int[] input, int a, int b){
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    /**
     * Checks if array is sorted
     * @param input
     * @return
     */
    private static boolean isSorted(int[] input){            //hm kolla den här det första man gör?
        for(int a = 1; a < input.length; a++){
            if(less(input[a], input[a - 1])){
                return false;
            }
        }
        return true;
    }

    /**
     * Prints array
     * @param input
     */
    public static void print(int[] input){
        for(int a = 0; a < input.length; a++){
            System.out.print("[");
            System.out.printf(String.valueOf(input[a]));
            System.out.print("]");
        }
        System.out.println();
    }

    /**
     * Lets user decide size and contents of input array
     * and calls for sorting methods
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("size of array");
        int size = in.nextInt();

        int[] input = new int[size];
        System.out.println("elements");
        for(int a = 0; a < size; a++){
            input[a] = in.nextInt();
        }

        if(isSorted(input)){
            print(input);
            System.out.println("no swaps");
        }
        else{
            sort(input);
            print(input);
        }

    }

}
