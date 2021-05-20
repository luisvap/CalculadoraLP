
package br.uniso;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Calculadora extends JFrame implements ActionListener {

    static JFrame f;


    static JTextField l;


    String s0 = "";
    String s1 = "";
    String s2 = "";



    // main function
    public static void main(String args[])
    {

        f = new JFrame("calculator");

        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }


        Calculadora c = new Calculadora();


        l = new JTextField(16);


        l.setEditable(false);


        JButton b1, b2,  ba, be, beq, beq1;



        b1 = new JButton("1");
        b2 = new JButton("2");


        beq1 = new JButton("=");

        ba = new JButton("+");

        beq = new JButton("C");


        be = new JButton(".");


        JPanel p = new JPanel();


        ba.addActionListener(c);

        b2.addActionListener(c);
        b1.addActionListener(c);

        be.addActionListener(c);
        beq.addActionListener(c);
        beq1.addActionListener(c);

        // add elements to panel
        p.add(l);
        p.add(ba);
        p.add(b1);
        p.add(b2);

        p.add(be);

        p.add(beq);
        p.add(beq1);


        p.setBackground(Color.GRAY);


        f.add(p);

        f.setSize(200, 220);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();


        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {

            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;


            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {

            s0 = s1 = s2 = "";


            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == '=') {

            double te;


                te = (Double.parseDouble(s0) + Double.parseDouble(s2));



            l.setText(s0 + s1 + s2 + "=" + te);


            s0 = Double.toString(te);

            s1 = s2 = "";
        }
        else {

            if (s1.equals("") || s2.equals(""))
                s1 = s;

            else {
                double te;


                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));


                s0 = Double.toString(te);


                s1 = s;

                s2 = "";
            }


            l.setText(s0 + s1 + s2);
        }
    }
}

