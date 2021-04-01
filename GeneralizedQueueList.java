import java.util.Iterator;
import java.util.Scanner;
import java.lang.Integer;

/**
 * @author Elin Hjelmestam
 * This file was generated 2020-09-08
 * This file was last updated 2020-09-09
 *
 * This code
 *
 * This code was written as a part of the examination of KTH course ID1020.
 */

public class GeneralizedQueueList<Item> implements Iterable<Item> {
    public int pointer = 0;
    public Node beg = null;

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class Node{
        Item item;
       Node forwards;
       int index = 0;
    }

    public boolean isEmpty(){
        return pointer == 0;
    }

    /**
     * Adds item to list at index 1
     * Increments index of elements in queue with one
     */

        public void insert(Item item) {   //storing an item and incrementing the other's index
            Node prevBeg = beg;
            beg = new Node();
            beg.item = item;
            beg.forwards = prevBeg;
            if(pointer == 0){
                beg.index = 1;
            }
            pointer++;
            increment(beg);
            printList(beg);
            System.out.println();
        }

    public void remove(int index){
        Node current = beg;
        for (int a = 1; a < index; a++){
            current = current.forwards;
        }

        current.forwards = current.forwards.forwards;
        decrement(current);
        printList(beg);
        System.out.println();
    }

    /**
     * Increments indexes of items in list
     */
    public void increment(Node cur){
        cur.index++;
        if(cur.forwards != null){
            increment(cur.forwards);
        }
    }

    /**
     * Decrements indexes of items in list
     */
    public void decrement (Node current){
        if(current.forwards != null){
            //current.index--;
            decrement(current.forwards);
        }
        current.index--;
    }

    //public GeneralizedQueueList(){
        //ngt
    //}

    void printList(Node cur){
        Node current = cur;
        while(current != null){
            System.out.printf("[%s]", current.item);
            current = current.forwards;
        }
    }

    public static void main(String[] args){
        GeneralizedQueueList<String> queue = new GeneralizedQueueList<>();

        Scanner sc = new Scanner(System.in);
        String input;

        while((input = sc.nextLine()) != null){
            if(input.equals("-")){
                System.out.println("Enter which element (index) to be removed:");
                System.out.println();
                int bla = Integer.parseInt(sc.next());
                queue.remove(bla);
                sc.nextLine();
            }
            else {
                queue.insert(input);
            }
        }

    }


}
