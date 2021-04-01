public class OrderedList<Item> {

    private int stackPointer = 0;
    private Node beg = null;

    private class Node{
        Item item;
        Node forwards;
        int index = 0;
    }

    public void increment(Node current){
        current.index++;
        if(current.forwards != null){
            increment(current.forwards);
        }
    }

    /**
     * Pushes item to stack.
     */
    public void push(int item){
        Node newItem = new Node();
        newItem.item = item;

        if(stackPointer == 0){
            beg = newItem;
        }

        else{
            increment();
        }

        stackPointer++;

        printContent(beg);

    }

    /**
     * Removes item from stack.
     */
    public void remove(int index){
        //kod kod
    }

    public static void main(String[] args){
        OrderedList stack = new OrderedList();

        //int one = 1;
        //int two = 6;

        //stack.push(one);
        //stack.push(two);
    }
}
