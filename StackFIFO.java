import java.util.Scanner;

/**
 * @author Elin Hjelmestam
 * This file was generated 2020-09-07
 * This file was last updated 2020-09-09
 *
 *
 * This code is a copy of the CircularDoublyLinkedList but modified so that the functions
 * in this code includes push end and pop beginning of stack. Part from that, evereything
 * is the same. The FIFO stack is printed each time an element is added or removed.
 *
 * This code was written as a part of the examination of KTH course ID1020.
 */

public class StackFIFO<Item> {

    private int stackPointer = 0;
    private Node beg;
    private Node end;

    public class Node{
        Item item;
        Node forwards;
        Node backwards;
    }

    /**
     * Checks if empty.
     */
    public boolean isEmpty(){
        return (stackPointer == 0);
    }

    /**
     * Prints content of stack.
     */
    public void printContent(Node current){
        System.out.print("[");
        System.out.print(current.item);
        System.out.print("]");
        if(current.forwards != end){
            printContent(current.forwards);
        }
    }

    /**
     * Pushes item to end of stack.
     * Sets previous last item second last.
     */
    public void push(Item item){
        Node prevBeg = new Node();
        if (!isEmpty()) {
            prevBeg = beg;
        }
        beg = new Node();
        beg.item = item;
        if(!isEmpty()){
            beg.backwards = prevBeg;
            beg.forwards = end;
            prevBeg.forwards = beg;
            end.backwards = beg;
        }
        else{
            end = beg;
            end.forwards = end;
        }
        stackPointer++;

        printContent(end);
    }

    /**
     * Pops the first item in stack.
     * Sets previous first item first.
     */
    public Item pop(){
        Item item = end.item;
        end = end.forwards;
        end.backwards = beg;
        beg.forwards = end;

        stackPointer--;
        if (!isEmpty()){
            printContent(end);
        }


        return item;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String b = input.nextLine();
        char[] inputChar = b.toCharArray();

        StackFIFO<Integer> stack = new StackFIFO<>();

        String input;       //string?

        Scanner sc = new Scanner(System.in);
        System.out.println("mata in grejer");

        while((input = sc.nextLine()) != null){
            if(input.equals("+")){
                input = sc.nextLine();
                int a = Integer.valueOf(input);
                stack.push(a);
            }
            else if(input.equals("-")){
                stack.popBeginning();
            }

            else{
            }
        }
    }
}
