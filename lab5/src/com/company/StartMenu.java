package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class StartMenu extends JFrame implements ActionListener {

    JButton registration;
    JButton enter;
    JButton exit;
    LoginWindow window = new LoginWindow();
    Registr regist = new Registr();


    StartMenu(){
        super("Добро пожаловать");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Настраиваем первую горизонтальную панель
        Box box1 = Box.createHorizontalBox();
        registration = new JButton("Регистрация");
        box1.add(registration);
        box1.add(Box.createHorizontalStrut(30));

        // Настраиваем вторую горизонтальную панель
        Box box2 = Box.createHorizontalBox();
        enter = new JButton("Вход");
        box2.add(enter);
        box2.add(Box.createHorizontalStrut(30));

        Box box3 = Box.createHorizontalBox();
        exit = new JButton("Выход");
        box3.add(exit);
        box3.add(Box.createHorizontalStrut(30));

        //Слушатели
        registration.addActionListener(this);
        enter.addActionListener(this);
        exit.addActionListener(this);

        // Уточняем размеры компонентов loginLabel.setPreferredSize(passwordLabel.getPreferredSize());
        // Размещаем три горизонтальные панели на одной вертикальной
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(70, 50, 70, 50));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);
        setContentPane(mainBox);
        pack();
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "";
        if (e.getSource() == registration) {
            regist.setVisible(true);
        }
        if (e.getSource() == enter) {
            window.setVisible(true);
        }
        if (e.getSource() == exit) {
            dispose();
        }
    }
}