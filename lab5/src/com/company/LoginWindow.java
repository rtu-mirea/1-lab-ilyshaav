package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class LoginWindow extends JFrame implements ActionListener {

    public Student CurrU = new Student();
    Registr R = new Registr();
    int NO=0;


    //Для того, чтобы впоследствии обращаться к содержимому текстовых полей, надо сделать их членами класса окна
    JTextField loginField;
    JPasswordField passwordField;
    JButton ok;
    JButton cancel;

    LoginWindow() {
        super("Вход в систему");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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
        if (e.getSource() == ok) {

            if (loginField.getText() != "ilyshaav" && passwordField.getText() != "dwjg3954") {
                System.out.println(R.indexU);
                CurrU = R.a;
                JOptionPane.showMessageDialog(null, "Добро пожаловать," + loginField.getText() + "!", "Вход выполнен", JOptionPane.PLAIN_MESSAGE);
                dispose();
                new Menu();

            } else {
                for (int i = 0; i < R.indexU; i++) {

                    if (R.Users[i].Enter(loginField.getText(), passwordField.getText())) {
                        JOptionPane.showMessageDialog(null, "Добро пожаловать," + loginField.getText() + "!", "Вход выполнен", JOptionPane.PLAIN_MESSAGE);
                        CurrU = R.Users[i];
                        dispose();
                        new Menu();
                    } else {
                        NO++;
                    }

                    if (NO == R.indexU) {
                        JOptionPane.showMessageDialog(null, "Такого аккаунта не существует!", "Ошибка", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        }
        if (e.getSource() == cancel) {
            dispose();
        }
    }
}