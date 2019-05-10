/*******************************************************************************
Name: Sarah Redmon
Date: 1/23/19
Instructor: Ms. Tucker
Class: Gas
Purpose: To show the total amount and cost of KWH in a GUI
*******************************************************************************
*/

import javax.swing.JFrame;
import javax.swing.*;

public class Gas
{
    public static void main(String[] args) {
        /*------------------------------------------------------------------------------
        Creates and displays the GUI of the program
        ------------------------------------------------------------------------------
        */
        JFrame frame = new JFrame("Gas Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GasPanel panel = new GasPanel();
        frame.getContentPane().add(new GasPanel());
        
        frame.pack();
        frame.setVisible(true);
    }
}