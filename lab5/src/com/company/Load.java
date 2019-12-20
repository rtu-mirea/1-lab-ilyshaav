package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Load extends JFrame {
    private JFileChooser fileChooser = new JFileChooser();
    Results res = new Results();

    Load() {
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.showOpenDialog(this);

        try {
            FileInputStream inp = new FileInputStream(fileChooser.getSelectedFile());
            ObjectInputStream ser = new ObjectInputStream(inp);
            Project q = (Project) ser.readObject();
            ser.close();
            Load.this.dispose();
            JOptionPane.showMessageDialog(null, "Загружено", "", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
            JOptionPane.showMessageDialog(null, "Ошибка", "", JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка", "", JOptionPane.PLAIN_MESSAGE);
        }
    }
}