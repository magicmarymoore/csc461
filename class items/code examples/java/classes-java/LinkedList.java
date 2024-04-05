package classes;



/**
 * overly simplify linked list with only prepend
 * Demonstrates nested classes
 */
public class LinkedList {

    private ListNode head;  // head of list

    //similar to struct
    static class ListNode{
        private Object data;
        private ListNode next;
        public ListNode( Object d ) {
            data = d;
            next = null;
        }
    }

    public void prepend(ListNode node){
        node.next = head;
        head = node;
    }

    //standard print list function
    public String toString(){
        ListNode temp = head;
        StringBuilder str = new StringBuilder();
        while(temp!=null)
        {
            str.append(" ").append(temp.data);
            temp = temp.next;
        }
        return str.toString();
    }
}
