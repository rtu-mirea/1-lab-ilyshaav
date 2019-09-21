package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите длину массива: ");
        int len = sc.nextInt();
        int [] arr = new  int [len];

        Array myarr = new Array();
        myarr.setArr(arr);           // инициализация поля


        System.out.println("1 - заполнение массива");
        System.out.println("2 - вывод слева направо");
        System.out.println("3 - вывод справа налево");
        System.out.println("4 - Кол-во элементов массива, явл. степенью некоторого числа ");
        System.out.println("5 - выход");
        System.out.println("6 - упорядочить");

    boolean B = true;
        while (B){
            System.out.print("Выберите операцию: ");
            switch (sc.nextInt()) {
                case  (1):
                    myarr.InputArr();            //заполнение массива
                    break;
                case (2):
                    myarr.OutArr();               //Вывод массива >
                    break;
                case (3):
                    myarr.OutArrReverse();        //Вывод массива <
                    break;
                case (4):
                    System.out.print("Введите степень: ");
                    int power = sc.nextInt();
                    System.out.print("Кол-во элементов массива, явл. степенью "+power+": "+ myarr.CountPower(power));
                    break;
                case (5):
                    B = false;
                    break;
                case (6):
                    myarr.order();
                    break;
            }
        }
        sc.close();
    }

}
