//Main Binary Search Tree Class with all the related methods
public class BST 
{
//Node Class
	static class Node 
	{
		int key;
		Node left, right;
	}
	
//New Node Method
	static Node newNode(int data) 
	{
		Node temp = new Node();
		temp.key = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}
	//Insert a Node in the BST
	static Node insert(Node root, int key) 
	{
		Node newnode = newNode(key);
		Node x = root;
		Node current_parent = null;
	//Traverse till we get a null node
		while (x != null) 
		{
			current_parent = x;
			if (key < x.key)
				x = x.left;
			else if (key > x.key)
				x = x.right;
			else 
			{
				System.out.println("Value already exists!!!");
				return newnode;
			}
		}
		// If the root is null, the tree is empty.
		if (current_parent == null)
			current_parent = newnode;
		// assign new node node to the left child
		else if (key < current_parent.key)
			current_parent.left = newnode;
		// assign the new node to the right child
		else
			current_parent.right = newnode;
		// return pointer to new node
		return current_parent;
	}
	//Method to delete a node
	static Node deleteNode(Node root, int key) 
	{
        if(root == null) return root;
        if(key > root.key)
        { //move right
            root.right = deleteNode(root.right, key);
        }
        else if(key < root.key)
        { //move left
        	root.left = deleteNode(root.left, key);
        }
        else
        { // finally found the target
        	if(root.left == null && root.right == null)
        	{ //its a leaf node
                root = null;
            }
        	else if(root.right != null)
        	{ // it has a right child
                root.key = successor(root); // successor
                root.right = deleteNode(root.right, root.key);
            }
        	else
        	{ //no successor go back to predecessor ...
                root.key = predecessor(root);
                root.left = deleteNode(root.left, root.key);
            }
        }
        return root;
	}
	//Method to find predecessor 
	 private static int predecessor(Node root){
	        root = root.left;
	        while(root.right != null){
	            root = root.right;
	        }
	        return root.key;
	    }
	 //Method to find Successor
	 private static int successor(Node root){
	        root = root.right;
	        while(root.left != null){
	            root = root.left;
	        }
	        return root.key;
	    }
	
	//Method to find Minimum value in BST
	static int minValue(Node root) 
	{
		// initially minval = root
		int minval = root.key;
		// find minval
		while (root.left != null) 
		{
			minval = root.left.key;
			root = root.left;
		}
		return minval;
	}
	
	//Method to find Max Value in BST
	static int maxValue(Node root) 
	{
		// initially maxval = root
		int maxval = root.key;
		// find maxval
		while (root.right != null) 
		{
			maxval = root.right.key;
			root = root.right;
		}
		return maxval;
	}
	
	//Method to find Node with a given value
	static boolean search(Node root, int key) 
	{
		root = search_Recursive(root, key);
		if (root != null)
			return true;
		else
			return false;
	}
	//Recursive method to search the node with a given value
	static Node search_Recursive(Node root, int key) 
	{
		// when root is null or key is present at root
		if (root == null || root.key == key)
			return root;
		// when value is greater than root's key
		if (root.key > key)
			return search_Recursive(root.left, key);
		// when value is less than root's key
		return search_Recursive(root.right, key);
	}
	//Inorder traversal of the BST
	static void Inorder(Node root) 
	{
		if (root == null)
			return;
		else 
		{
			Inorder(root.left);
			System.out.print(root.key + " ");
			Inorder(root.right);
		}
	}
	//Method to find left Skew of given Node
	static void LeftNodes(Node root)
	{
		if (root == null)
		{
			return;
		}
		else
		{
			System.out.print(root.key + " ");
			LeftNodes(root.left);
		}
	}
	//Method to find Right skew of a given node
	static void RightNodes(Node root)
	{
		if (root == null)
		{
			return;
		}
		else
		{
			System.out.print(root.key + " ");
			RightNodes(root.right);
		}
	}
}
