/* Copyright (c) 2007-2014 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package turtle;

import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
        turtle.forward(50);
        turtle.turn(90);
        turtle.forward(50);
        turtle.turn(90);
        turtle.forward(50);
        turtle.turn(90);
        turtle.forward(50);
        
    }

    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {
        return ((sides-2)*180.0)/sides;
    }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
        return (int)(Math.round(360/(180-angle)));
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
        for(int i = 0; i<sides; i++) {
        	turtle.forward(sideLength);
        	turtle.turn(180-TurtleSoup.calculateRegularPolygonAngle(sides));
        }
    }

    /**
     * Given the current direction, current location, and a target location, calculate the heading
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentHeading. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentHeading current direction as clockwise from north
     * @param currentX currentY current location
     * @param targetX targetY target point
     * @return adjustment to heading (right turn amount) to get to target point,
     *         must be 0 <= angle < 360.
     */
    public static double calculateHeadingToPoint(double currentHeading, int currentX, int currentY,
                                                 int targetX, int targetY) {
        int headingX = targetX - currentX;
        int headingY = targetY - currentY;
        double angle = Math.toDegrees(Math.atan2(headingX, headingY));
        if (angle == currentHeading) {
            return angle;
        }
        else if (angle > currentHeading){
            return angle - currentHeading;
        }
        else {
            return 360 - (currentHeading - angle);
        }
    }

    /**
     * Given a sequence of points, calculate the heading adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateHeadingToPoint() to implement this function.
     *
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of heading adjustments between points, of size (# of points) - 1.
     */
    public static List<Double> calculateHeadings(List<Integer> xCoords, List<Integer> yCoords) {
        double prevHeading = calculateHeadingToPoint(0, xCoords.get(0), yCoords.get(0),
                xCoords.get(1), yCoords.get(1));
        ArrayList<Double> list = new ArrayList<>();
        list.add(prevHeading);
        if(xCoords.size() == 2) {
           return list;
        }
        else {
            for (int i = 2; i < xCoords.size(); i++) {
                double nextHeading = calculateHeadingToPoint(prevHeading, xCoords.get(i-1), yCoords.get(i-1),
                        xCoords.get(i), yCoords.get(i));
                list.add(nextHeading);
                prevHeading = nextHeading;
            }
            return list;
        }
    }

    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * We'll be peer-voting on the different images, and the highest-rated one will win a prize. 
     * 
     * @param turtle the turtle context
     */
    public static void drawPersonalArt(Turtle turtle) {
    	final int AMOUNT_OF_SIDES = 3;
    	final int AMOUNT_OF_SHAPES = 100; //amount of shapes per quadrant.
    	for(int i = 0; i < AMOUNT_OF_SHAPES; i++) {
    		for (int j = 0; j<AMOUNT_OF_SIDES; j++) {
	    		drawRegularPolygon(turtle, AMOUNT_OF_SIDES, i*AMOUNT_OF_SIDES);
	    		turtle.turn(360/AMOUNT_OF_SIDES);
    		}
    	}
    	for (int j =0; j<AMOUNT_OF_SIDES; j++) {
	    	for (int i = 0; i < AMOUNT_OF_SHAPES; i++) {
	    		drawRegularPolygon(turtle, 10, i + 1);
	    	}
	    	turtle.turn(120);
    	}
    	
    }

    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();

        //drawSquare(turtle, 40);
        //drawSquare(turtle, 40);
        drawPersonalArt(turtle);
        
        // draw the window
        turtle.draw();
    }

}
