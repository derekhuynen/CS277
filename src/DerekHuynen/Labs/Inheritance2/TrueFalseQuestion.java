/**
 * TrueFalseQuestion class.
 * Homework Assignment:
 *
 * @author Julien Delane
 * @version 1.00 04/02/2020
 */

package DerekHuynen.Labs.Inheritance2;

/**
 * Class that handle true/false question.
 */
public class TrueFalseQuestion extends Question {

    /**
     * Default constructor.
     */
    public TrueFalseQuestion() {
        super();
    }

    /**
     * Constructor with parameter.
     *
     * @param text,   statement
     * @param answer, answer to the statement
     */
    public TrueFalseQuestion(final String text, final boolean answer) {
        super();
        setText(text);
        setAnswer(answer);
    }

    /**
     * Set the answer to the statement.
     *
     * @param answer, answer to the statement
     */
    public void setAnswer(final boolean answer) {
        if (answer) {
            super.setAnswer("T");
        } else {
            super.setAnswer("F");
        }
    }

    /**
     * Set the question statement.
     *
     * @param text, statement
     */
    public void setText(final String text) {
        super.setText(text);
    }

    /**
     * Displays this question.
     */
    @Override
    public void display() {
        System.out.println("True (T) or False (F):");
        super.display();
    }

    @Override
    public boolean checkAnswer(final String response) {
        return super.checkAnswer("" + response.toUpperCase().charAt(0));
    }

    /**
     * toString method put an object as a string.
     *
     * @return the object as a string
     */
    @Override
    public String toString() {
        return super.toString() + "\nTrueFalseQuestion";
    }
}
