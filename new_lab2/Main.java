package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean ok = true;
        while (ok) {
            Scanner in = new Scanner(System.in);
            int n;
            System.out.println("Введите 1 для работы со String\nВведите 2 для работы со StringBuffer\nВведите 3 для работы с регулярками\nвыход - 4");
            n = in.nextInt();
            switch (n) {
                case 1:
                    boolean OK = true;
                    Task1 text = new Task1();
                    text.setText();
                    while (OK) {
                        System.out.println("Текущий текст: " + text.getText());
                        System.out.println("1.Найти сумму всех чисел(десятичная система)\n2.Изменить текст\n3.Увеличить каждую цифру на 1\n4.Определить сколько чисел N-ичной системы\n5.Сформировать строку из 16-ричных чисел\n6.Выход");
                        n = in.nextInt();
                        switch (n) {
                            case 1:
                                text.changeText();
                                break;
                            case 2:
                                text = new Task1();
                                text.setText();
                                break;
                            case 3:
                                text.summone();
                                break;
                            case 4:
                                System.out.print("Введите систему счисления которая вам интересна: ");
                                n = in.nextInt();
                                text.numSistem(n);
                                break;
                            case 5:
                                System.out.println(text.newtext());
                                break;
                            case 6:
                                OK = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean OK1 = true;
                    Task2 text1 = new Task2();
                    text1.setText();
                    while (OK1){
                        System.out.println("Текущий текст: " + text1.getText());
                        System.out.println("1.Увеличить каждую цифру на 1\n2.Изменить текст\n3.Найти сумму всех чисел 8 cc\n4.заменить 10 сс на 16 сс\n5.Выход");
                        n = in.nextInt();
                        switch (n){
                            case 1:
                                text1.summone();
                                break;
                            case 2:
                                text1.setText();
                                break;
                            case 3:
                                System.out.println( text1.summ());
                                break;
                            case 4:
                                System.out.println( text1.zamena());
                                break;
                            case 5:
                                OK1 = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    boolean ko = true;
                    String task3 = "";
                    Task3 t = new Task3();
                    System.out.print("Введите текст:");
                    task3 = in.nextLine();
                    task3 = in.nextLine();
                    while (ko) {
                        System.out.println("Текущий текст: " + task3);
                        System.out.println("1.Определить является ли число 16сс\n2.удалить \n3.Выход");
                        n = in.nextInt();
                        switch (n) {
                            case 1:
                                if (t.check(task3)==1);
                                    System.out.println(task3 + "число в 16-ичной сс");
                                else;
                                    System.out.println(task3 + "число не в 16-ичной сс");
                                break;
                            case 2:
                                System.out.println(t.delete(task3))
                                break;
                            case 3:
                                ko = false;
                                break;
                        }
                    }
                    break;
                case 4:
                    ok = false;
                    break;
            }
        }
    }
}
