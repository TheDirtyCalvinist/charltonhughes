package com.charltonHughes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class MVPGui here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MVPGui {
    private JFrame frame;
    private JLabel label;
    private JButton button1, button2, button3, button4, button5;
    private JPanel panel, panelLeft, panelRight, panel3;
    private JTextArea textArea, textAreaLeft, textAreaRight;
    private JScrollPane scrollArea;
    private JTextField firstName, lastName, teamName;

    public String name;

    public static void main(String args[]) {
        MVPGui guiLayout = new MVPGui();
        guiLayout.start();
    }

    public void start() {
        frame = new JFrame("MVP GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        label = new JLabel("Type the first name of an NFL MVP in the left text box");
        contentPane.add(label, BorderLayout.NORTH);

        panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        button1 = new JButton("Search by FIRST Name");
        panel.add(button1);
        button1.addActionListener(new FirstName());

        button2 = new JButton("Search by LAST Name");
        panel.add(button2);
        button2.addActionListener(new LastName());

        button3 = new JButton("Search by TEAM Name");
        panel.add(button3);
        button3.addActionListener(new TeamName());

        button4 = new JButton("CLEAR TEXT");
        panel.add(button4);
        button4.addActionListener(new ClearText());


        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(6, 1));
        panel3.setPreferredSize(new Dimension(160, 0));

        JLabel first = new JLabel("first name");
        panel3.add(first);
        firstName = new JTextField("", 3);
        panel3.add(firstName);

        JLabel last = new JLabel("last name");
        panel3.add(last);
        lastName = new JTextField("", 3);
        panel3.add(lastName);

        JLabel team = new JLabel("team");
        panel3.add(team);
        teamName = new JTextField("", 3);
        panel3.add(teamName);

        contentPane.add(panel3, BorderLayout.WEST);


        textAreaRight = new JTextArea(10, 25);
        contentPane.add(textAreaRight, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }

    String text;

    private class FirstName implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            name = firstName.getText();
            MVPData Search = new MVPData(name, MVPData.SearchType.FIRST_NAME);
            textAreaRight.setText(Search.MVPList());
        }
    }

    private class LastName implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            name = lastName.getText();
            MVPData Search = new MVPData(name, MVPData.SearchType.LAST_NAME);
            textAreaRight.setText(Search.MVPList());
        }
    }

    private class TeamName implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            name = teamName.getText();
            MVPData Search = new MVPData(name, MVPData.SearchType.TEAM_NAME);
            textAreaRight.setText(Search.MVPList());
        }
    }

    private class ClearText implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            firstName.setText("");
            lastName.setText("");
            teamName.setText("");
            textAreaRight.setText("");
        }
    }


}
    




