package com.singlylinkedlist;

public class SinglyLInkedList {

	static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	Node head;
	int count;

	public SinglyLInkedList() {
		head = null;
		count = 0;
	}

	public int getCount() {
		return count;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		count++;
	}

	public void addLast(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
		} else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			trav.next = newNode;
		}
		count++;
	}

	public void addPosition(int data, int pos) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
		} else if (pos <= 1) {
			addFirst(data);
		} else {
			Node trav = head;
			for (int i = 1; trav.next != null && i < pos - 1; i++) {
				trav = trav.next;
			}
			newNode.next = trav.next;
			trav.next = newNode;
		}
		count++;
	}

	public void deleteFirst() {
		if (isEmpty()) {
			return;
		} else {
			head = head.next;
		}
		count--;
	}

	public void deleteLast() {
		if (isEmpty()) {
			return;
		} else if (head.next == null) {
			head = null;
		} else {
			Node trav = head;
			while (trav.next.next != null) {
				trav = trav.next;
			}
			trav.next = null;
		}
		count--;
	}

	public void deletePosition(int pos) {
		if (isEmpty()) {
			return;
		} else if (head.next == null) {
			head = null;
		} else if (pos <= 1) {
			deleteFirst();
		} else {
			Node trav = head;
			for (int i = 1; trav.next.next != null && i < pos - 1; i++) {
				trav = trav.next;
			}
			trav.next = trav.next.next;
		}
		count--;
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

	public void display() {
		Node trav = head;
		System.out.print("List : ");
		while (trav != null) {
			System.out.print(" " + trav.data);
			trav = trav.next;
		}
		System.out.println();
	}

}
