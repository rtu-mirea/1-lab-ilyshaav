package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Menu extends JFrame implements ActionListener {

    LoginWindow LW = new LoginWindow();
    AddQ AQ = new AddQ();
    Results Res = new Results();
    Registr R = new Registr();


    //Для того, чтобы впоследствии обращаться к содержимому текстовых полей, надо сделать их членами класса окна
    JButton newQ;
    JButton res;
    JButton exit;

    Menu() {
        super("Меню");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Настраиваем первую горизонтальную панель
        Box box1 = Box.createHorizontalBox();
        newQ = new JButton("Добавить проект");
        box1.add(newQ);
        box1.add(Box.createHorizontalStrut(6));

        Box box3 = Box.createHorizontalBox();
        res = new JButton("Посмотреть результаты");
        box3.add(res);
        box3.add(Box.createHorizontalStrut(12));

        Box box4 = Box.createHorizontalBox();
        exit = new JButton("Выход");
        box4.add(exit);
        box4.add(Box.createHorizontalStrut(12));

        //Слушатели
        newQ.addActionListener(this);
        res.addActionListener(this);
        exit.addActionListener(this);

        // Уточняем размеры компонентов loginLabel.setPreferredSize(passwordLabel.getPreferredSize());
        // Размещаем три горизонтальные панели на одной вертикальной
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box3);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box4);
        setContentPane(mainBox);
        pack();
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newQ) {
            if(LW.CurrU == R.a){
                JOptionPane.showMessageDialog(null, "Вам не доступна эта функция, Вы не администратор", "Отказ доступа", JOptionPane.PLAIN_MESSAGE);
            }
            else{
                new AddQ();
            }
        }

        if (e.getSource() == res) {
            new Results();
        }
        if (e.getSource() == exit) {
            dispose();
        }
    }
}