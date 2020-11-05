/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javax.swing.JFrame;

/**
 *
 * @author SK-2018
 */
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
        setVisible(true);
    }
}