package ca.centennial.assignment;
/**
 * @author Chen Feng
 */
import java.util.Scanner;

public class GradeManager {
	// correct answers
	private String[] correctAnswers;
	// student answers
	private String[][] studentAnswers;

	public static void main(String[] args) {
		// enter the answer size
		System.out.print("Enter the number of questions: ");
		Scanner reader = new Scanner(System.in);
		int number = reader.nextInt();
		GradeManager gm = new GradeManager(number);
		// create student answers
		gm.createStudentAnswers();
		// calculate student grades and scores
		gm.calculateStudentGrade();
	}

	public GradeManager(int questionNumber) {
		if (questionNumber <= 0)
			return;
		correctAnswers = new String[questionNumber];
		this.createCorrectAnswers();
	}
	
	// create correct answers
	private void createCorrectAnswers() {
		boolean inputValid = true;
		do {
			System.out
					.println("Enter the correct answers: (e.g. A, B, C, D)");
			Scanner reader = new Scanner(System.in);
			String input = reader.next();
			String[] answers = input.split(",");
			if (answers.length != this.correctAnswers.length) {
				inputValid = false;
				System.out.println("The number of answers is not equals to "
						+ this.correctAnswers.length + ". Try again!");
			} else {
				inputValid = true;
				// get the correct answers
				for (int i = 0; i < answers.length; i++) {
					this.correctAnswers[i] = answers[i];
				}
			}
		} while (!inputValid);
	}

	// enter student answers
	public void createStudentAnswers() {
		boolean inputValid = true;
		int studentNumber = 0;
		// get number of students
		do {
			try {
				System.out.println("How many students? ");
				Scanner reader = new Scanner(System.in);
				studentNumber = reader.nextInt();
				inputValid = true;
				if (studentNumber <= 0)
					throw new Exception();
			} catch (Exception e) {
				inputValid = false;
				System.out
						.println("Sorry, input value is not correct. Try again!");
			}
		} while (!inputValid);
		// get student answers
		this.studentAnswers = new String[studentNumber][this.correctAnswers.length];
		for (int i = 0; i < studentAnswers.length; i++) {
			do {
				System.out.println("Enter the answers of student " + (i + 1)
						+ ": (e.g. A, B, C, D)");
				Scanner reader = new Scanner(System.in);
				String input = reader.next();
				String[] answers = input.split(",");
				if (answers.length != this.correctAnswers.length) {
					inputValid = false;
					System.out
							.println("The number of answers is not equals to "
									+ this.correctAnswers.length + ". Try again!");
				} else {
					inputValid = true;
					// get student answers
					for (int j = 0; j < answers.length; j++) {
						this.studentAnswers[i][j] = answers[j];
					}
				}
			} while (!inputValid);
		}
	}
	// calculate the student grade
	public void calculateStudentGrade() {
		for (int i = 0; i < this.studentAnswers.length; i++) {
			// define the count of correct answers
			int correctAnswerCount = 0;
			for (int j = 0; j < this.correctAnswers.length; j++) {
				if (studentAnswers[i][j].trim().equalsIgnoreCase(correctAnswers[j])) {
					correctAnswerCount++;
				}
			}
			System.out.println("Student "
					+ (i + 1)
					+ " correct answers are: "
					+ correctAnswerCount
					+ ", score is: "
					+ this.calculateScore((double) correctAnswerCount,
							(double) this.correctAnswers.length) + "/100");
		}
	}
	// calculate the score in centesimal system 
	private int calculateScore(double correctAnswerNumber,
			double totalAnswerNumber) {
		double score = correctAnswerNumber / totalAnswerNumber * 100;
		return (int) Math.round(score);
	}
}
