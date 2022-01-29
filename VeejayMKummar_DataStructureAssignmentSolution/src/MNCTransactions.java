import java.util.Scanner;

public class MNCTransactions 
{
	public static void transactions()
	{
		Scanner sc = new Scanner(System.in);
		int value;
		
		System.out.println("Welcome to Project MNC Transactions");
		System.out.println("");
	// Take input on total number of transactions
		System.out.println("Enter the total no of transactions");
		
		int NumberofTransactions = 0;
		NumberofTransactions = sc.nextInt();
		//initiate a BST to take inputs from the user as per the input order
		BST.Node root = null;
		BST.Node SkewRoot = null;
		boolean duplicate = false;
		for (int i = 0 ; i < NumberofTransactions; i++)
		{
			System.out.println("Enter the transaction number :" + Integer.toString(i+1));
			value  = 	 sc.nextInt();
		//Check for duplicate value in BST
			duplicate = BST.search(root, value);
			if (duplicate == false)
			{ //if not a duplicate value insert in the BST
				if (root == null) 
				{
					root = BST.insert(root, value);
				}
				else 
				{
					BST.insert(root, value);
				}
			}
			else
			{ //if duplicate reduce the counter, display the message and ask for input again
				--i;
				System.out.println("Duplicate Value !!!");
			}

		}
		//display the root of the original BST which would as per the order of input
		System.out.println("Root of the original BST is " + root.key);
		System.out.println("");
		
		//initiate a loop for the total number of transations inserted in the BST
		for (int j = 0 ; j < NumberofTransactions; j++)
		{
			int LowerValue;
		//for each iteration search the lowest value in bst and assign to the LowerValue variable
			LowerValue=BST.minValue(root);
		//Once Assigned delete the node of that value from original BST
			root = BST.deleteNode(root,LowerValue);
			//Start inserting the value in new BST called SkewRoot
			if (SkewRoot == null) 
			{
				SkewRoot = BST.insert(SkewRoot, LowerValue);
			}
			else 
			{
				BST.insert(SkewRoot, LowerValue);
			}
		}
		//As we are inserting from the lowest value in BST which is same as Inorder traversal the values 
		//popping out of original BST would be in ascending order
		//when we insert the values in the order of assending order in a BST all the values inserted would be the right of each node
		//as desired 
		// hence the new BST would be Right Skewed Tree as per the below outpus which can be used to verify the same
		System.out.println("Post Conversion of BST to Right Skew tree");
		//Root changes to the lowest value post conversion to right skewed tree
		System.out.println("Root of the BST is : " + SkewRoot.key);
		System.out.println("");
		//Output the inorder traversal of the Right Skewed tree
		System.out.println("InOrder Traversal of Right Skewed tree is below:");
		BST.Inorder(SkewRoot);
		System.out.println("");
		System.out.println("");
		// The output of left nodes would be nothing except the root node as there are no node on the left side
		System.out.println("Left Nodes of the Tree post Right Skew Conversion is below: ");
		BST.LeftNodes(SkewRoot);
		System.out.println("");
		System.out.println("");
		//The Right Nodes would pring all the valued in the ascending order as all the values are on right of the node as required. 
		System.out.println("Right Nodes of the Tree post Right Skew Conversion is below: ");
		BST.RightNodes(SkewRoot);
		
	}
}
