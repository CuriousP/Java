
public class HW1 {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub

		System.out.println("      J     A     V     V    A  "); // Displaying JAVA as output
		Thread.sleep(500);
		System.out.println("      J    A A     V   V    A A  ");
		Thread.sleep(500);
		System.out.println("  J   J   AAAAA     V V    AAAAA ");
		Thread.sleep(500);
		System.out.println("  J  J   A     A     V    A     A"); 

		System.out.println("\nResult of 9.5*4.5-2.5*3/45.5-3.5 is as below"); // Performing Arithmetic operations
		double numerator = (9.5*4.5)-(2.5*3);
		double denominator = (45.5-3.5);
		double result = numerator / denominator;
		System.out.println(String.format("Result is : %.2f", result));

		System.out.println("\nArea of a Rectangle A = " +4.5 * 7.9); // L= Length(7.9) , W= Width(4.5), A= Area
		System.out.println("Perimeter of a Rectangle P = "+ 2*(4.5+7.9)); //Perimeter of rectangle P = 2(L+W)

				
	}

}
