import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/***
 * 
 * @author Pooja
 * This file contains the following classes:
 * LetterGrader
 * Scores
 * ClassScore
 * StudentScore
 * GraderImpl 
 * 
 * Following interfaces:
 * IGrader
 */

public class LetterGrader {

	private String inputFileName;
	
	private String outputFileName;
	
	/**
	 * Input student score list stores the scores of 
	 * each student given in input file.
	 */
	List<StudentScore> inputStudentScoreList;
	
	/**
	 * Student grade list stores the scores along with 
	 * the letter grades for each student.
	 */
	List<StudentScore> studentGradeList;
	
	Scanner input;
	
	PrintWriter output;
	
	IGrader grader;
	
	/***
	 * @param inputFile
	 * @param outputFile
	 */
	public LetterGrader(String inputFile, String outputFile)
	{
		this.inputFileName = inputFile;
		this.outputFileName = outputFile;
		this.inputStudentScoreList = new ArrayList<StudentScore>();
		this.studentGradeList = new ArrayList<StudentScore>();
	}
	
	/***
	 * Reads the scores from the input files.
	 * Parses the scores into an object and stores it in 
	 * a list.
	 */
	public void readScore()
	{
		File inputFile = new File(this.inputFileName);
		if (!inputFile.exists()) {
			System.out.println("Input file " + this.inputFileName + " does not exist");
			System.exit(2);
		}			
		
		try{
			this.input = new Scanner(inputFile);
			
			// In the while loop below,
			// get each line, parse the object and store it in
			// the list.
			while (input.hasNextLine()) {
				String line = input.nextLine();
				StudentScore studentGrade = this.parseStudentGrade(line);
				this.inputStudentScoreList.add(studentGrade);
			}					
		}catch(IOException e)
		{
			System.out.println("Error reading from input file: " + this.inputFileName);
			System.exit(3);
		}
		catch(Exception e)
		{
			System.out.println("Error reading data from input file: " + this.inputFileName);
			System.exit(3);
		}		
	}
	
	/***
	 * This is a private method that reads the input line,
	 * splits it to get the student name and scores. 
	 * These values are used to construct the StudentScore object.
	 * @param line from input file
	 * @return Student Score
	 */
	private StudentScore parseStudentGrade(String line)
	{
		String[] values = line.split(",");
		
		StudentScore s = new StudentScore(values[0].trim(), 
				Double.parseDouble(values[1].trim()), 
				Double.parseDouble(values[2].trim()), 
				Double.parseDouble(values[3].trim()),
				Double.parseDouble(values[4].trim()),
				Double.parseDouble(values[5].trim()),
				Double.parseDouble(values[6].trim()),
				Double.parseDouble(values[7].trim()));
		
		return s;
	}
	
	/***
	 * This method calculates the letter grade for
	 * each student and stores it in a list.
	 */
	public void calcLetterGrade()
	{        		
		this.grader = new GraderImpl(this.inputStudentScoreList);
		this.studentGradeList = this.grader.processLetterGrades();		
	}
	
	/***
	 * This method prints the letter grades for each student
	 * to the output file.
	 */
	public void printGrade()
	{
		String format = "%20s:%10s";
		try{
			output = new PrintWriter(this.outputFileName);
			Collections.sort(this.inputStudentScoreList, 
					new Comparator<StudentScore>(){
						public int compare(StudentScore s1, StudentScore s2) {
							return s1.getName().compareToIgnoreCase(s2.getName());
				}});			
			output.println("Letter grade for " + this.inputStudentScoreList.size() + " students given in " + this.inputFileName + " is:");
			output.println();
			for(StudentScore s : this.inputStudentScoreList){
				output.print(String.format(format, s.getName(), s.getLetterGrade()));
				output.println();
			}			
		}catch(Exception e){
			System.out.println("Error writing to output file: " + e.getMessage());
			System.exit(4);
		}		
	}
	
