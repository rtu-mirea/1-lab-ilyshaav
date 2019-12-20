package com.company;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class AddQ extends JFrame implements ActionListener {

    Registr R = new Registr();
    GrandSystem GS=new GrandSystem(4, 10000);
    public Project[] Project = new Project[100];
    public int indexQ = 0;
    //Для того, чтобы впоследствии обращаться к содержимому текстовых полей, надо сделать их членами класса окна
    JTextField QField;
    JTextField AnswField;
    JButton ok;
    JButton cancel;

    AddQ() {
        super("Добавить проект");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Настраиваем первую горизонтальную панель (для ввода логина)
        Box box1 = Box.createHorizontalBox();
        JLabel QLabel = new JLabel("Название проекта");
        QField = new JTextField(15);
        box1.add(QLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(QField);

        // Настраиваем вторую горизонтальную панель (для ввода пароля)
        Box box2 = Box.createHorizontalBox();
        JLabel AnswLabel = new JLabel("Призовой фонд");
        AnswField = new JTextField(15);
        box2.add(AnswLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(AnswField);

        // Настраиваем третью горизонтальную панель (с кнопками)
        Box box3 = Box.createHorizontalBox();
        ok = new JButton("Добавить");
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
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {

            Project q = new Project(QField.getText(), Integer.parseInt(AnswField.getText()));
            GS.addProject(q);

        }
        if (e.getSource() == cancel) {
            dispose();
        }
    }
}