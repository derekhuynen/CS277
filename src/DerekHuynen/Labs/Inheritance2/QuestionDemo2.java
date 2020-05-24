/**
 * QuestionDemo2 class.
 * Homework Assignment:
 *
 * @author Julien Delane
 * @version 1.00 04/02/2020
 */

package DerekHuynen.Labs.Inheritance2;


import java.util.Scanner;

/**
 * This program shows a simple quiz with two choice questions.
 */
public class QuestionDemo2 {
    public static void main(String[] args) {
        Question questions[] = new Question[3];
        questions[0] = new ChoiceQuestion();
        questions[1] = new ChoiceQuestion();
        questions[2] = new TrueFalseQuestion();

        questions[0].setText("What was the original name of the Java language?");
        ((ChoiceQuestion)questions[0]).addChoice("*7", false);
        ((ChoiceQuestion)questions[0]).addChoice("Duke", false);
        ((ChoiceQuestion)questions[0]).addChoice("Oak", true);
        ((ChoiceQuestion)questions[0]).addChoice("Gosling", false);

        questions[1].setText("In which country was the inventor of Java born?");
        ((ChoiceQuestion)questions[1]).addChoice("Australia", false);
        ((ChoiceQuestion)questions[1]).addChoice("Canada", true);
        ((ChoiceQuestion)questions[1]).addChoice("Denmark", false);
        ((ChoiceQuestion)questions[1]).addChoice("United States", false);

        ((TrueFalseQuestion)questions[2]).setAnswer(false);
        questions[2].setText("It is possible to override every single method  that  you  inherit from a supertype.");

        for (Question question : questions) {
            presentQuestion(question);
        }
    }

    /**
     * Presents a question to the user and checks the response.
     *
     * @param q the question
     */
    public static void presentQuestion(final Question q) {
        q.display();
        System.out.print("Your answer: ");
        Scanner in = new Scanner(System.in);
        String response = in.nextLine();
        System.out.println(q.checkAnswer(response));
    }
}
