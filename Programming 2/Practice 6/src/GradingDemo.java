
/**
   Delta College - CST 283 - Klingler & Gaddis text
   This program demonstrates the PassFailExam class.
*/

public class GradingDemo {
	public static void main(String[] args) {
		// Create the assessment(s)
		Exam exam1 = new Exam(60); // Exam 1: 60 questions
		Exam exam2 = new Exam(80); // Exam 2: 80 questions
		Exam exam3 = new Exam(200); // Exam 2: 200 questions
		Quiz quiz1 = new Quiz();
		Quiz quiz2 = new Quiz();
		FinalExam fExam = new FinalExam(203, 7);

		// Grade the work based on student results

		exam1.assess(5); // Exam 1: 5 missed
		System.out.println("Exam 1 grade is: " + exam1.getGrade());

		exam2.assess(17); // Exam 2: 17 missed
		System.out.println("Exam 2 grade is: " + exam2.getGrade());

		exam3.assess(2); // Exam 3: 2 missed
		System.out.println("Exam 3 grade is: " + exam3.getGrade());

		quiz1.assess(2); // Quiz 1: 2 missed
		System.out.println("Quiz 1 grade is: " + quiz1.getGrade());

		quiz2.assess(1); // Quiz 2: 1 missed
		System.out.println("Quiz 2 grade is: " + quiz2.getGrade());

		fExam.assess(6, 3); // Final Exam: 6 missed 3 bonus points
		System.out.println("Final Exam grade is: " + fExam.getGrade());
	}
}