	/***
	 * This method displays the minimum, maximum and average
     * of the scores.
	 */
	public void displayAverages()
	{		
		ClassScore minimumClassScore = this.grader.getMinimumScores();
		ClassScore maximumClassScore = this.grader.getMaximumScores();
		ClassScore averageClassScore = this.grader.getAverageScores();
	
		System.out.println("Letter grade has been calculated for students listed in input file " + this.inputFileName +
				" and written to output file " + this.outputFileName);
		String headerFormat = "%10s%10s%10s%10s%10s%10s%10s%10s";
		String scoreFormat = "%10s%10s%10s%10s%10s%10s%10s%10s";
		
		System.out.println("\nHere are the class averages:");
		System.out.format(headerFormat, "", "Q1", "Q2", "Q3", "Q4", "Mid1", "Mid2", "Final");
		System.out.println();
		System.out.format(scoreFormat, "Average", 
				this.formatDecimals(averageClassScore.getQuiz1Score()), 
				this.formatDecimals(averageClassScore.getQuiz2Score()), 
				this.formatDecimals(averageClassScore.getQuiz3Score()),
				this.formatDecimals(averageClassScore.getQuiz4Score()),
				this.formatDecimals(averageClassScore.getMidterm1Score()), 
				this.formatDecimals(averageClassScore.getMidterm2Score()),
				this.formatDecimals(averageClassScore.getFinalScore()));
		
		System.out.println();
		System.out.format(scoreFormat, "Minimum", 
				this.formatDecimals(minimumClassScore.getQuiz1Score()), 
				this.formatDecimals(minimumClassScore.getQuiz2Score()), 
				this.formatDecimals(minimumClassScore.getQuiz3Score()),
				this.formatDecimals(minimumClassScore.getQuiz4Score()),
				this.formatDecimals(minimumClassScore.getMidterm1Score()), 
				this.formatDecimals(minimumClassScore.getMidterm2Score()),
				this.formatDecimals(minimumClassScore.getFinalScore()));
		
		System.out.println();
		System.out.format(scoreFormat, "Maximum", 
				this.formatDecimals(maximumClassScore.getQuiz1Score()), 
				this.formatDecimals(maximumClassScore.getQuiz2Score()), 
				this.formatDecimals(maximumClassScore.getQuiz3Score()),
				this.formatDecimals(maximumClassScore.getQuiz4Score()),
				this.formatDecimals(maximumClassScore.getMidterm1Score()), 
				this.formatDecimals(maximumClassScore.getMidterm2Score()),
				this.formatDecimals(maximumClassScore.getFinalScore()));
	}
	
	/***
	 * Removes the trailing zeros of the input is a whole number.
	 * @param score
	 * @return formated score
	 */
	private String formatDecimals(double score)
	{
		if(score == (int) score){
			return String.format("%d", (int)score);
		}else{
			return String.format("%.2f", score);
		}
	}
	
	/***
	 * This method performs cleanup of the resources used
	 * to read and write to files.
	 */
	public void doCleanup()
	{
		if(this.input != null){
			this.input.close();
		}
		
		if(this.output != null){
			this.output.close();
		}
	}
}

/***
 * This is an abstract class of scores with its getters.
 * Here the scores are of type 'double' to support scores with decimal points.
 */
abstract class Scores {

    protected double quiz1;
	
    protected double quiz2;
	
    protected double quiz3;
	
    protected double quiz4;
	
    protected double midterm1;
	
    protected double midterm2;
	
    protected double finalScore;
	
	public double getQuiz1Score()
	{
		return this.quiz1;
	}
	
	public double getQuiz2Score()
	{
		return this.quiz2;
	}
	
	public double getQuiz3Score()
	{
		return this.quiz3;
	}
	
	public double getQuiz4Score()
	{
		return this.quiz4;
	}
	
	public double getMidterm1Score()
	{
		return this.midterm1;
	}
	
	public double getMidterm2Score()
	{
		return this.midterm2;
	}
	
	public double getFinalScore()
	{
		return this.finalScore;
	}	
}

/***
 * This class represents a set of score for the university class.
 * This class inherits from Scores. 
 * The object of this class will be used to contain minimum of each quiz, mid-term and final.
 * Similarly this class can be initialized to contain maximum scores for each quiz, mid-term and final
 * and also for averages. This class provides a uniform way to store class scores.
 */
