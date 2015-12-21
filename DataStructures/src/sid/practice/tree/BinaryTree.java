package sid.practice.tree;

public class BinaryTree {

    // Root of Binary Tree
	TreeNode root;
 
    BinaryTree()
    {
        root = null;
    }
	public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.left.left = new TreeNode(10);
        
		System.out.println("Pre-Order Traversal of tree");
		printPreOrder(tree.root);

		System.out.println("\nIn-Order Traversal of tree");
		printInOrder(tree.root);

		System.out.println("\nPost-Order Traversal of tree");
		printPostOrder(tree.root);
		
		int height = heightOfTree(tree.root);
		System.out.println("\nHeight of the above given binary tree: " + height);
		
	}
	
	public static int heightOfTree(TreeNode root){

		if(root == null)
			return 0;
		else{
			int lHeight = heightOfTree(root.left);
			int rHeight = heightOfTree(root.right);
			
			if(lHeight > rHeight)
				return lHeight + 1;
			else
				return rHeight + 1;
		}
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
