	import java.util.Scanner;

	public class HomeWork333 {

		public static void main(String[] args)
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the weight and price for package 1: ");
			double packageOneWeight = input.nextDouble();
			double packageOnePrice = input.nextDouble();
			
			System.out.println("Enter the weight and price for package 2: ");
			double packageTwoWeight = input.nextDouble();
			double packageTwoPrice = input.nextDouble();
			
			double packageOneCost = packageOneWeight / packageOnePrice;
			double packageTwoCost = packageTwoWeight / packageTwoPrice;
			
			if(packageOneCost > packageTwoCost)
			{
				System.out.println("Package 1 is better.");
			}else if(packageOneCost < packageTwoCost)
			{
				System.out.println("Package 2 is better. ");
			}else{
				System.out.println("Both are same. ");
			}
			input.close();
		}// end of main method
	}// end of class

