package com.singlylinkedlist;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SinglyLInkedList list = new SinglyLInkedList();

		list.addLast(10);
		list.addLast(20);
		list.addLast(40);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.addLast(70);
		list.display();
		System.out.println("Count : " + list.getCount());

		list.addPosition(30, 3);
		list.display();
		System.out.println("Count : " + list.getCount());

		list.deleteLast();
		list.display();
		System.out.println("Count : " + list.getCount());

		list.removeDuplicate();
		list.display();
		
		list.search(600);
		
		list.searchByPosition(5);
		
		list.sortAscending();
		list.display();
		list.sortDescending();
		list.display();
		
		list.max();
		list.min();

	}

}
