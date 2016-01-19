package sid.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	// Root of Binary Tree
	TreeNode root;

	BinaryTree() {
		root = null;
	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(7);
		tree.root.left = new TreeNode(4);
		tree.root.right = new TreeNode(9);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.right = new TreeNode(6);

		System.out.println("Pre-Order Traversal of tree");
		printPreOrder(tree.root);

		System.out.println("\nIn-Order Traversal of tree");
		printInOrder(tree.root);

		System.out.println("\nPost-Order Traversal of tree");
		printPostOrder(tree.root);

		int height = heightOfTree(tree.root);
		System.out.println("\nHeight of the above given binary tree: " + height);

		System.out.println("\nLevel Order Traversal");
		levelOrderTraversal(tree.root);

		System.out.println("\nIs the given binary tree a BST: " + isBinarySearchTree(tree.root));

	}

	public static void levelOrderTraversal(TreeNode root) {

		if (root == null)
			return;

		Queue<TreeNode> discoveryQueue = new LinkedList<TreeNode>();
		discoveryQueue.add(root);

		while (!discoveryQueue.isEmpty()) {

			TreeNode currentNode = discoveryQueue.element();
			System.out.print(currentNode.data + " ");

			if (currentNode.left != null)
				discoveryQueue.add(currentNode.left);
			if (currentNode.right != null)
				discoveryQueue.add(currentNode.right);

			discoveryQueue.remove();
		}
	}

	static boolean isBstUtil(TreeNode root, int minValue, int maxValue) {

		if (root == null)
			return true;

		if (root.data > minValue && root.data < maxValue 
				&& isBstUtil(root.left, minValue, root.data)
				&& isBstUtil(root.right, root.data, maxValue))
			return true;
		else
			return false;
	}

	static boolean isBinarySearchTree(TreeNode root) {

		return isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static int heightOfTree(TreeNode root) {

		if (root == null)
			return -1;

		int lHeight = heightOfTree(root.left);
		int rHeight = heightOfTree(root.right);

		return Math.max(lHeight, rHeight) + 1;
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

}
