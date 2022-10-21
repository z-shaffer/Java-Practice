package solution;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator2
{      
    JFrame frame = new JFrame();
    
    JPanel panel = new JPanel();
    JPanel resultPanel = new JPanel();
    JPanel textPanel = new JPanel();
    
    JLabel resultLabel = new JLabel("Result = ");
    
    JButton calculateButton = new JButton("CALCULATE");
    JButton clearButton = new JButton("CLEAR");
    
    JTextField infixExpression = new JTextField(15);
    
    public Calculator2()
    {
        getFrame().setLocation(100,100);
        getFrame().setSize(400, 400);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setTitle("My Calculator");
        
        initializeComponents();
    
        getFrame().pack();
        getFrame().setVisible(true);
    }
    
    public JFrame getFrame()
    {
        return frame;
    }
    
    public void initializeComponents()
    {
        setNames();
        addButtons();
        addPanels();
        addAction();
    }
    
    public void setNames()
    {
        resultLabel.setName("resultLabel");
        calculateButton.setName("calculateButton");
        clearButton.setName("clearButton");
        infixExpression.setName("infixExpression");
    }
    
    public void addButtons()
    {
        panel.add(calculateButton);
        panel.add(clearButton);
        resultPanel.add(resultLabel);
        textPanel.add(infixExpression);
    }
    
    public void addPanels()
    {
        getFrame().add(panel, BorderLayout.PAGE_END);
        getFrame().add(resultPanel, BorderLayout.WEST);
        getFrame().add(textPanel, BorderLayout.PAGE_START);
    }
    
    public void addAction()
    {
        clearButton.addActionListener(new InnerClass());
        calculateButton.addActionListener(new InnerClass());
    }
    
    public class InnerClass implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            buttonClicked(e);
        }
    }
    
    public void buttonClicked(ActionEvent e)
    {
        String infix = infixExpression.getText();
        ExpressionEvaluator exp = new ExpressionEvaluator();
        if (infixExpression.getText().trim().equals(""))
        {
            resultLabel.setText("Result = Error");
        }
        else
        {
            if (e.getSource() == calculateButton)
            {
                try
                {
                    String postfix = exp.toPostfix(infix);
                    double answer = exp.evaluate(postfix);
                    resultLabel.setText("Result = " + answer);
                }
                catch (NumberFormatException exception)
                {
                    resultLabel.setText("Result = Error");
                }
                catch (Exception exception)
                {
                    resultLabel.setText("Result = Error");
                }
            }
            else if (e.getSource() == clearButton)
            {
                infixExpression.setText("");
            }
        }
    }
    
    public static void main(String[] args)
    {
        Calculator2 calculator = new Calculator2();
    }
}
