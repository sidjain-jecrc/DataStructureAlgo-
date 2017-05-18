package sid.practice.linkedlist;

import java.util.Scanner;

public class LinkedListMain {

	public static void main(String[] args) {

		int elementsToAdd = 0;
		int integerAdded = 0;
		Node head = null;
		Scanner sc = new Scanner(System.in);

		System.out.print("Please enter how many elements would you like to add: ");
		elementsToAdd = sc.nextInt();

		for (int i = 0; i < elementsToAdd; i++) {
			System.out.print("Enter an integer: ");
			integerAdded = sc.nextInt();
			head = insertNode(head, integerAdded);
		}
		System.out.println("Linked List before reversal");
		printUsingIteration(head);
		System.out.println("Printing Linked list in reverse order");
		printReverse(head);

/*		System.out.println("LinkedList after reversal");
		head = reverseList(head);
		printUsingRecursion(head);*/
		/*
		 * System.out.println(
		 * "Please enter the data which would replace the head: "); int
		 * dataReplacingHead = Integer.parseInt(br.readLine()); head =
		 * insertAtHeadNode(head, dataReplacingHead); printList(head);
		 */

	}

	/**
	 * This method adds a node at the end of an existing linked list
	 * 
	 * @param Node
	 *            head
	 * @param int
	 *            data
	 * @return Node head
	 */
	public static Node insertNode(Node head, int data) {

		Node newNode = new Node(0);
		newNode.data = data;
		Node current = head;
		if (head == null) {
			head = newNode;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		return head;
	}

	/**
	 * This method adds a node at the head of an existing linked list
	 * 
	 * @param Node
	 *            head
	 * @param int
	 *            data
	 * @return Node head
	 */
	public static Node insertAtHeadNode(Node head, int data) {

		Node newNode = new Node(0);
		newNode.data = data;
		if (head != null) {
			Node firstNode = head;
			newNode.next = firstNode;
		}
		head = newNode;
		return head;
	}

	/**
	 * This method reverses the link list using iterative approach
	 * 
	 * @param Node
	 *            head
	 * 
	 * @return Node head
	 */
	public static Node reverseList(Node head) {

		if (head != null) {
			Node current = head;
			Node prev = null;
			while (current != null) {
				Node next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			head = prev;
		}
		return head;
	}

	public static void printReverse(Node startNode) {

		if (startNode == null)
			return;

		printUsingRecursion(startNode.next);
		System.out.print(startNode.data + " ");
	}

	/**
	 * prints all the elements of the linked list using recursive approach
	 * 
	 * @param head
	 */
	public static void printUsingRecursion(Node startNode) {

		if (startNode == null)
			return;

		System.out.print(startNode.data + " ");
		printUsingRecursion(startNode.next);
	}

	/**
	 * prints all the elements of the linked list using iterative approach
	 * 
	 * @param head
	 */
	public static void printUsingIteration(Node head) {

		if (head != null) {
			Node current = head;
			while (current.next != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println(current.data);
		}
	}

}
