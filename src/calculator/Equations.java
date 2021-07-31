package calculator;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Equations extends JPanel {

    public JButton display;
    public JPanel buttonsPanel;
    private boolean start;
    private String lastCommand;
    private double result;
    
    public Equations() {
        
        setLayout(new BorderLayout());
        display = new JButton();
        display.setFont(new Font("Arial", Font.BOLD, 26) {
        });
        display.setText("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);
        
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 4, 2, 2));
            
        NumberButtonPress number = new NumberButtonPress();
        CommandButtonPress command = new CommandButtonPress();
        start = true;
        lastCommand = "=";
        result = 0;
        
        addButton("7", number);
        addButton("8", number);
        addButton("9", number);
        addButton("+", command);
        
        addButton("4", number);
        addButton("5", number);
        addButton("6", number);
        addButton("-", command);
        
        addButton("1", number);
        addButton("2", number);
        addButton("3", number);
        addButton("*", command);
        
        addButton(".", number);
        addButton("0", number);
        addButton("/", command);
        addButton("=", command);
        
        add(buttonsPanel, BorderLayout.CENTER);
    }
    
    private void addButton(String name, ActionListener listener) {
        JButton button = new JButton(name);
        button.setFont(new Font("Arial", Font.BOLD, 20) {
        });
        button.addActionListener(listener);
        buttonsPanel.add(button);        
    }
    
    private class NumberButtonPress implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String number = e.getActionCommand();
            if (start) {
                display.setText("");
                start = false;
            } 
            if (number != "." || display.getText().indexOf(".") == -1) {
                display.setText(display.getText() + number);
            }  
        }
    }
    
    private class CommandButtonPress implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            if (start) {
                lastCommand = action;
            } else { 
                Double parse = Double.parseDouble(display.getText());
                calculations(parse);
                lastCommand = action;
                start = true;
            }
        }

        private void calculations(Double x) {
            if (lastCommand.equals("=")) result = x;
            else if (lastCommand.equals("+")) result += x; 
            else if (lastCommand.equals("-")) result -= x; 
            else if (lastCommand.equals("*")) result *= x; 
            else if (lastCommand.equals("/")) result /= x;
            display.setText(" " + result);
        }
    }
}