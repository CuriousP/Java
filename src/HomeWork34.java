
public class HomeWork34 {
	
	public static void main(String[] args)
	{
		double random = Math.random() * 12; //Math.random() generates a number between 0.0 & 1.0 
		
		int randomInt = (int) Math.round(random); //Math.round() will round the random double value
		
		System.out.println("Random number between 1 and 12 is " + randomInt);
		
		switch (randomInt) {
		case 1:
			System.out.println("January");
			break;

		case 2:
			System.out.println("February");
			break;
			
		case 3:
			System.out.println("March");
			break;
		
		case 4:
			System.out.println("April");
			break;
			
		case 5:
			System.out.println("May");
			break;
			
		case 6:
			System.out.println("June");
			break;
			
		case 7:
			System.out.println("July");
			break;
			
		case 8:
			System.out.println("August");
			break;
			
		case 9:
			System.out.println("September");
			break;
			
		case 10:
			System.out.println("October");
			break;
			
		case 11:
			System.out.println("November");
			break;
			
		case 12:
			System.out.println("December");
			break;
			
		default:
			System.out.println("Invalid random int");
			break;
		}		
	}//End of main method


}// End of class
