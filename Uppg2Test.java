import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Elin Hjelmestam
 *
 * This code was generated 2020-09-25 and last updated 2020-09-28.
 *
 * The purpose of this code is to test and compare the time efficiency
 * of Binary Search Symbol Table and Binary Search Tree. This test class
 * is built on the FrequencyCounter from the book Algorithms by Kevin Wayne
 * and Robert Sedgewick.
 *
 * This code was written as part of examination of KTH course ID1020.
 */

public class Uppg2Test {

    private static int  N = 0;
    private  static int minlen = 3; //ord är ej kortare än så

    public static void main(String[] args) throws FileNotFoundException
    {

        File file = new File("C:\\Users\\eelin\\IdeaProjects\\Lab3_uppgift2\\src\\Boken.txt");
        Scanner text = new Scanner(file);

        Scanner stdin = new Scanner(System.in);
        System.out.println("How many words to search among:");
        N = stdin.nextInt();
        stdin.nextLine();

        Uppg2BinarySearchST<String, Integer> myBSST = new Uppg2BinarySearchST<>();
        Uppg2BinarySearchTree<String, Integer> myBST = new Uppg2BinarySearchTree<>();

        String resultBSST = null;
        String resultBST = null;

        long timeBSST = 0;
        long timeBST = 0;

        /**
         * Test Binary Search ST
         */
        timeBSST = System.nanoTime();
        resultBSST = runBSST(myBSST, text);
        timeBSST = System.nanoTime() - timeBSST;

        text = new Scanner(file);

        /**
         * Test Binary Search Tree
         */
        timeBST = System.nanoTime();
        resultBST = runBST(myBST, text);
        timeBST = System.nanoTime() - timeBST;

        System.out.println("Results Binary Search ST:\nThe word ["+resultBSST+"] was found "+myBSST.get(resultBSST)+ " times");
        System.out.println("execution time: "+timeBSST+" nanoseconds\n");
        System.out.println("Results Binary Search Tree:\nThe word ["+resultBST+"] was found "+myBST.get(resultBST)+ " times");
        System.out.println("execution time: "+timeBST+" nanoseconds\n");

    }

    static String runBST(Uppg2BinarySearchTree<String, Integer> BST, Scanner text) {
        //adding elements to BST
        int lim = 0;
        while (text.hasNext() && lim < N)
        {
            for (String word : text.next().split("\\s+")) //to split words to array
            {
                if(word.length() > 0) //avoid empty elements
                    lim++;
                if(word.length() >= minlen)
                    if(!BST.contains(word))
                        BST.put(word, 1);
                    else
                        BST.put(word, BST.get(word) +1);
            }
        }

        //finding most common word
        String max = "temp";
        BST.put(max, 0);
        Iterable<String> list = BST.keys();
        for (String word : list)
            if (word != null && BST.get(word) > BST.get(max))
                max = word;
        return max;
    }

    static String runBSST(Uppg2BinarySearchST<String, Integer> BSST, Scanner text) {
        //adding elements to BSST
        int lim = 0;
        while (text.hasNext() && lim < N)
        {
            for (String word : text.next().split("\\s+")) //to split words to array
            {
                if(word.length() > 0) //avoid empty elements
                    lim++;
                if(word.length() >= minlen)
                    if(!BSST.contains(word))
                        BSST.put(word, 1);
                    else
                        BSST.put(word, BSST.get(word) +1);
            }
        }

        //finding most common word
        String max = "temp";
        BSST.put(max, 0);
        Iterable<String> list = BSST.keys(BSST.min(), BSST.max());
        for (String word : list)
            if (word != null)
                if (BSST.get(word) > BSST.get(max))
                    max = word;
        return max;
    }
}
