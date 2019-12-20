package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;


class Registr extends JFrame implements ActionListener {

    public Student[] Users = new Student[100];
    public int indexU = 1;
    Student a = new Student("Ilya", "ilyshaav", "dwjg3954", 0, 0, true);


    //Для того, чтобы впоследствии обращаться к содержимому текстовых полей, надо сделать их членами класса окна
    JTextField loginField;
    JTextField nameField;
    JPasswordField passwordField;
    JButton ok;
    JButton cancel;

    Registr() {
        super("Регистрация");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Box box = Box.createHorizontalBox();
        JLabel NameLabel = new JLabel("Имя:    ");
        nameField = new JTextField(15);
        box.add(NameLabel);
        box.add(Box.createHorizontalStrut(6));
        box.add(nameField);

        // Настраиваем первую горизонтальную панель (для ввода логина)
        Box box1 = Box.createHorizontalBox();
        JLabel loginLabel = new JLabel("Логин:    ");
        loginField = new JTextField(15);
        box1.add(loginLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(loginField);

        // Настраиваем вторую горизонтальную панель (для ввода пароля)
        Box box2 = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("Пароль:");
        passwordField = new JPasswordField(15);
        box2.add(passwordLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(passwordField);

        // Настраиваем третью горизонтальную панель (с кнопками)
        Box box3 = Box.createHorizontalBox();
        ok = new JButton("OK");
        cancel = new JButton("Отмена");
        box3.add(Box.createHorizontalGlue());
        box3.add(ok);
        box3.add(Box.createHorizontalStrut(12));
        box3.add(cancel);

        //Слушатели
        ok.addActionListener(this);
        cancel.addActionListener(this);

        // Уточняем размеры компонентов loginLabel.setPreferredSize(passwordLabel.getPreferredSize());
        // Размещаем три горизонтальные панели на одной вертикальной
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(box);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);
        setContentPane(mainBox);
        pack();
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Users[0] = a;
        if (e.getSource() == ok) {
            JOptionPane.showMessageDialog(null, "Регистрация прошла успешно", "Сообщение", JOptionPane.PLAIN_MESSAGE);
            Student u = new Student(nameField.getText(), loginField.getText(), passwordField.getText(), 0, 0, false);
            Users[indexU] = u;
            indexU++;
            dispose();
        }
        if (e.getSource() == cancel) {
            dispose();
        }
    }
}