import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TestRegularPolygonPanel extends JPanel
{
    private RegularPolygonPanel2 testPanel;

    public TestRegularPolygonPanel()
    {
        testPanel = new RegularPolygonPanel2();
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(150, 175);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }

    public static void main(String[] args)
    {
        JFrame win = new JFrame();
        win.setVisible(true);
        win.setSize(300,300);
        win.setLayout(new FlowLayout(3,3,3));
    }  
}