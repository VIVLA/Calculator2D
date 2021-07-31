package calculator;

import javax.swing.JFrame;

public class Window extends JFrame {
        
    public Window() {
        initFrame(); 
    } 
    
    private void initFrame() {
        pack();
        setSize(320, 440);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setResizable(false);
        setLocationRelativeTo(null);
        add(new Equations());
    }
}