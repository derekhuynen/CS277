package DerekHuynen.Labs.IOExceptions;

import javax.swing.*;
import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Scanner;


public class IOExceptionRunner {
    /*
     * Read the next two double precision numbers from the scanner that we get,
     * and make them into a Point instance.  Check to see that we can get both
     * the x and the y coordinates from the scanner.  Throw a IllegalArgumentException
     * if you cannot get two double precision numbers out of the scanner.
     * @param	line	The scanner that has the current line of input.  The caller
     * 					reads in a line of text from the input file, then creates a
     * 					scanner on that line of text, all by itself.  Not the whole file.
     * 					Then passes that scanner to this routine to get two double
     * 					precision values.
     * @return			A new instance of Point.
     */
    public static Point getNextPoint(Scanner line) {
        //There may be no more double precision numbers left, just one or two.
        if(!line.hasNextInt())
            throw new NullPointerException("Not enough Vertices");
        int x = line.nextInt();

        if(!line.hasNextInt())
            throw new NullPointerException("Not enough Vertices");
        int y = line.nextInt();
        //Throw the IllegalArgumentException if you have < 2 double precision numbers


        return new Point(x, y);
        //left in the scanner.
    }

    /**
     * Find the area of the triangle, given the verticies that the user passes in.
     *
     * @param vertices An array of three Points that are the corners of the triangle.
     *                 The order is unimportant.  Note that this does not check to
     *                 make sure that there are exactly three.
     * @return The area of the triangle, using Heron's formula.
     */
    public static double area(Point[] vertices) {
        double side1, side2, side3;
        //Find the length of each of the sides of the triangle
        side1 = vertices[0].distance(vertices[1]);
        side2 = vertices[1].distance(vertices[2]);
        side3 = vertices[2].distance(vertices[0]);

        //s is an intermediate value needed by Heron's formula
        double s = (side1 + side2 + side3) / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner in = null;                //Input file
        boolean foundInFile = false;            //Flag that we don't have an input file.
        do {

            try {
                System.out.print("Enter a file name? ");
                Scanner userInput = new Scanner(System.in);

                File myObj = new File(userInput.nextLine() + ".txt");
                if (myObj.exists()) {
                    in = new Scanner(myObj);
                    foundInFile = true;

                } else {
                    throw new FileNotFoundException("File doesn't exist");
                }
            } catch (FileNotFoundException e) {
                System.out.printf("An error occurred. %s\n\n", e);
            }

        } while (!foundInFile);

        boolean foundOutFile = false;            //Flag that we don't have an outpout file
        PrintWriter out = null;                //Output file
        do {

            try {
                System.out.print("Enter File Path: ");
                String filePath = new Scanner(System.in).nextLine();
                System.out.print("Enter File Name: ");
                String fileName = new Scanner(System.in).nextLine() + ".txt";


                if (!isValidPath(filePath))
                    throw new FileNotFoundException("File doesn't exist");


                out = new PrintWriter(fileName);
                foundOutFile = true;


            } catch (IOException e) {
                System.out.printf("An error occurred. %s\n\n", e);
            }


        } while (!foundOutFile);


        String line;
        //The current line of the ASCII text file
        Point[] vertices = new Point[3];        //The array of triangle vertices
        while (in.hasNextLine()) {
            line = in.nextLine();
            System.out.println("Line: " + line);
            Scanner thisLine = new Scanner(line);
            boolean success = false;
            for (int i = 0; i < 3; i++) {
                //Use getNextPoint to read the next point from the thisLine scanner.
                vertices[i] = getNextPoint(thisLine);
                //Once you have all three points read in, set success to be true.
                if(i == 2 )
                    success = true;
            } // End of reading in the vertices
            if (success) {                //Output the area to the output file.

                out.write(String.format("Next area: %.2f\n",area(vertices)));

            }
        }
        in.close();
        out.close();
        System.out.println("Completed satisfactorily.");
    }

    public static boolean isValidPath(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }
}
