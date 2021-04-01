import java.util.Random;

/**
 * @author Elin Hjelmestam
 *
 * This code was generated 2020-09-19 and last updated 2020-09-21.
 *
 * This code aims to test the efficiency of sorting methods merge
 * and insertion. An of a size chosen by user is generated and can
 * then be ran both in merge and insertion methods. This code returns
 * the execution tume for either algorithms.
 *
 * This code was written as part of examination of KTH course ID1020.
 */

public class Uppg5Test {

    private Uppg5Test(){}

    public static Integer[] randomArray(int size){
        Integer[] input = new Integer[size];
        Random random = new Random();
        for(int a = 0; a < size; a ++){
            input[a] = (random.nextInt(100));
        }
        return input;
    }

    public static void main(String[] args){
        int numberOfTests = 10001;

        for(int a = 1; a < numberOfTests; a++){

            /**
             * Tests merge
             */
            /*
            Integer[] testArray = randomArray(a);
            long startTimeMerge = System.nanoTime();
            Uppg5Merge.sort(testArray);
            long endTimeMerge = System.nanoTime() - startTimeMerge;
            System.out.println();
            System.out.printf("Size of array %s\nTime: %s", a, endTimeMerge);
            System.out.println();
             */

            /**
             * Tests insertion
             */
            //testa insertion --> hallå kör ihop med den ovan
            Integer[] testArray = randomArray(a);
            long startTimeInsertion = System.nanoTime();
            Uppg5Insertion.sort(testArray);
            long endTimeInsertion = System.nanoTime() - startTimeInsertion;
            System.out.println();
            System.out.printf("Size of array %s\nTime: %s", a, endTimeInsertion);
            System.out.println();
        }

    }


}
