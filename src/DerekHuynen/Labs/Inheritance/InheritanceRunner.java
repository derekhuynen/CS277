/**
 * InheritanceRunner
 *
 * Lab: CECS277 Lab Inheritance
 *
 * @author Julien Delane
 * @author Derek Huynen
 * @version 1.00 28/01/2020
 */

package DerekHuynen.Labs.Inheritance;

import java.awt.*;

public class InheritanceRunner {
    public static void main(String [] args) {
		//It doesnt run, because getArea and getPerimeter methods doesn't exist in Rectangle class
		/*
		Rectangle rectangle = new Rectangle(1,2,3,4);
		rectangle.getArea();
		rectangle.getPerimeter();
		*/

		//It doesnt work, because getArea and getPerimeter methods doesn't exist in Rectangle class
		/*
		Rectangle betterVar = new BetterRectangle(1,2,3,4);
		betterVar.getArea();
		betterVar.getPerimeter();
		*/


		//It does work because both methods exist in BetterRectangle class.
		BetterRectangle betterClass = new BetterRectangle(1,2,3,4);
		betterClass.getArea();
		betterClass.getPerimeter();


		//It doesnt work, we create a rectangle but try to put it inside a BetterRectangle class.
		/*
		BetterRectangle BR = new Rectangle(1,2,3,4);
		BR.getArea();
		BR.getPerimeter();
		*/

		System.out.println(betterClass.toString());
    }
}
