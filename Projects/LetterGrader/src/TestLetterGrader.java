/***
 * 
 * @author Pooja
 *
 */
public class TestLetterGrader {

	/***
	 * @param args
	 * The main method
	 */
	public static void main(String[] args) {		
		try{
			if (args.length < 2) {
				System.out.println("Usage: java Exercise5 inputFile outputFile");
				System.exit(1);
			} 
						
			LetterGrader letterGrader = new LetterGrader(args[0], args[1]);
			letterGrader.readScore();
			letterGrader.calcLetterGrade();
			letterGrader.printGrade();
			letterGrader.displayAverages();
			letterGrader.doCleanup();			
		}catch(Exception e){
		    System.out.println("Program ran into exception : " + e.getMessage());	
		}		
	}		
}
