package sid.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import sid.practice.linkedlist.Node;

public class BinaryTree {

	// Root of Binary Tree
	TreeNode root;
	Node h;

	BinaryTree() {
		root = null;
	}

	private static class TreeNode {

		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			super();
			this.data = data;
			left = right = null;
		}

	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(7);
		tree.root.left = new TreeNode(4);
		tree.root.right = new TreeNode(9);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.right = new TreeNode(6);
		tree.root.right.left = new TreeNode(2);
		tree.root.right.right = new TreeNode(5);

		System.out.println("\nLevel Order Traversal");
		levelOrderTraversal2(tree.root);

		System.out.println("\nSame Depth Traversal");
		listNodesAtSameDepth(tree.root, 1);

		// System.out.print("\nIs the Given Tree a BST: " +
		// isBinarySearchTree(tree.root));
		//
		// int[] nums = { 1, 2, 3, 4, 5 };
		// System.out.println("\nPrinting sorted array before converting into
		// BST");
		// for (int i : nums)
		// System.out.print(i + " ");
		//
		// TreeNode node = sortedArrayToBST(nums);
		// System.out.println("\nPrinting Binary Search Tree");
		// printInOrder(node);

	}

	public static void printPreOrder(TreeNode node) {

		if (node == null)
			return;

		System.out.print(node.data + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	public static void printInOrder(TreeNode node) {

		if (node == null)
			return;

		printInOrder(node.left);
		System.out.print(node.data + " ");
		printInOrder(node.right);
	}

	public static void printPostOrder(TreeNode node) {

		if (node == null)
			return;

		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.data + " ");
	}

	public static int heightOfTree(TreeNode root) {

		if (root == null)
			return 0;

		int lHeight = heightOfTree(root.left);
		int rHeight = heightOfTree(root.right);

		return Math.max(lHeight, rHeight) + 1;
	}

	public static void listNodesAtSameDepth(TreeNode root, int depth) {

		if (root == null || depth < 1)
			return;

		Queue<TreeNode> discoveryQueue = new LinkedList<TreeNode>();
		discoveryQueue.add(root);

		int depthCounter = 0;

		while (true) {

			int nodeCount = discoveryQueue.size();
			depthCounter++;

			if (nodeCount == 0)
				break;

			while (nodeCount > 0) {

				TreeNode currentNode = discoveryQueue.poll();
				if (depthCounter == depth) {
					System.out.print(currentNode.data + " ");
				}

				if (currentNode.left != null) {
					discoveryQueue.add(currentNode.left);
				}
				if (currentNode.right != null) {
					discoveryQueue.add(currentNode.right);
				}
				nodeCount--;
			}
		}

	}

	public static void levelOrderTraversal2(TreeNode root) {

		if (root == null)
			return;

		Queue<TreeNode> discoveryQueue = new LinkedList<TreeNode>();
		discoveryQueue.add(root);

		while (true) {

			int nodeCount = discoveryQueue.size();

			if (nodeCount == 0)
				break;

			while (nodeCount > 0) {

				TreeNode currentNode = discoveryQueue.poll();
				System.out.print(currentNode.data + " ");

				if (currentNode.left != null) {
					discoveryQueue.add(currentNode.left);
				}
				if (currentNode.right != null) {
					discoveryQueue.add(currentNode.right);
				}
				nodeCount--;
			}
			System.out.println();
		}
	}

	public static void levelOrderTraversal(TreeNode root) {

		if (root == null)
			return;

		Queue<TreeNode> discoveryQueue = new LinkedList<TreeNode>();
		discoveryQueue.add(root);

		while (!discoveryQueue.isEmpty()) {

			TreeNode currentNode = discoveryQueue.element();
			System.out.print(currentNode.data + " ");

			if (currentNode.left != null) {
				discoveryQueue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				discoveryQueue.add(currentNode.right);
			}
			discoveryQueue.remove();
		}
		System.out.println();
	}

	static boolean isBinarySearchTree(TreeNode root) {

		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	static boolean validate(TreeNode node, int minValue, int maxValue) {

		if (node == null)
			return true;

		if (node.data <= minValue || node.data >= maxValue)
			return false;

		return validate(node.left, minValue, node.data) && validate(node.right, node.data, maxValue);

	}

	// Convert sorted array to BST
	static TreeNode sortedArrayToBST(int[] nums) {

		if (nums.length == 0)
			return null;

		return sortedArrayToBST(nums, 0, nums.length - 1);

	}

	static TreeNode sortedArrayToBST(int[] nums, int start, int end) {

		if (start > end)
			return null;

		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, start, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, end);
		return root;

	}

	// convert sorted linked list to BST
	public TreeNode sortedListToBST(Node head) {
		if (head == null)
			return null;

		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}

	// get list length
	public int getLength(Node head) {
		int len = 0;
		Node p = head;

		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}

	// build tree bottom-up
	public TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;

		// mid
		int mid = (start + end) / 2;

		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.data);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);

		root.left = left;
		root.right = right;

		return root;
	}

}
