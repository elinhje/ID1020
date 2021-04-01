import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Elin Hjelmestam
 * This file was generated 2020-09-05
 * This file was last updated 2020-09-09
 *
 * The purpose of this code is to reads from stdin and print the input
 * backwards by an iterable function. To do this, a LIFO stack has been
 * built. In the code the functions push, pop, check if empty and
 * resizing is implemented.
 *
 * This code was written as a part of the examination of KTH course ID1020.
 */

public class StackLIFO<Item> implements Iterable<Item>{
    private Item[] stack;
    private int stackPointer;

    /**
     * Checks if empty.
     */
    public boolean isEmpty(){              //hallå använd det här också
        return stackPointer == 0;
    }

    /**
     * Initializes new stack.
     */
    public StackLIFO(){
        stack = (Item[]) new Object[7];
        stackPointer = 0;
    }

    /**
     * Calls resize if stack needs to be resized,
     * then adds item to the top of the stack.
     */
    public void push(Item item){
        if (stackPointer == stack.length) resize(2 * stack.length);
        stack[stackPointer++] = item;
    }

    /**
     * Calls resize if stack needs to be resized,
     * then removes item from top of stack.
     */
    public Item pop(){
        Item item = stack[stackPointer - 1];
        stack[stackPointer - 1] = null;
        if (stackPointer > 0 && stackPointer == stack.length/4){
            resize(stack.length/2);
        }
        stackPointer--;
        return item;
    }

    /**
     * Resizes stack with given input bla.
     */
    private void resize(int bla){
        Item[] copy = (Item[]) new Object[bla];
        for (int a = 0; a < this.stackPointer; a++){
            copy[a] = this.stack[a];
            stack = copy;
        }
    }

    @Override
    public Iterator<Item> iterator(){
        return null;
    }

    /**
     * Prints stack.
     */
    public void printStack(){
        if(!isEmpty()){
            while(0 < stackPointer){
                System.out.printf("[%s]", pop());
            }
        }
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        String b = input.nextLine();
        char[] inputChar = b.toCharArray();
        StackLIFO stack = new StackLIFO();

        for (int c = 0; c < inputChar.length; c++){
            stack.push(inputChar[c]);
        }
        stack.printStack();



    }
}
