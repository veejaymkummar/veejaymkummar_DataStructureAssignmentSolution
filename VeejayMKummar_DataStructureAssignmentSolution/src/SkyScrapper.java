import java.util.Scanner;
//Main Skyscrapper program to take inputs on Number of floors
public class SkyScrapper {
	public static void skyscapper()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Project SkyScrapper");
		System.out.println("");
		System.out.println("Enter the total no of floors in the building");
		
		int NumberofFloors = 0;
		NumberofFloors = sc.nextInt();
		//Call Method to get floor delivery schedule and store in an array
		int[] PerDayFloorDelivery = FloorDelivery.FloorDeliverySchedule(NumberofFloors);
		
		//Construct the sky scrapper basis the floor delivery schedule
		Floor_Construction.ConstructFloor(PerDayFloorDelivery);
	
	}
}
