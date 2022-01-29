//Class to construct the Sky scrapper as per the delivery schedule
public class Floor_Construction 
{
	//initiate a Binary Search tree to store the floors which are delivered but cannot be used for construction as the number is lower than the constructed floor
	public static  BST.Node root = null;
	
	public static void ConstructFloor(int perdayFloorDelivery[])
	{
		//variable to store the per day floor delivery from array
		int value;
	
		boolean status= true;
	
		//Variable to store max value in BST
		int maxvalue = 0 ;
		//initiate the current floor to the max value of total number of floors
		int currentfloor = perdayFloorDelivery.length;
		
		//Counter to keep track of construction schedule per day
		int numberofday = 0;
		
		for (int i = 0 ; i < perdayFloorDelivery.length; i++)
		{
			System.out.println("");
			numberofday = i + 1;
			//Concentrate of the current day
		// check if the current floor delivery on the day is as per the size of current floor to be constructed
			if (perdayFloorDelivery[i] == currentfloor)
			{
			//if yes then print and construct that floor	
				System.out.println ("Day: " + numberofday);
				System.out.print(perdayFloorDelivery[i] + " ");
				--currentfloor; //once the floor is constructed reduce the current floor counter
				//System.out.println("");
			}
			else
			{
				//insert the non constructed floor in the BST
				System.out.println ("Day: " + numberofday);
				value = perdayFloorDelivery[i];
				if (root == null) 
				{
					root = BST.insert(root, value);
				}
				else 
				{
					BST.insert(root, value);
				}
			}
			//BST.Inorder(root);
			if (root != null)
			{ // this is a loop to dequeue the bst floors as per the order of construction
				while (status==true)
				{
					if (root == null) 
					{
						maxvalue = 0 ;
					}
					else
					{
						maxvalue =BST.maxValue(root);
					}
					
					if (maxvalue == currentfloor  &&  maxvalue!=0)
					{
						System.out.print(maxvalue + " ");
						 root = BST.deleteNode(root, currentfloor);
						--currentfloor;
					}
					else
					{
						status = false;
					}
				}
			}
			status = true;
		}
	}
}
