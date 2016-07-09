import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;

public class HomeWork22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter your Time Zone offset to GMT : ");
		Scanner input = new Scanner(System.in);
		int userOffset = input.nextInt();
		System.out.println("userOffset" + userOffset);
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		System.out.println(cal.getTime());
		cal.add(Calendar.HOUR_OF_DAY, userOffset);
		System.out.println(cal.getTime());
		input.close();
	}

}
