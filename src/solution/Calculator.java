package solution;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class Calculator
{
    private JFrame Frame;
    private JLabel resultLabel;
    // private JTextField calcText;
    private JTextField leftOperand;
    private JTextField rightOperand;
    private JTextField result;

    public Calculator()
    {
        Frame = new JFrame();
        Frame.setLocation(100, 100);
        Frame.setSize(400, 400);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setTitle("Simple Calculator");
        initializeComponents();
        Frame.pack();
        Frame.setVisible(true);
    }

    public void initializeComponents()
    {
        // Create the buttons
        JButton addButton = new JButton("ADD");
        addButton.setName("ADD");
        addButton.addActionListener(new DoTheMath());
        JButton subButton = new JButton("SUB");
        subButton.setName("SUB");
        subButton.addActionListener(new DoTheMath());
        JButton multButton = new JButton("MULT");
        multButton.setName("MULT");
        multButton.addActionListener(new DoTheMath());
        JButton divButton = new JButton("DIV");
        divButton.setName("DIV");
        divButton.addActionListener(new DoTheMath());

        // Create the button panel
        JPanel positPanel = new JPanel();

        // Add buttons to the panel
        positPanel.add(addButton);
        positPanel.add(subButton);
        positPanel.add(multButton);
        positPanel.add(divButton);

        // Add the panel to the bottom of the calculator window
        Frame.add(positPanel, BorderLayout.PAGE_END);

        // Create new label panel and result label.
        JPanel labelPanel = new JPanel();
        resultLabel = new JLabel("Result = ");

        // Add the result label to the label panel, then frame.
        labelPanel.add(resultLabel);
        Frame.add(labelPanel, BorderLayout.LINE_START);

        // Create new text field panel
        JPanel textPanel = new JPanel();

        // Create new text fields
        leftOperand = new JTextField(4);
        rightOperand = new JTextField(4);

        // Add text fields to panel, then to frame
        textPanel.add(leftOperand);
        textPanel.add(rightOperand);
        Frame.add(textPanel, BorderLayout.NORTH);

    }

    public class DoTheMath implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                double n1 = Double.parseDouble(leftOperand.getText());
                double n2 = Double.parseDouble(rightOperand.getText());
                double ans = n1 + n2;
                result.setText("" + ans);
            }
            catch (Exception ee)
            {
                result.setText("Error");
            }
            finally
            {

            }
        }

    }

    // catch number format exception
    public JFrame getFrame()
    {
        return Frame;
    }

    public static void main(String args[])
    {
        Calculator calc = new Calculator();
    }
}
