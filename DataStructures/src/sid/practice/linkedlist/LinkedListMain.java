package sid.practice.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedListMain {

	public static void main(String[] args) {

		int elementsToAdd = 0;
		int integerAdded = 0;
		Node head = null;

		System.out.println("Please enter how many elements would you like to add: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			elementsToAdd = Integer.parseInt(br.readLine());
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		} catch (IOException ioe) {
			System.out.println("Invalid Input entered");
		}

		for (int i = 0; i < elementsToAdd; i++) {
			System.out.println("Enter an integer:");
			try {
				integerAdded = Integer.parseInt(br.readLine());
			} catch (NumberFormatException nfe) {
				System.err.println("Invalid Format!");
			} catch (IOException ioe) {
				System.out.println("Invalid Input entered");
			}
			head = insertNode(head, integerAdded);
		}
		printList(head);
		
		System.out.println("Please enter the data which would replace the head: ");
		try {
			int dataReplacingHead = Integer.parseInt(br.readLine());
			head = insertAtHeadNode(head, dataReplacingHead);
			printList(head);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	/** This method adds a node at the end of an existing linked list
	 * @param Node head
	 * @param int data
	 * @return Node head
	 */
	public static Node insertNode(Node head, int data) {

		Node newNode = new Node();
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
	
	 
	/** This method adds a node at the head of an existing linked list
	 * @param Node head
	 * @param int data
	 * @return Node head
	 */
	public static Node insertAtHeadNode(Node head, int data) {

		Node newNode = new Node();
		newNode.data = data;		
		if (head != null) {
			Node firstNode = head;			
			newNode.next = firstNode;
		}
		head = newNode;
		return head;
	}


	/** prints all the elements of the linked list
	 * @param head
	 */
	public static void printList(Node head) {

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
