//Name: Rona Chan
//CS 56
//Program: Create a subclass of JPanel named RegularPolygonPanel to paint an n-sided regular
//polygon. The class contains a property named numberOfSides which specifies the number of sides
//in the polygon. The polygon is centered at the center of the panel. The size of the polygon
//is proportional to the size of the panel. Create a pentagon, hexagon, heptagon, and octagon,
//nonagon, decagon from RegularPolygonPanel and display them in a frame.

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

public class RegularPolygonPanel extends JPanel
{
    //Start at 3 because a polygon can't be drawn with 1 or 2 sides
    private int numberOfSides;
    private int numberOfPolygons;

    /*  

    public static final int PENTAGON = 5;
    public static final int HEXAGON = 6;
    public static final int HEPTAGON = 7;
    public static final int OCTAGON = 8;
    public static final int NONAGON = 9;
    public static final int DECAGON = 10;

    */

    
    public RegularPolygonPanel()
    {
        //first polygon's number of sides
       numberOfSides = 5;

       //How many polygons drawn
       numberOfPolygons = 6;
    }

    public RegularPolygonPanel(int numberOfSides)
    {
        //the least amount of sides to draw a polygon
        this.numberOfSides = 3;
        setSides(numberOfSides);
    }

    public void setSides(int numberOfSides)
    {
        this.numberOfSides = numberOfSides;
        repaint();
    }

    public int getSides()
    {
        return numberOfSides;
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(960, 200);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //find each angle of the polygon with numberOfSides number of sides
        //angle = sum of interior angles / number of sides
        
        int xCoor = 150 / 2;
        int yCoor = getHeight() / 2;
        //int radius = (getHeight()) / (2 * Math.sin(180 / numberOfSides));

        int radius = (int)((double) Math.min(150, getHeight()) * 0.4);

        //create a new Polygon
        Polygon polygon = new Polygon();

        for(int j = 0; j < numberOfPolygons; j++)
        {
            double angle = (2 * Math.PI) / (double) numberOfSides;

            for(int i = 0; i < numberOfSides; i++)
            
                //give points to draw the polygon
                polygon.addPoint((int)((double) xCoor + (double)radius * Math.cos((double)i * angle)), (int)((double)yCoor - (double)radius * Math.sin((double)i * angle)));

                //draw the polygon
                g.drawPolygon(polygon);

                //increment the number of sides
                numberOfSides++;

                //make a new polygon to draw polygon with diff number of sides
                polygon = new Polygon();

                //move the center point of the new polygon
                xCoor += 160;

        }


        /*
        g.drawPolygon(150, 150, PENTAGON);
        g.drawPolygon(150, 150, HEXAGON);
        g.drawPolygon(150, 150, HEPTAGON);
        g.drawPolygon(150, 150, OCTAGON);
        g.drawPolygon(150, 150, NONAGON);
        g.drawPolygon(150, 150, DECAGON;
        */

    }

    public static void main(String[] args)
    {
        //create a new JFrame
        JFrame win = new JFrame("Regular Polygon Panel");

        //returns container object and add componment, aka RegularPolygonPanel
        win.getContentPane().add(new RegularPolygonPanel());

        //sizes frame so contents are at or above preferred size
        win.pack();

        //Make frame visible
        win.setVisible(true);

        //Exit program after closing frame
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}


