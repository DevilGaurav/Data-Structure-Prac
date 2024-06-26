package doublylnkedlist;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			DoublyLinkedList dl = new DoublyLinkedList();
			boolean exit = false;
			while (!exit) {
				System.out.println("App options\n" + "0:exit\n" + "1:addfirst\n" + "2:addlast\n"
						+ "3:add with  position\n" + "4:deltefirst\n" + "5:deletelast\n" + "6:deleteby position\n"
						+ "7:display\n" + "8:display reverse\n" + "9:display max\n" + "10:display min\n"
						+ "11:remove duplicate\n" + "12:search element\n" + "13:search element position\n"
						+ "14:swap element\n" + "15:sort in ascending\n" + "16:sort in descending\n");
				switch (sc.nextInt()) {
				case 0:
					exit = true;
					break;
				case 1:
					int v1 = sc.nextInt();
					dl.addFirst(v1);
					break;
				case 2:
					int v2 = sc.nextInt();
					dl.addLast(v2);
					break;
				case 3:
					int v3 = sc.nextInt();
					int p = sc.nextInt();
					dl.addPosition(v3, p);
					break;
				case 4:
					dl.deleteFirst();
					break;
				case 5:
					dl.deleteLast();
					break;
				case 6:
					int p2 = sc.nextInt();
					dl.deletePosition(p2);
					break;
				case 7:
					dl.fDisplay();
					break;
				case 8:
					dl.rDisplay();
					break;
				case 9:
					dl.max();
					break;
				case 10:
					dl.min();
					break;
				case 11:
					dl.removeDuplicate();
					break;
				case 12:
					int s1 = sc.nextInt();
					dl.search(s1);
					break;
				case 13:
//					int s2=sc.nextInt();
					int p3 = sc.nextInt();
					dl.searchByPosition(p3);
					break;
				case 14:
					int t1 = sc.nextInt();
					int t2 = sc.nextInt();
					// dl.swap(t1,t2);
					break;
				case 15:
					dl.sortAscending();
					break;
				case 16:
					dl.sortDescending();
					break;

				}
			}
		}
	}

}



/*
 * DoublyLinkedList list = new DoublyLinkedList();
 * 
 * list.addFirst(10); list.addLast(20); list.addLast(20); list.addLast(90);
 * list.addLast(40); list.addLast(50); list.addLast(60); list.fDisplay();
 * list.rDisplay();
 * 
 * list.removeDuplicate(); list.fDisplay();
 * 
 * list.search(50); list.searchByPosition(3);
 * 
 * list.sortAscending(); list.fDisplay(); list.sortDescending();
 * list.fDisplay();
 * 
 * list.max(); list.min();
 */
