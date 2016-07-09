import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		System.out.println("Welcome to Pooja's Handy Calculator!");
		Scanner input = new Scanner(System.in);
		int userOperationChoice;

		do {
			// Asking user to choose operation.
			System.out.println("\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Exit\nWhat would you like to do?");
			userOperationChoice = getUserChoice(input);
			try {
				if (userOperationChoice != 5) {
					float[] userNumbers;
					float result;
					switch (userOperationChoice) {
					case 1:
						System.out.print("Enter any two float Numbers to add, separated by a space: ");
						userNumbers = getUserInput(input);
						result = add(userNumbers[0], userNumbers[1]);
						printResult("addition", userNumbers[0], userNumbers[1], result);
						break;
					case 2:
						System.out.print("Enter any two float Numbers to subtract, separated by a space: ");
						userNumbers = getUserInput(input);
						result = subtract(userNumbers[0], userNumbers[1]);
						printResult("subtraction", userNumbers[0], userNumbers[1], result);
						break;
					case 3:
						System.out.print("Enter any two float Numbers to multiply, separated by a space: ");
						userNumbers = getUserInput(input);
						result = multiply(userNumbers[0], userNumbers[1]);
						printResult("multiplication", userNumbers[0], userNumbers[1], result);
						break;
					case 4:
						System.out.print("Enter any two float Numbers to divide, separated by a space: ");
						userNumbers = getUserInput(input);
						result = handleDivision(input, userNumbers[0], userNumbers[1]);
						printResult("division", userNumbers[0], userNumbers[1], result);
						break;
					}// End of switch block.
					System.out.println("\nPress enter key to continue");
					input.nextLine();
				} // End of outer if block.
			} catch (Exception ex) {
				// Exceptions thrown during operation.
				System.out.println("Could not perform calculation: " + ex.getMessage());
			}

		} while (userOperationChoice != 5);

		System.out.println("Thank you for using Pooja's Handy Calculator!");
		input.close();
	}// End of main method

	private static float[] getUserInput(Scanner input) {
		while (true) {
			try {
				String userInputNumbers = input.nextLine();
				float[] userNumbers = processUserNumbers(userInputNumbers);
				return userNumbers;
			} catch (Exception e) {
				System.out.println("You have entered invalid floats, please re-enter:");
			}
		} // End of while loop.
	}// End of getUserInput method.

	private static int getUserChoice(Scanner input) {
		// getUserChoice method will get input from user and check whether user's choice is valid.
		// The user is prompted until he enters a valid input.
		String userChoice = null;
		while (true) {
			userChoice = input.nextLine();
			if (userChoice != null) {

				if (userChoice.equals("1") || userChoice.equalsIgnoreCase("Addition")) {
					return 1;
				} else if (userChoice.equals("2") || userChoice.equalsIgnoreCase("Subtraction")) {
					return 2;
				} else if (userChoice.equals("3") || userChoice.equalsIgnoreCase("Multiplication")) {
					return 3;
				} else if (userChoice.equals("4") || userChoice.equalsIgnoreCase("Division")) {
					return 4;
				} else if (userChoice.equals("5") || userChoice.equalsIgnoreCase("Exit")) {
					return 5;
				}
			}
			System.out.println("You have entered and invalid choice, please re-enter your choice : ");
		} // End of while loop.
	}// End of getUserChoice method.

	private static float[] processUserNumbers(String input) throws Exception {
		//This method will process the user input to extract two floating point numbers.
		String[] inputNumbers = input.split(" ");
		if (inputNumbers.length != 2) {
			throw new Exception("Invalid input");
		}
		float firstNumber = Float.parseFloat(inputNumbers[0]);
		float secondNumber = Float.parseFloat(inputNumbers[1]);

		return new float[] { firstNumber, secondNumber };
	}// End of processUserNumber method.

	private static float add(float x, float y) {
		float addResult = x + y;
		return addResult;
	}// End of add method.

	private static float subtract(float x, float y) {
		float subResult = x - y;
		return subResult;
	}// End of subtract method.

	private static float multiply(float x, float y) {
		float multiResult = x * y;
		return multiResult;
	}// End of multiply method.

	private static float handleDivision(Scanner input, float x, float y) {
		try {
			return divide(x, y);
		} catch (IllegalArgumentException e) {
			System.out.println("You cannot divide by zero, please re-enter both floats: ");
		}
		// Control comes here when the exception is caught once.
		// We give user another chance to enter both floats.
		float[] newInputs = getUserInput(input);
		return divide(newInputs[0], newInputs[1]);
	}// End of handleDivision method.

	private static float divide(float x, float y) {
		if (y == 0) {
			throw new IllegalArgumentException("Cannot divide by zero");
		} else
			return x / y;
	}// End of divide method

	private static void printResult(String operation, float firstNumber, float secondNumber, float result) {
		System.out.println("The " + operation + " of " + firstNumber + " and " + secondNumber + " is: " + String.format("%.2f", result));
	}// End of printResult method.

}// End of class.
