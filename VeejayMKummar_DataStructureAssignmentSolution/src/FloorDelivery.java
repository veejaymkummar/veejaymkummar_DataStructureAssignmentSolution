import java.util.Scanner;
// This call take all the floor deliveries per day and stores in a sinple array
public class FloorDelivery {
	public static int[] FloorDeliverySchedule(int numberoffloors)
	{
		Scanner sc = new Scanner(System.in);
		int[] floordel = new int[numberoffloors];
	
		boolean duplicate;
		int NumberofDay = 0 ;
		int inputNumber = 0;
	//loop the number of times the floor in the number of days
		for (int i = 0 ; i < floordel.length; i++)
		{
			duplicate = false;
			NumberofDay = i+1;
			System.out.println("Enter the floor size given on day :" + NumberofDay);
			inputNumber  = 	 sc.nextInt();
		//check if the floor delivered on the day is already delivered or not
			for (int j = 0 ; j < i+1; j++)
			{
				if (floordel[j] == inputNumber)
				{
					duplicate = true;
				}
			}
			if (duplicate == false)
			{
				// check if the floor value is with in the bounds of one and the total number of floors
				if (inputNumber <1 || inputNumber > numberoffloors)
				{
					System.out.println("Enter a Value betwee 1 and " + numberoffloors);
					i=i-1;
				}
				else
				{
					floordel[i] = inputNumber;
				}
			}
			else
			{
				i = i-1;
				System.out.println("Floor already Delivered !!!");
			}
			
		}		
		return floordel;
	}
}
