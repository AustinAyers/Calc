package solution;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

/**
 * Simple calculator program.
 * 
 * @author Austin Ayers
 * @version 9/16/17
 */

public class Calculator
{
    public static final int FRAME_SIZE = 400;
    private JFrame frame;
    private JLabel resultLabel;
    private JTextField leftOperand;
    private JTextField rightOperand;

    /**
     * Constructor that builds the calculator frame.
     */
    public Calculator()
    {
        frame = new JFrame();
        frame.setLocation(100, 100);
        frame.setSize(FRAME_SIZE, FRAME_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Simple Calculator");
        initializeComponents();
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Method to initialize all the calculator components onto the frame.
     */
    public void initializeComponents()
    {

        // Create the buttons
        JButton addButton = new JButton("ADD");
        addButton.setName("ADD");
        addButton.addActionListener(new Addition());
        JButton subButton = new JButton("SUB");
        subButton.setName("SUB");
        subButton.addActionListener(new Subtraction());
        JButton multButton = new JButton("MULT");
        multButton.setName("MULT");
        multButton.addActionListener(new Multiplication());
        JButton divButton = new JButton("DIV");
        divButton.setName("DIV");
        divButton.addActionListener(new Division());

        // Create the button panel
        JPanel positPanel = new JPanel();

        // Add buttons to the panel
        positPanel.add(addButton);
        positPanel.add(subButton);
        positPanel.add(multButton);
        positPanel.add(divButton);

        // Add the panel to the bottom of the calculator window
        frame.add(positPanel, BorderLayout.PAGE_END);

        // Create new label panel and result label.
        JPanel labelPanel = new JPanel();
        resultLabel = new JLabel("Result =");

        // Add the result label to the label panel, then frame.
        labelPanel.add(resultLabel);
        frame.add(labelPanel, BorderLayout.LINE_START);

        // Create new text field panel
        JPanel textPanel = new JPanel();

        // Create new text fields
        leftOperand = new JTextField(10);
        rightOperand = new JTextField(10);

        // Add text fields to panel, then to frame
        textPanel.add(leftOperand);
        textPanel.add(rightOperand);
        frame.add(textPanel, BorderLayout.NORTH);
    }

    /**
     * Class that performs the addition function.
     */
    public class Addition implements ActionListener
    {
        /**
         * ActionEvent for addition.
         * 
         * @param e
         *            takes the listener.
         */
        public void actionPerformed(ActionEvent e)
        {
            // catch number format exception
            try
            {
                double n1 = Double.parseDouble(leftOperand.getText());
                double n2 = Double.parseDouble(rightOperand.getText());
                double ans = n1 + n2;
                resultLabel.setText("Result = " + ans);
            }
            catch (Exception ee)
            {
                resultLabel.setText("Result = Error");
            }
        }
    }

    /**
     * Class that performs the subtraction function.
     */
    public class Subtraction implements ActionListener
    {
        /**
         * ActionEvent for subtraction.
         * 
         * @param e
         *            takes the listener.
         */
        public void actionPerformed(ActionEvent e)
        {
            // catch number format exception
            try
            {
                double n1 = Double.parseDouble(leftOperand.getText());
                double n2 = Double.parseDouble(rightOperand.getText());
                double ans = n1 - n2;
                resultLabel.setText("Result = " + ans);
            }
            catch (Exception ee)
            {
                resultLabel.setText("Result = Error");
            }
        }
    }

    /**
     * Class that performs the division function.
     */
    public class Division implements ActionListener
    {
        /**
         * ActionEvent for division.
         * 
         * @param e
         *            takes the listener.
         */
        public void actionPerformed(ActionEvent e)
        {
            // catch number format exception
            try
            {
                double n1 = Double.parseDouble(leftOperand.getText());
                double n2 = Double.parseDouble(rightOperand.getText());

                if (n2 == 0)
                {
                    resultLabel.setText("Result = Error");
                }
                else
                {
                    double ans = n1 / n2;
                    resultLabel.setText("Result = " + ans);
                }
            }
            catch (Exception ee)
            {
                resultLabel.setText("Result = Error");
            }
        }
    }

    /**
     * Class that performs the multiplication function.
     */
    public class Multiplication implements ActionListener
    {
        /**
         * ActionEvent for multiplication.
         * 
         * @param e
         *            takes the listener.
         */
        public void actionPerformed(ActionEvent e)
        {
            // catch number format exception
            try
            {
                double n1 = Double.parseDouble(leftOperand.getText());
                double n2 = Double.parseDouble(rightOperand.getText());
                double ans = n1 * n2;
                resultLabel.setText("Result = " + ans);
            }
            catch (Exception ee)
            {
                resultLabel.setText("Result = Error");
            }
        }
    }

    /**
     * Getter for the frame.
     * 
     * @return returns the frame.
     */
    public JFrame getFrame()
    {
        return frame;
    }

    /**
     * Main method, creates the calculator object.
     * 
     * @param args
     *            String
     */
    public static void main(String[] args)
    {
        Calculator calc = new Calculator();
    }
}
