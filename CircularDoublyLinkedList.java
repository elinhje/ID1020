import java.util.Scanner;

/**
 * @author Elin Hjelmestam
 * This file was generated 2020-09-07
 * This file was last updated 2020-09-09
 *
 * This code is a doubly linked circle stack. In the code the functions push,
 * pop and check if empty is implemented. In order to do this, a stack pointer,
 * nodes for the end and the beginning of the stack and nodes that points backwards
 * to the previous element and forwards to the following element in the stack have
 * been initialized. The content of the list is printed each time an element has
 * been inserted or deleted.
 *
 * This code was written as a part of the examination of KTH course ID1020.
 */

public class CircularDoublyLinkedList<Item> {
    
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
         * Pushes item to beginning of stack.
         * Sets previous first item second first.
         */
        public void pushBeginning(Item item){
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
         * Pushes item to end of stack.
         * Sets previous last item second last.
         */
        public void pushEnding(Item item){
            Node prevEnd = new Node();
            if (!isEmpty()){
                prevEnd = end;
                end = new Node();
                end.item = item;
            }
            end = new Node();
            end.item = item;
            if (!isEmpty()){
                end.forwards = prevEnd;
                end.backwards =beg;
                prevEnd.backwards = end;
                beg.forwards = end;
            }
            else{
                beg = end;
                beg.forwards = beg;
            }
            stackPointer++;

            printContent(end);
        }

        /**
         * Pops the first item in stack.
         * Sets previous first item first.
         */
        public Item popBeginning(){
            Item item = beg.item;
            beg = beg.backwards;
            beg.forwards = end;
            end.backwards = beg;

            stackPointer--;

            if(!isEmpty()){
                printContent(end);
            }

            return item;
        }

        /**
         * Pops the last item in stack.
         * Sets previous second last item last.
         */
        public Item popEnding(){
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
        CircularDoublyLinkedList<Integer> stack = new CircularDoublyLinkedList<>();

        String input;       //string?

        Scanner sc = new Scanner(System.in);
        System.out.println("mata in grejer");

        while((input = sc.nextLine()) != null){
            if(input.equals("++")){
                input = sc.nextLine();
                int a = Integer.valueOf(input);
                stack.pushEnding(a);
            }
            else if(input.equals("+")){
                input = sc.nextLine();
                int a = Integer.valueOf(input);
                stack.pushBeginning(a);
            }
            else if(input.equals("-")){
                stack.popBeginning();
            }
            else if(input.equals("--")){
                stack.popEnding();
            }
            else{
                //
            }
        }

    }
}
