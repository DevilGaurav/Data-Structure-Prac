
import java.util.Scanner;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Node head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (!isEmpty()) {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public boolean deleteByValue(int data) {
        if (isEmpty()) {
            return false;
        }

        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return true;
        }

        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }

        return true;
    }

    public boolean deleteAtPosition(int position) {
        if (isEmpty() || position < 0) {
            return false;
        }

        if (position == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return true;
        }

        Node current = head;
        for (int i = 0; i < position; i++) {
            if (current == null) {
                return false;
            }
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }

        return true;
    }

    public void sortList() {
        if (isEmpty()) {
            return;
        }

        Node current, index;
        int temp;

        for (current = head; current.next != null; current = current.next) {
            for (index = current.next; index != null; index = index.next) {
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
        Node current = head;
        int index = 0;

        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }

        return array;
    }

    private int getSize() {
        Node current = head;
        int size = 0;

        while (current != null) {
            size++;
            current = current.next;
        }

        return size;
    }

    public int findMax() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        int max = head.data;
        Node current = head;

        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }

        return max;
    }

    public int findMin() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        int min = head.data;
        Node current = head;

        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }

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

        Node current = head;
        System.out.print("List elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        while (true) {
            System.out.println("\nDoubly Linked List Operations Menu:");
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

