package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


class Results extends JFrame implements ActionListener, Serializable {


    LoginWindow LW = new LoginWindow();
    AddQ RESULT = new AddQ();

    //Для того, чтобы впоследствии обращаться к содержимому текстовых полей, надо сделать их членами класса окна
    JButton cancel;
    JButton save;
    JButton load;

    Results() {
        super("Результаты");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Настраиваем первую горизонтальную панель (для ввода логина)
        Box box1 = Box.createHorizontalBox();
        JLabel QLabel = new JLabel("Список победителей " +RESULT.GS.generateResult());
        box1.add(QLabel);
        box1.add(Box.createHorizontalStrut(6));



        // Настраиваем третью горизонтальную панель (с кнопками)
        Box box3 = Box.createHorizontalBox();
        cancel = new JButton("Выйти");
        box3.add(cancel);
        box3.add(Box.createHorizontalStrut(12));

        Box box4 = Box.createHorizontalBox();
        save = new JButton("Сохранить");
        box4.add(save);
        box4.add(Box.createHorizontalStrut(12));

        Box box5 = Box.createHorizontalBox();
        load = new JButton("Загрузить");
        box5.add(load);
        box5.add(Box.createHorizontalStrut(12));

        //Слушатели
        cancel.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);

        // Уточняем размеры компонентов loginLabel.setPreferredSize(passwordLabel.getPreferredSize());
        // Размещаем три горизонтальные панели на одной вертикальной
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(50, 50, 50, 50));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box4);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box5);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);
        setContentPane(mainBox);
        pack();
        setResizable(false);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            dispose();
        }
        if (e.getSource() == save) {
            try {
                Project RES = new Project(""+LW.CurrU.qcount, LW.CurrU.rightansw);
                FileOutputStream outputStream = new FileOutputStream("save.ser");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                // сохраняем  в файл
                objectOutputStream.writeObject(RES);

                //закрываем поток и освобождаем ресурсы
                objectOutputStream.close();
            }
            catch(IOException ex){

            }

        }
        if (e.getSource() == load) {
            new Load();

        }
    }
}