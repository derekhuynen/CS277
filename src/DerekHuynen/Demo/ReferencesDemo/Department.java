package DerekHuynen.Demo.ReferencesDemo;

/**
 * List of department names.
 * @author	David Brown
 * @date	07/24/2019
 */
public enum Department {
    CECS, ENGLISH, MATH, CHEMICAL_ENGINEERING, BIOMEDICAL_ENGINEERING;

    /**
     * Make the first character upper case (since all of the department variable names are
     * all upper case, followed by the rest of the department name in lower case.  That
     * works fine except for the department names that are abbreviations.
     * @return	A printable version of the department name.
     */
    @Override
    public String toString () {
        return this.name().substring(0, 1) +
                (this.name().substring(1, this.name().length()).toLowerCase().replace("_", " "));
    }
}
