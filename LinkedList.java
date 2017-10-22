package com.arnav.ds;

/** linked list  
 *  @author Arnav
 *  */
class LinkedList
{	
    Node head; // head of linked list
 
    /** Linked list node */
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    void rotateForNElements(int n){
    	Node current = head;
    	int count = 1;
    	while(count<n && current!=null){
    		current = current.next;
    		count++;
    	}
    	
    	Node nthNode = current;
    	
    	while(current.next!=null){
    		current = current.next;
    	}
    	
    	current.next = head;
    	head = nthNode.next;
    	nthNode.next = null;
    }
    
    void swapAdjacent(){
    	Node current = head;
    	Node next = current.next;
    	Node dnext = next.next;
    	Node prev = head;
    	head = head.next;
    	
    	while(dnext!=null && dnext.next!=null ){
    		next.next = current;
    		prev.next = next;
    		current.next = dnext;
    		prev = current;
    		current = dnext;
    		next = current.next; 	
    		dnext = next.next;
    	}
    	
    	if(dnext==null){
    		prev.next = next;
        	next.next = current;
        	current.next = null;    		
    	}
    System.out.println("output");
    }
    
 /** prints nth element from last*/
    void nthElementFromLast(Node head, int n){
    	
    	Node slower = head;
    	Node faster = head;
    	for(int i=0;i<n;++i){
    		faster = faster.next;
    	}
    	while(faster!=null){
    		faster = faster.next;
    		slower = slower.next;
    	}
    	System.out.println(n+"th element from last: "+slower.data);
    }
    /** Function to print middle of linked list */
    void printMiddle()
    {
        Node slow_ptr = head;
        Node fast_ptr = head;
        if (head != null)
        {
            while (fast_ptr != null && fast_ptr.next != null)
            {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is [" +
                                slow_ptr.data + "] \n");
        }
    }
 
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
 
    /* This function prints contents of linked list
       starting from  the given node */
    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+"->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }
 
    public static void main(String [] args)
    {
        LinkedList llist = new LinkedList();
        for (int i=9; i>0; --i)
        {
            llist.push(i);
        }
        llist.printList();
        llist.swapAdjacent();
//        llist.printMiddle();
//        llist.nthElementFromLast(llist.head, 7);
//        llist.rotateForNElements(4);
        
        llist.printList();
    }
}