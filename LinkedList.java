/**  
* LinkedList.java - Program to create a linked list using basic data structure, Various operation used 
  1) Add a node -- 2) Delete the trail //3 Delete value greater than some number (I have done the sorting and then did the deletion)  
* @author  Arpit Saklecha
* @version 1.0 
* @usage Linked List example
*/ 

public class LinkedList
{
	Node head = null;
	
	//Inner Class
	 class Node 
	{
		int data;
		Node next;

		public Node(int data) 
		{
			this.data = data;
		}
	}
	
	Node sortedMerge(Node a, Node b) 
	{
		Node result = null;
		
		if (a == null)
			return b;
		if (b == null)
			return a;
		
		if (a.data <= b.data) 
		{
			result = a;
			result.next = sortedMerge(a.next, b);
		} 
		else 
		{
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;

	}

	Node mergeSort(Node h) 
	{
		
		if (h == null || h.next == null)
		{
			return h;
		}

		
		Node middle = getMiddle(h);
		Node nextofmiddle = middle.next;

		
		middle.next = null;

		// Apply mergeSort on left list
		Node left = mergeSort(h);

		// Apply mergeSort on right list
		Node right = mergeSort(nextofmiddle);

		// Merge the left and right lists
		Node sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

	Node getMiddle(Node h) 
	{
	
		if (h == null)
			return h;
		Node fastptr = h.next;
		Node slowptr = h;
		
		while (fastptr != null)
		{
			fastptr = fastptr.next;
			if(fastptr!=null)
			{
    			slowptr = slowptr.next;
    			fastptr=fastptr.next;
			}
		}
		return slowptr;
	}

	void push(int newdata) 
	{
		Node newnode= new Node(newdata);
		Node temp=head;
		
		if(head==null){
			head=newnode;
			return;
		}
		
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=newnode;
		
}

	
	void printList(Node refhead) 
	{
		while (refhead != null) 
		{
			System.out.print(refhead.data + " ");
			refhead = refhead.next;
		}
	}
	
	//to delete the tail
	void tailDelete()
	{
		Node temp=head;
		Node prev=null;
		while(temp.next!=null)
		{
			prev=temp;
			temp=temp.next;
			
		}
		prev.next=temp.next;
	}
	
	void greaterCriteria(int data)
	{
		Node currentnode=head;
		Node prev=head;
		
		while(currentnode.next!=null)
			{
		       if (currentnode.data>data)
				{
		    	   	currentnode.next =null;
					prev.next=null;
					return;
				}
				prev=currentnode;
				currentnode=currentnode.next;
			}
		}
	
	
	public static void main(String[] args) 
	{
		
		LinkedList linkedList = new LinkedList();
		
		//Add elements to linked list
		linkedList.push(4);
		linkedList.push(1);
		linkedList.push(5);
		linkedList.push(9);
		linkedList.push(7);
		linkedList.push(8);
		  
			
		System.out.println("Linked List without sorting is:");
		linkedList.printList(linkedList.head);
		
		linkedList.tailDelete();
		System.out.println("\nAfter tail:");
		
		linkedList.printList(linkedList.head);

		// Apply merge Sort before applying greaterCriteria
		linkedList.head =linkedList.mergeSort(linkedList.head);
		System.out.print("\nSorted Linked List is:");
		
		linkedList.printList(linkedList.head);
		linkedList.greaterCriteria(6);
		
		System.out.print("\nAfter Greate Criteria:");
		linkedList.printList(linkedList.head);
	}
	
	
}

