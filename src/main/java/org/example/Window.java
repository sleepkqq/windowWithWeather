package org.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame {


    private JButton button = new JButton("Узнать погоду");
    private JRadioButton radioButton1 = new JRadioButton("Сегодня");
    private JRadioButton radioButton2 = new JRadioButton("Завтра");


    public Window () {
        super("Погода");
        this.setBounds(300, 300, 400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 3, 3));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        container.add(radioButton1);
        radioButton1.setSelected(true);
        container.add(radioButton2);

        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            boolean today = radioButton1.isSelected();
            Weather weather = new Weather(today ? "today" : "tomorrow");
            String message = weather.getWeather();

            JOptionPane.showMessageDialog(null, message, "Погода на " + (today ? "Сегодня" : "Завтра"), JOptionPane.PLAIN_MESSAGE);
        }
    }

}
