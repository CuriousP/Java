import java.util.Scanner;

public class HomeWork315 {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		double digit = Math.random() * 9;
		int firstLotteryDigit = (int) Math.round(digit);
		
		digit = Math.random() * 9;
		int secondLotteryDigit = (int) Math.round(digit);
		
		digit = Math.random() * 9;
		int thirdLotteryDigit = (int) Math.round(digit);
		
		int lotteryNumber = firstLotteryDigit * 100 + secondLotteryDigit * 10 + thirdLotteryDigit;
		
		System.out.println("Lottery number is : " + lotteryNumber);
		
		System.out.println("Enter your ticket number: ");
		int ticketNumber = input.nextInt();
		int customerTicketNumber = ticketNumber;
		if(100 <= ticketNumber && ticketNumber <= 999){
			int thirdTicketNumber = ticketNumber % 10;
			ticketNumber = ticketNumber / 10;
			
			int secondTicketNumber = ticketNumber % 10;
			ticketNumber = ticketNumber / 10;
			
			int firstTicketNumber = ticketNumber % 10;
			
			if(lotteryNumber == customerTicketNumber){
				System.out.println("You won $10,000!!");
			}else if((firstLotteryDigit == secondTicketNumber || firstLotteryDigit == thirdTicketNumber) &&
					(secondLotteryDigit == firstTicketNumber || secondLotteryDigit == thirdTicketNumber) &&
					(thirdLotteryDigit == firstTicketNumber || thirdLotteryDigit == secondTicketNumber)){
				
				System.out.println("You won $3000!!");
			}else if((firstLotteryDigit == secondTicketNumber || firstLotteryDigit == thirdTicketNumber) ||
					(secondLotteryDigit == firstTicketNumber || secondLotteryDigit == thirdTicketNumber) ||
					(thirdLotteryDigit == firstTicketNumber || thirdLotteryDigit == secondTicketNumber)){
				System.out.println("You won $1000!!");
			}			
		}else{
			System.out.println("Enter a valid three digit ticket number.");
		}
		
		input.close();
	}//End of main method
}// End of class