class ClassScore extends Scores{

	public ClassScore(double quiz1, double quiz2, double quiz3, double quiz4, double midterm1, double midterm2, double finalScore)
	{		
		this.quiz1 = quiz1;
		this.quiz2 = quiz2;
		this.quiz3 = quiz3;
		this.quiz4 = quiz4;
		this.midterm1 = midterm1;
		this.midterm2 = midterm2;
		this.finalScore = finalScore;
	}
}

/**
 * This class represents the Student's score and inherits from Scores.
 */
class StudentScore extends Scores{	
	
    private String name;
	
	private String letterGrade;	
	
	public String getName()
	{
		return this.name;
	}
	
	public String getLetterGrade()
	{
		return this.letterGrade;
	}			
	
	public StudentScore(String name, double quiz1, double quiz2, double quiz3, double quiz4, double midterm1, double midterm2, double finalScore)
	{
		this.name = name;		
		this.quiz1 = quiz1;
		this.quiz2 = quiz2;
		this.quiz3 = quiz3;
		this.quiz4 = quiz4;
		this.midterm1 = midterm1;
		this.midterm2 = midterm2;
		this.finalScore = finalScore;
	}	
	
	/***
	 * This method calculates the letter grade based on the 
	 * weighted test scores.
	 */
	public void processLetterGrade()
	{
		double percentScore = this.quiz1 * 0.1 + this.quiz2 * 0.1 + this.quiz3 * 0.1 + this.quiz4 * 0.1 + this.midterm1 * 0.2 + this.midterm2 * 0.15 + this.finalScore * 0.25;
		
		if(percentScore >= 90){
			this.letterGrade = "A";
		}else if(percentScore >= 80){
			this.letterGrade = "B";
		}else if(percentScore >= 70){
			this.letterGrade = "C";
		}else if(percentScore >= 60){
			this.letterGrade = "D";
		}else{
			this.letterGrade = "F";
		}
	}
}

/***
 * This is the IGrader interface.
 * Provides methods to get the letter grades and class minimum, maximum and averages. 
 */
interface IGrader {

	public List<StudentScore> processLetterGrades();
	
	public ClassScore getMinimumScores();
	
	public ClassScore getMaximumScores();
	
	public ClassScore getAverageScores();
	
}

/***
 * This class implements the IGrader interface
 * to provide the implementation for getting the letter grades
 * and class minimum, maximum and averages.
 */
class GraderImpl implements IGrader{

	private List<StudentScore> studentScoreList;
	
	// Here are lists for the quiz, mid-term and final scores of all students.
	// These lists will be used to calculate the minimum, maximum and average
	// for each of the quiz, mid-term and final.
	private List<Double> quiz1Scores;
	private List<Double> quiz2Scores;
	private List<Double> quiz3Scores;
	private List<Double> quiz4Scores;
	private List<Double> midterm1Scores;
	private List<Double> midterm2Scores;
	private List<Double> finalScores;
	
	public GraderImpl(List<StudentScore> studentScoreList)
	{
		this.studentScoreList = studentScoreList;
		
		this.quiz1Scores = new ArrayList<Double>();
		this.quiz2Scores = new ArrayList<Double>();
		this.quiz3Scores = new ArrayList<Double>();
		this.quiz4Scores = new ArrayList<Double>();
		this.midterm1Scores = new ArrayList<Double>();
		this.midterm2Scores = new ArrayList<Double>();
		this.finalScores = new ArrayList<Double>();
		
		for(StudentScore s : this.studentScoreList){
			this.quiz1Scores.add(s.getQuiz1Score());
			this.quiz2Scores.add(s.getQuiz2Score());
			this.quiz3Scores.add(s.getQuiz3Score());
			this.quiz4Scores.add(s.getQuiz4Score());
			this.midterm1Scores.add(s.getMidterm1Score());
			this.midterm2Scores.add(s.getMidterm2Score());
			this.finalScores.add(s.getFinalScore());
		}
	}	

