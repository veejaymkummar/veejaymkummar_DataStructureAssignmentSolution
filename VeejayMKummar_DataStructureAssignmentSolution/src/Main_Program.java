import java.util.Scanner;
public class Main_Program {

	public static void main(String[] args) 
	
	{		
		int SelectProject= 0;
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("Select the Project you want to Run");
			System.out.println("1. Skyscapper");
			System.out.println("2. MNS Transactions - BST to Right Skewed Tree");
			System.out.println("3. Exit");
			SelectProject = sc.nextInt();
			switch (SelectProject)
			{
			case 1:
				SkyScrapper.skyscapper();
				break;
			case 2:
				MNCTransactions.transactions();
				break;
			case 3:
				System.out.println("Thank you !!!");
				break;
			default:
				break;
			}
			System.out.println("");
		}
		while(SelectProject !=3);
	sc.close();
	}
}
