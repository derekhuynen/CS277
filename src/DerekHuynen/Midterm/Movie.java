package DerekHuynen.Midterm;

import java.io.Serializable;

/**
 * Movie
 * @author	Derek Huynen
 * @date	3/26/2020
 */
public class Movie implements Serializable{
    private String title;
    private String producer;
    private int year;

    /**
     * Constructor
     * @param title of Movie
     * @param producer Name
     * @param year of movie
     */
    public Movie (String title, String producer, int year) {
        this.title = title;
        this.producer = producer;
        this.year = year;
    }

    /**
     * Default Constructor
     */
    public Movie () {
        this.title = "Attack of the Killer Tomatoes";
        this.producer = "Wonkey films Inc.";
        this.year = 1942;
    }

    /**
     * TO String FOr Movie
     * @return Movie as a String
     */
    public String toString () {
        return "Movie - title: " + this.title + " Producer: " + this.producer +
                " Year published: " + this.year;
    }

    /**
     *
     * Override equals
     * @param Other movie object being compared
     *
     * @return True if equal
     */
    @Override
    public boolean equals (Object Other) {
        Movie movie = (Movie) Other;
        return (this.producer	== movie.producer &&
                this.title		== movie.title &&
                this.year		== movie.year);
    }
}
