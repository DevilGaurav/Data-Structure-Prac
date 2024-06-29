
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    private Node tail;

    public CircularLinkedList() {
        this.tail = null;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public boolean deleteByValue(int data) {
        if (isEmpty()) {
            return false;
        }

        Node current = tail.next;
        Node prev = tail;

        do {
            if (current.data == data) {
                if (current == tail && current.next == tail) {
                    tail = null;
                } else {
                    if (current == tail) {
                        tail = prev;
                    }
                    prev.next = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        } while (current != tail.next);

        return false;
    }

    public boolean deleteAtPosition(int position) {
        if (isEmpty() || position < 0) {
            return false;
        }

        Node current = tail.next;
        Node prev = tail;

        if (position == 0) {
            if (tail.next == tail) {
                tail = null;
            } else {
                tail.next = current.next;
            }
            return true;
        }

        for (int i = 0; i < position; i++) {
            if (current == tail) {
                return false;
            }
            prev = current;
            current = current.next;
        }

        prev.next = current.next;
        if (current == tail) {
            tail = prev;
        }

        return true;
    }

    public void sortList() {
        if (isEmpty()) {
            return;
        }

        Node current, index;
        int temp;

        for (current = tail.next; current.next != tail.next; current = current.next) {
            for (index = current.next; index != tail.next; index = index.next) {
                if (current.data > index.data) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
            }
        }
    }

    public boolean binarySearch(int key) {
        if (isEmpty()) {
            return false;
        }

        sortList(); // Ensure the list is sorted before performing binary search

        int[] array = toArray();
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == key) {
                return true;
            }

            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    private int[] toArray() {
        int size = getSize();
        int[] array = new int[size];
        Node current = tail.next;
        int index = 0;

        do {
            array[index++] = current.data;
            current = current.next;
        } while (current != tail.next);

        return array;
    }

    private int getSize() {
        if (isEmpty()) {
            return 0;
        }

        Node current = tail.next;
        int size = 0;

        do {
            size++;
            current = current.next;
        } while (current != tail.next);

        return size;
    }

    public int findMax() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        int max = tail.next.data;
        Node current = tail.next;

        do {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        } while (current != tail.next);

        return max;
    }

    public int findMin() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        int min = tail.next.data;
        Node current = tail.next;

        do {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        } while (current != tail.next);

        return min;
    }

    public int count() {
        return getSize();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Node current = tail.next;
        System.out.print("List elements: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        while (true) {
            System.out.println("\nCircular Linked List Operations Menu:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Delete by value");
            System.out.println("4. Delete at specific position");
            System.out.println("5. Sort list using bubble sort");
            System.out.println("6. Search element using binary search");
            System.out.println("7. Find maximum value");
            System.out.println("8. Find minimum value");
            System.out.println("9. Count elements in the list");
            System.out.println("10. Display list");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    int valBeg = scanner.nextInt();
                    list.insertAtBeginning(valBeg);
                    break;
                case 2:
                    System.out.print("Enter value to insert at end: ");
                    int valEnd = scanner.nextInt();
                    list.insertAtEnd(valEnd);
                    break;
                case 3:
                    System.out.print("Enter value to delete: ");
                    int valDel = scanner.nextInt();
                    boolean deletedByValue = list.deleteByValue(valDel);
                    if (deletedByValue) {
                        System.out.println("Value deleted.");
                    } else {
                        System.out.println("Value not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter position to delete (starting from 0): ");
                    int position = scanner.nextInt();
                    boolean deletedAtPosition = list.deleteAtPosition(position);
                    if (deletedAtPosition) {
                        System.out.println("Node deleted at position " + position);
                    } else {
                        System.out.println("Invalid position.");
                    }
                    break;
                case 5:
                    list.sortList();
                    System.out.println("List sorted using bubble sort.");
                    break;
                case 6:
                    System.out.print("Enter value to search: ");
                    int searchKey = scanner.nextInt();
                    boolean found = list.binarySearch(searchKey);
                    if (found) {
                        System.out.println("Value found in the list.");
                    } else {
                        System.out.println("Value not found in the list.");
                    }
                    break;
                case 7:
                    try {
                        int maxValue = list.findMax();
                        System.out.println("Maximum value in the list: " + maxValue);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        int minValue = list.findMin();
                        System.out.println("Minimum value in the list: " + minValue);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    int count = list.count();
                    System.out.println("Number of elements in the list: " + count);
                    break;
                case 10:
                    list.display();
                    break;
                case 11:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
