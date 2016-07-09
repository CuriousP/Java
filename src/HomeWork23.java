import java.util.Scanner;

public class HomeWork23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	System.out.print("Enter Amount that you want to save and see your total saving amount after 6 months : ");
		Scanner input = new Scanner(System.in);
		double userAmount = input.nextDouble();
		double interest = 1.00417;
		
		if( userAmount >= 0 )
		{
			double amt = userAmount * interest;
			System.out.println(String.format("After 1 month, the value in the account becomes: $ %.2f", amt));
			
			amt = (userAmount + amt) * interest;
			System.out.println(String.format("After 2 month, the value in the account becomes: $ %.2f", amt));
			
			amt = (userAmount + amt) * interest;
			System.out.println(String.format("After 3 month, the value in the account becomes:$ %.2f" , amt));
			
			amt = (userAmount + amt) * interest;
			System.out.println(String.format("After 4 month, the value in the account becomes: $ %.2f" , amt));
			
			amt = (userAmount + amt) * interest;
			System.out.println(String.format("After 5 month, the value in the account becomes: $ %.2f" , amt));
			
			amt = (userAmount + amt) * interest;
			//System.out.println("when you save $" + userAmount + " per month");
			System.out.println(String.format("Your Saving Amount afetr 6 months will be :$ %.2f" , amt));
		} 
		else
		{
			System.out.println("Amount can not be negative. Program will end");
		}
		input.close();
	}// end of main method
		
}// end of class
