package classes;


// Java code for Linked List implementation

public class LinkedListDriver
{
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();


        //I can access the inner class to make a node,
        // which acts like a class method.
        //Alternatively, I could have make ListNode in its own file.
        LinkedList.ListNode first = new LinkedList.ListNode( 1);
        LinkedList.ListNode second = new LinkedList.ListNode( 2);
        LinkedList.ListNode third  = new LinkedList.ListNode( 3);
        llist.prepend(first);
        llist.prepend(second);
        llist.prepend(third);

        System.out.println(llist);

    }
}