package doublylnkedlist;

public class DoublyLinkedList {
	static class Node {
		private int data;
		private Node next;
		private Node prev;

		public Node(int value) {
			data = value;
			next = null;
			prev = null;
		}
	}

	private Node head;
	private Node tail;

	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	public boolean isEmpty() {
		return head == null && tail == null;
	}

	public void addFirst(int data) {
		Node newnode = new Node(data);
		if (isEmpty())
			head = tail = newnode;
		else {
			newnode.next = head;
			head.prev = newnode;
			head = newnode;
		}
	}

	public void addLast(int data) {
		Node newnode = new Node(data);
		if (isEmpty())
			head = tail = newnode;
		else {
			newnode.prev = tail;
			tail.next = newnode;
			tail = newnode;
		}
	}

	public void addPosition(int data, int pos) {
		Node newnode = new Node(data);
		if (isEmpty())
			head = tail = newnode;
		else if (pos <= 1)
			addFirst(data);
		else {
			Node trav = head;
			for (int i = 1; trav.next != null && i < pos - 1; i++)
				trav = trav.next;
			if (trav == tail) {
				addLast(data);
				return;
			}
			newnode.next = trav.next;
			newnode.prev = trav;
			trav.next.prev = newnode;
			trav.next = newnode;
		}
	}

	public void deleteFirst() {
		if (isEmpty())
			return;
		else if (head == tail)
			head = tail = null;
		else {
			head = head.next;
			head.prev = null;
		}
	}

	public void deleteLast() {
		if (isEmpty())
			return;
		else if (head == tail)
			head = tail = null;
		else {
			tail = tail.prev;
			tail.next = null;
		}
	}

	public void deletePosition(int pos) {
		if (isEmpty())
			return;
		else if (head == tail)
			head = tail = null;
		else if (pos <= 1)
			deleteFirst();
		else {
			Node trav = head;
			for (int i = 1; trav.next != null && i < pos; i++)
				trav = trav.next;
			if (trav == tail) {
				deleteLast();
				return;
			}
			trav.next.prev = trav.prev;
			trav.prev.next = trav.next;
		}
	}

	public void removeDuplicate() {
		if (isEmpty()) {
			return;
		} else if (head.next == null) {
			System.out.println(head.data);
		} else {
			Node trav = head;

			while (trav != null) {
				Node trav1 = trav;
				while (trav1.next != null) {
					if (trav1.next.data == trav.data) {
						trav1.next = trav1.next.next;
					} else {
						trav1 = trav1.next;
					}
				}
				trav = trav.next;
			}
		}
	}
	
	public void search(int key) {
		Node trav = head;
		while(trav!=null) {
			if(key==trav.data) {
				System.out.println("Key is Present");
				return;
			}
			trav=trav.next;
		}
		System.out.println("Key is not Present");
		
	}
	
	public void searchByPosition(int pos) {
		Node trav = head;
		int index=1;
		
		while(trav!=null) {
			if(index==pos) {
				System.out.println(trav.data);
			}
			trav=trav.next;
			index++;
		}
	}
	
	public void swap(Node trav1 , Node trav2) {
		int temp = trav1.data;
		trav1.data=trav2.data;
		trav2.data=temp;
	}
	
	public void sortAscending() {
		boolean swapped;
		Node trav;
		
		if(head==null) {
			return;
		}
		
		do {
			swapped=false;
			trav=head;
			
			while(trav.next!=null) {
				if(trav.data > trav.next.data) {
					swap(trav,trav.next);
					swapped=true;
				}
				trav=trav.next;
			}
		}while(swapped);
	}
	
	public void sortDescending() {
		boolean swapped;
		Node trav;
		
		if(head==null) {
			return;
		}
		
		do {
			swapped=false;
			trav=head;
			
			while(trav.next!=null) {
				if(trav.data < trav.next.data) {
					swap(trav,trav.next);
					swapped=true;
				}
				trav=trav.next;
			}
		}while(swapped);
	}
	
	public void max() {
		Node trav = head;
		int max =trav.data;
		while(trav!=null) {
			if(trav.data>max) {
				max=trav.data;
			}
			trav=trav.next;
		}
		System.out.println("Max : "+max);
	}
	
	public void min() {
		Node trav = head;
		int min =trav.data;
		while(trav!=null) {
			if(trav.data<min) {
				min=trav.data;
			}
			trav=trav.next;
		}
		System.out.println("Max : "+min);
	}
	
	public void fDisplay() {
		Node trav = head;
		System.out.print("Forward List : ");
		while (trav != null) {
			System.out.print(" " + trav.data);
			trav = trav.next;
		}
		System.out.println();
	}

	public void rDisplay() {
		Node trav = tail;
		System.out.print("Reverse List : ");
		while (trav != null) {
			System.out.print(" " + trav.data);
			trav = trav.prev;
		}
		System.out.println("");
	}

	public void deleteAll() {
		head = tail = null;
	}
}
