import java.util.Scanner;

public class HomeWork21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter any Interger between 0 and 1000 : ");
		
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int sumOfDigits = 0;
		int userInput = number;
		
		if(number >= 0 && number <= 1000)
		{
			sumOfDigits = sumOfDigits + number % 10;
			number = number/10;
			
			if(number != 0 )
			{
				sumOfDigits = sumOfDigits + number % 10;
				number = number/10;
			}
			else
			{   
				PrintResult(sumOfDigits, userInput);
				return;
			}
			
			if(number != 0 )
			{
				sumOfDigits = sumOfDigits + number % 10;
				number = number/10;
			}
			else
			{
				PrintResult(sumOfDigits, userInput);
				return;
			}
			
			if(number != 0 )
			{
				sumOfDigits = sumOfDigits + number % 10;
				number = number/10;
			}
			else
			{
				PrintResult(sumOfDigits, userInput);
				return;
			}
			
			if(number != 0 )
			{
				sumOfDigits = sumOfDigits + number % 10;
				number = number/10;
			}
			else
			{
				PrintResult(sumOfDigits, userInput);
				return;
			}
			
		} // end of if 
		else
		{
			System.out.println("Enter Number between 0 and 1000 only ");
		}
	} // end of main method
	
	private static void PrintResult(int result, int number)
	{
		System.out.println("The sum of all digits in "+ number + " is: " + result);
	}
	
} // end of class	
	

		
		