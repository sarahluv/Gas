/*******************************************************************************
Name: Sarah Redmon
Date: 1/23/19
Instructor: Ms. Tucker
Class: GasPanel
Purpose: To show the total amount and cost of KWH in a GUI
*******************************************************************************
*/

/*------------------------------------------------------------------------------
    FEEDBACK FROM INSTRUCTOR:
    Sarah, great job.  Your exit button will not work if the form is blank.  
    The code for exit is embedded within the if statement to check the text fields.  
    It's OK to exit at any time.  Otherwise, great work.
-------------------------------------------------------------------------------*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.text.DecimalFormat;

public class GasPanel extends JPanel
{
    /*------------------------------------------------------------------------------
    Initializes variables, JLabels, JTextFields, and JButtons for program
    ------------------------------------------------------------------------------
    */
    private int numRef, numWashDry, numOven, numMicro, numCoff, numComp, numTV;
    
    private JLabel headingLabel, refLabel, washDryLabel, ovenLabel, microLabel, coffLabel, compLabel, 
    tvLabel, KWHUsedLabel, KWHCostLabel, KWHUsedAnswer, KWHCostAnswer;
    private JTextField refAnswer, washDryAnswer, ovenAnswer, microAnswer, coffAnswer, compAnswer, 
    tvAnswer;
    private JButton calculate, clear, exit;
    
    public GasPanel()
    {
        /*------------------------------------------------------------------------------
        Asks for user's input and shows text fields along with showing a header
        ------------------------------------------------------------------------------
        */
        headingLabel = new JLabel("------------------ GAS PANEL ------------------");
       
        refLabel = new JLabel("How many refrigerators do you have? ");
        refAnswer = new JTextField(2);
        
        washDryLabel = new JLabel("How many washers/dryers do you have? ");
        washDryAnswer = new JTextField(2);
        
        ovenLabel = new JLabel("How many ranges/ovens do you have? ");
        ovenAnswer = new JTextField(2);
        
        microLabel = new JLabel("How many microwaves do you have? ");
        microAnswer = new JTextField(2);
        
        coffLabel = new JLabel("How many coffee machines do you have? ");
        coffAnswer = new JTextField(2);
        
        compLabel = new JLabel("How many computers do you have? ");
        compAnswer = new JTextField(2);
        
        tvLabel = new JLabel("How many TVs do you have? ");
        tvAnswer = new JTextField(2);

        /*------------------------------------------------------------------------------
        Button listener is added and adds in buttons, listeners, and labels
        ------------------------------------------------------------------------------
        */
        ButtonListener listener = new ButtonListener();
        
        calculate = new JButton("Calculate");
        clear = new JButton("Clear");
        exit = new JButton("Exit");
        calculate.addActionListener(new ButtonListener());
        clear.addActionListener(new ButtonListener());
        exit.addActionListener(new ButtonListener());
        
        KWHUsedLabel = new JLabel("KWH Used: ");
        KWHUsedAnswer = new JLabel("-----");
        
        KWHCostLabel = new JLabel("Total Cost: $");
        KWHCostAnswer = new JLabel("-----");
        
        /*------------------------------------------------------------------------------
        Adds in the data for calculation & display
        ------------------------------------------------------------------------------
        */
        add (headingLabel);
       
        add (refLabel);
        add (refAnswer);
        
        add (washDryLabel);
        add (washDryAnswer);
        
        add (ovenLabel);
        add (ovenAnswer);
        
        add (microLabel);
        add (microAnswer);
       
        add (coffLabel);
        add (coffAnswer);
        
        add (compLabel);
        add (compAnswer);
        
        add (tvLabel);
        add (tvAnswer);
        
        add (calculate);
        add (clear);
        add (exit);
        
        add (KWHUsedLabel);
        add (KWHUsedAnswer);
        
        add (KWHCostLabel);
        add (KWHCostAnswer);
        
        /*------------------------------------------------------------------------------
        Display options
        ------------------------------------------------------------------------------
        */
        setPreferredSize (new Dimension(275, 275));
        setBackground (Color.pink);
    }
    
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
        String refString = refAnswer.getText();
        String washdryString = washDryAnswer.getText();
        String ovenString = ovenAnswer.getText();
        String microString = microAnswer.getText();
        String coffString = coffAnswer.getText();
        String compString = compAnswer.getText();
        String tvString = tvAnswer.getText();
        if (refString.length() > 0 && washdryString.length() > 0 && ovenString.length() > 0
        && microString.length() > 0 && coffString.length() > 0 && compString.length() > 0
        && tvString.length() > 0) {
            if (event.getSource() == calculate) {
                /*------------------------------------------------------------------------------
                If calculate is clicked on
                * Initialize variables & constants
                * Set up Decimal Format
                * Receive answers, make them into strings, and turn them into number for calculations
                * Calculate and display
                ------------------------------------------------------------------------------
                */
                double KWHcost, KWHused;
                final double COSTPERKWH = 9.047e-2;
                final int KWH_REF = 57, KWH_WASHDRY = 63, KWH_OVEN = 24, KWH_MICRO = 11, KWH_COFF = 10, 
                KWH_COMP = 21, KWH_TV = 23;
                DecimalFormat format1DecimalPlace = new DecimalFormat ("####.##");
                
                numRef = Integer.parseInt(refString);
                numWashDry = Integer.parseInt(washdryString);
                numOven = Integer.parseInt(ovenString);
                numMicro = Integer.parseInt(microString);
                numCoff = Integer.parseInt(coffString);
                numComp = Integer.parseInt(compString);
                numTV = Integer.parseInt(tvString);
                
                KWHused = ((KWH_REF * numRef) + (KWH_WASHDRY * numWashDry) + (KWH_OVEN * numOven) + (KWH_MICRO * numMicro) + (KWH_COFF * numCoff) + (KWH_COMP * numComp) + (KWH_TV * numTV));
                KWHUsedAnswer.setText(format1DecimalPlace.format(KWHused));
                
                KWHcost = (COSTPERKWH * KWHused);
                KWHCostAnswer.setText(format1DecimalPlace.format(KWHcost));
           }
           
           if (event.getSource() == clear) {
               /*------------------------------------------------------------------------------
               If clear is clicked-empties text fields & places cursor over refAnswer text field 
               ------------------------------------------------------------------------------
               */
               refAnswer.requestFocusInWindow();
               refAnswer.setText("");
               washDryAnswer.setText("");
               ovenAnswer.setText("");
               microAnswer.setText("");
               coffAnswer.setText("");
               compAnswer.setText("");
               tvAnswer.setText("");
               KWHUsedAnswer.setText("-----");
               KWHCostAnswer.setText("-----");
           }
            
           if (event.getSource() == exit) {
              /*------------------------------------------------------------------------------
              If exit is clicked-closes program
              ------------------------------------------------------------------------------
              */
              System.exit(0);
           }
        } else {
            KWHUsedAnswer.setText("Invalid input");
            KWHCostAnswer.setText("Invalid input");
        }
      }
    }   
}
