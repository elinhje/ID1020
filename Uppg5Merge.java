import java.util.Scanner;

/**
 * @author Elin Hjelmestam
 *
 * This code is an implementation of mergesort from the book Algorithms,
 * fourth edition by Robert Sedgewick and Kevin Wayne.
 */

public class Uppg5Merge {

    private Uppg5Merge() { }


    public static void sort(Comparable[] input) {
        Comparable[] aux = new Comparable[input.length];
        sort(input, aux, 0, input.length-1);
        assert isSorted(input);
    }

    private static void sort(Comparable[] input, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(input, aux, lo, mid);
        sort(input, aux, mid + 1, hi);
        merge(input, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] input, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(input, lo, mid);
        assert isSorted(input, mid+1, hi);

        for (int a = lo; a <= hi; a++) {
            aux[a] = input[a];
        }

        int i = lo, j = mid+1;
        for (int a = lo; a <= hi; a++) {
            if      (i > mid)              input[a] = aux[j++];
            else if (j > hi)               input[a] = aux[i++];
            else if (less(aux[j], aux[i])) input[a] = aux[j++];
            else                           input[a] = aux[i++];
        }

        assert isSorted(input, lo, hi);
    }

    private static boolean less(Comparable bla, Comparable hepp) {
        return bla.compareTo(hepp) < 0;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void print(Comparable[] input){
        for(int a = 0; a < input.length; a++){
            System.out.print("[");
            System.out.printf(String.valueOf(input[a]));
            System.out.print("]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("size of array");
        int size = in.nextInt();

        Integer[] input = new Integer[size];
        System.out.println("elements");
        for(int a = 0; a < size; a++){
            input[a] = in.nextInt();
        }

        sort(input);
        print(input);
    }
}
