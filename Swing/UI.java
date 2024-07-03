package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    JFrame window = new JFrame("physics");
    JTextField tfmass = new JTextField("enter mass");
    JTextField tfacceleration = new JTextField("enter acceleration");
    JButton calculate = new JButton("calculate");

    void drawUI() {
        window.add(tfmass);
        window.add(tfacceleration);
        window.add(calculate);
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // typical try and catch exceptions as i learned in python
                try {
                    float mass = Float.valueOf(tfmass.getText());
                    float acceleration = Float.valueOf(tfacceleration.getText());
                    JOptionPane.showMessageDialog(null, Physics.calculateForce(mass, acceleration));
                    System.out.println("mass = " + mass);
                    System.out.println("acceleration = " + acceleration);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "enter a numeric value");
                    nfe.printStackTrace();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "something strange has happened");
                }

            }
        });
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(3, 1));
        window.setSize(200, 250);

    }
}
