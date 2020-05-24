package DerekHuynen.Midterm;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Reverse Movie
 * @author	Derek Huynen
 * @date	3/26/2020
 */
public class ReverseMovie {


    public static void main(String[] args) {

        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Movie1", "derek", 1994));
        movies.add(new Movie("Movie2", "Jake", 1995));
        movies.add(new Movie("Movie3", "Gordi", 1996));
        movies.add(new Movie("Movie4", "Kenji", 1998));

        ReverseMovie.output(movies);
        movies.clear();
        movies = ReverseMovie.input();
        Collections.reverse(movies);
        ReverseMovie.output(movies);
        movies.clear();
        movies = ReverseMovie.input();

        System.out.println("Proved I reversed the order");
        for(Movie movie : movies){
            System.out.println(movie);
        }
    }


    /**
     * Output Stream IO to stream.bin
     * @param movies being added to
     */
    public static void output (List<Movie> movies){

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\DerekHuynen\\Midterm\\stream.bin"))) {

            for( Movie movie : movies ){
                System.out.println(movie);
                out.writeObject (movie);
            }


        } catch (IOException e) {
            System.out.println("Unable to access outupt stream file");
            e.printStackTrace();
        }
    }

    /**
     * get input from Stream IO
     * @return
     */
    public static ArrayList<Movie> input(){
        ArrayList<Movie> movies = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream (new FileInputStream("src\\DerekHuynen\\Midterm\\stream.bin"))){

            Movie Clone = null;
            try {
                boolean stillReading = true;
                while (stillReading) {
                    try {
                        Clone = (Movie) in.readObject();
                        movies.add(Clone);

                    } catch (EOFException EOFE) {
                        System.out.println("Found the end of the file.");
                        stillReading = false;		//Exit stage left
                    }
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Unable to find the class that you are reading in.");
                e.printStackTrace();
            }

        } catch (IOException e) {
            System.out.println ("Unable to access input stream file");
            e.printStackTrace();
        }

        return movies;
    }

}