	@Override
	public List<StudentScore> processLetterGrades() {				
		for(StudentScore s : this.studentScoreList){
			s.processLetterGrade();
		}
		
		return this.studentScoreList;
	}

	/***
	 * Gets the minimum class score for all quiz, mid-term and final.
	 */
	@Override
	public ClassScore getMinimumScores() {
		double quiz1MinScore = this.getMinimum(this.quiz1Scores);
		double quiz2MinScore = this.getMinimum(this.quiz2Scores);
		double quiz3MinScore = this.getMinimum(this.quiz3Scores);
		double quiz4MinScore = this.getMinimum(this.quiz4Scores);
		double midterm1MinScore = this.getMinimum(this.midterm1Scores);
		double midterm2MinScore = this.getMinimum(this.midterm2Scores);
		double finalMinScore = this.getMinimum(this.finalScores);
		
		return new ClassScore(quiz1MinScore, quiz2MinScore, quiz3MinScore, quiz4MinScore, midterm1MinScore, midterm2MinScore, finalMinScore);
	}

	/***
	 * Gets the maximum class score for all quiz, mid-term and final.
	 */
	@Override
	public ClassScore getMaximumScores() {
		double quiz1MaxScore = this.getMaximum(this.quiz1Scores);
		double quiz2MaxScore = this.getMaximum(this.quiz2Scores);
		double quiz3MaxScore = this.getMaximum(this.quiz3Scores);
		double quiz4MaxScore = this.getMaximum(this.quiz4Scores);
		double midterm1MaxScore = this.getMaximum(this.midterm1Scores);
		double midterm2MaxScore = this.getMaximum(this.midterm2Scores);
		double finalMaxScore = this.getMaximum(this.finalScores);
		
		return new ClassScore(quiz1MaxScore, quiz2MaxScore, quiz3MaxScore, quiz4MaxScore, midterm1MaxScore, midterm2MaxScore, finalMaxScore);
	}

    /***
     * Gets the average class score for all quiz, mid-term and final.
     * @param values
     * @return calculated average value
     */
	@Override
	public ClassScore getAverageScores() {
		double quiz1Average = this.getAverage(this.quiz1Scores);
		double quiz2Average = this.getAverage(this.quiz2Scores);
		double quiz3Average = this.getAverage(this.quiz3Scores);
		double quiz4Average = this.getAverage(this.quiz4Scores);
		double midterm1Average = this.getAverage(this.midterm1Scores);
		double midterm2Average = this.getAverage(this.midterm2Scores);
		double finalAverage = this.getAverage(this.finalScores);
		
		return new ClassScore(quiz1Average, quiz2Average, quiz3Average, quiz4Average, midterm1Average, midterm2Average, finalAverage);
	} 
	
	/***
	 * Gets the minimum of the values specified in the list.
	 * @param values
	 * @return minimum value
	 */
	private double getMinimum(List<Double> values)
	{
		if(values != null && !values.isEmpty()){
			double minimum = values.get(0);
			for(int i = 1; i < values.size(); i++){
				if(values.get(i) < minimum){
					minimum = values.get(i);
				}
			}
			
			return minimum;
		}
		
		return 0;
	}
	
	/***
	 * Gets the maximum of the values specified in the list.
	 * @param values
	 * @return maximum value
	 */
	private double getMaximum(List<Double> values)
	{
		if(values != null && !values.isEmpty()){
			double maximum = values.get(0);
			for(int i = 1; i < values.size(); i++){
				if(values.get(i) > maximum){
					maximum = values.get(i);
				}
			}
			
			return maximum;
		}
		
		return 0;
	}
	
	/***
	 * Gets the average of the values specified in the list.
	 * @param values
	 * @return average
	 */
	private double getAverage(List<Double> values)
	{
		if(values != null && !values.isEmpty()){			
			double sum = 0;
			for(int i = 0; i < values.size(); i++){
				sum = sum + values.get(i);									
			}
			
			double average = sum / values.size();
			return average;
		}
		
		return 0;
	}
}



