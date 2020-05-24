/**
 * ChoiceQuestion class.
 * Homework Assignment:
 *
 * @author Julien Delane
 * @version 1.00 04/02/2020
 */

package DerekHuynen.Labs.Inheritance2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A question with multiple choices.
 */
public class ChoiceQuestion extends Question {
    /**
     * Possible choice of the question.
     */
    private ArrayList<String> choices;

    /**
     * Constructs a choice question with no choices.
     */
    public ChoiceQuestion() {
        super();
        choices = new ArrayList<>();
    }

    /**
     * Adds an answer choice to this question.
     *
     * @param choice  the choice to add
     * @param correct true if this is the correct choice, false otherwise
     */
    public void addChoice(final String choice, final boolean correct) {
        choices.add(choice);
        if (correct) {
            // Convert choices.size() to string
            String choiceString = "" + choices.size();
            super.setAnswer(choiceString);
        }
    }

    /**
     * Display the question and possible answers
     */
    public void display() {
        // Display the question text
        super.display();
        // Display the answer choices
        for (int i = 0; i < choices.size(); i++) {
            int choiceNumber = i + 1;
            System.out.println(choiceNumber + ": " + choices.get(i));
        }
    }

    /**
     * toString method put an object as a string.
     *
     * @return the object as a string
     */
    @Override
    public String toString() {
        return super.toString() + "\nChoiceQuestion{" +
                "choices=" + choices +
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
        if (!super.equals(o)) return false;
        ChoiceQuestion that = (ChoiceQuestion) o;
        return Objects.equals(choices, that.choices);
    }

}


