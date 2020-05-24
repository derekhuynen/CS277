/**
 * Question class.
 * Homework Assignment:
 *
 * @author Julien Delane
 * @version 1.00 04/02/2020
 */

package DerekHuynen.Labs.Inheritance2;

import java.util.Objects;

/**
 * A question with a text and an answer.
 */
public class Question {
    /**
     * Question.
     */
    private String text;

    /**
     * Answer to the question.
     */
    private String answer;

    /**
     * Constructs a question with empty question and answer.
     */
    public Question() {
        text = "";
        answer = "";
    }

    /**
     * Sets the question text.
     *
     * @param questionText the text of this question
     */
    public void setText(final String questionText) {
        text = questionText;
    }

    /**
     * Sets the answer for this question.
     *
     * @param correctResponse the answer
     */
    public void setAnswer(final String correctResponse) {
        answer = correctResponse;
    }

    /**
     * Checks a given response for correctness.
     *
     * @param response the response to check
     * @return true if the response was correct, false otherwise
     */
    public boolean checkAnswer(final String response) {
        return response.equals(answer);
    }

    /**
     * Displays this question.
     */
    public void display() {
        System.out.println(text);
    }

    /**
     * toString method put an object as a string.
     *
     * @return the object as a string
     */
    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    /**
     * Compare this object to another.
     *
     * @param o, object to compare to
     * @return true if they are identical otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(text, question.text) &&
                Objects.equals(answer, question.answer);
    }

}


