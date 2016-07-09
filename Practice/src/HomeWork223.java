	import java.util.Scanner;

	public class HomeWork223 {
		
		public static void main(String[] args)
		{
			System.out.println("Enter distance to drive: ");
			Scanner input = new Scanner(System.in);		
			double distance = input.nextDouble();
			
			System.out.println("Enter miles per gallon: ");
			double milesPerGallon = input.nextDouble();
			
			System.out.println("Enter price per gallon: ");
			double pricePerGallon = input.nextDouble();
			
			double costOfTrip = (distance/ milesPerGallon) * pricePerGallon;
			
			System.out.println(String.format("The cost of driving is $ %.2f", costOfTrip));
			input.close();
		}// End of Main method


	}//End of Class

